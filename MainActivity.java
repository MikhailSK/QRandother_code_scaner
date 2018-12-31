package com.example.mikha.qr_code;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scan_change = findViewById(R.id.button_scan);
        Button nBTNClick = findViewById(R.id.button_generate);

        scan_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_scan = new Intent(MainActivity.this, Main_scan_Activity.class);
                startActivity(intent_scan);
            }

        });

        nBTNClick.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent intent_generator = new Intent(MainActivity.this, Generator_Activity.class);
                startActivity(intent_generator);
            }
        });
    }
}
