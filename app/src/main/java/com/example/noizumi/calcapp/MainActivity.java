package com.example.noizumi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Intent intent;

    // EditTextの値を取得
    protected void getValues(){
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        intent = new Intent(this, ResultActivity.class);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 「＋」ボタンの押下
        View.OnClickListener button_plusClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                BigDecimal e1 = new BigDecimal(editText1.getText().toString());
                BigDecimal e2 = new BigDecimal(editText2.getText().toString());

                String result = e1.add(e2).toString();
                intent.putExtra("FORMULA", e1.toString()+"＋"+e2.toString()+"＝");
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }
        };
        findViewById(R.id.button_plus).setOnClickListener(button_plusClickListener);

        // 「－」ボタンの押下
        View.OnClickListener button_minusClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                BigDecimal e1 = new BigDecimal(editText1.getText().toString());
                BigDecimal e2 = new BigDecimal(editText2.getText().toString());

                String result = e1.subtract(e2).toString();
                intent.putExtra("FORMULA", e1.toString()+"－"+e2.toString()+"＝");
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }
        };
        findViewById(R.id.button_minus).setOnClickListener(button_minusClickListener);

        // 「×」ボタンの押下
        View.OnClickListener button_mulClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                BigDecimal e1 = new BigDecimal(editText1.getText().toString());
                BigDecimal e2 = new BigDecimal(editText2.getText().toString());

                String result = e1.multiply(e2).toString();
                intent.putExtra("FORMULA", e1.toString()+"×"+e2.toString()+"＝");
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }
        };
        findViewById(R.id.button_mul).setOnClickListener(button_mulClickListener);

        // 「÷」ボタンの押下
        View.OnClickListener button_divClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();

                BigDecimal e1 = new BigDecimal(editText1.getText().toString());
                BigDecimal e2 = new BigDecimal(editText2.getText().toString());

                String result;
                if(e2.doubleValue() != 0.0) {
                    result = e1.divide(e2,3, RoundingMode.HALF_UP).toString();
                }else {
                    result ="0で除算はできません。";
                }
                intent.putExtra("FORMULA", e1.toString()+"÷"+e2.toString()+"＝");
                intent.putExtra("RESULT", result);
                startActivity(intent);
            }
        };
        findViewById(R.id.button_div).setOnClickListener(button_divClickListener);

    }

}
