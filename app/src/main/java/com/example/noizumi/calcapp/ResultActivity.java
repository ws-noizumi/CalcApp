package com.example.noizumi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String fomula = intent.getStringExtra("FORMULA");
        String result = intent.getStringExtra("RESULT");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(fomula.toString()+result.toString());
    }
}
