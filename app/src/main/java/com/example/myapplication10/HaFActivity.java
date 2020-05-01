package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HaFActivity extends AppCompatActivity {

    private Button mbtnQ1;
    private Button mbtnQ2;
    private Button mbtnFb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ha_f);

        mbtnQ1 = findViewById(R.id.QA1);
        mbtnQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HaFActivity.this, Q1.class);
                startActivity(intent);
            }
        });

        mbtnQ2 = findViewById(R.id.QA2);
        mbtnQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HaFActivity.this, Q2.class);
                startActivity(intent);
            }
        });

        mbtnFb = findViewById(R.id.fb);
        mbtnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HaFActivity.this, Feedback.class);
                startActivity(intent);
            }
        });
    }
}
