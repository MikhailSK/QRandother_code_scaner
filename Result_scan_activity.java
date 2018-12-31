package com.example.mikha.qr_code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Result_scan_activity extends AppCompatActivity {
    private TextView Result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan_activity);
        Result_text = findViewById(R.id.Result_text_main);
        Result_text.setText(Main_scan_Activity.Result_text);
    }
}
