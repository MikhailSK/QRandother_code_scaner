package com.example.mikha.qr_code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import static android.widget.Toast.LENGTH_LONG;

public class Main_scan_Activity extends AppCompatActivity {
    public static String Result_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scan_);
        final Button scan_btn = findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setOrientationLocked(false);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("");
                integrator.setCameraId(0);
                integrator.setOrientationLocked(false);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int result_code_scan, Intent data){
        IntentResult result_scan = IntentIntegrator.parseActivityResult(requestCode, result_code_scan, data);
        if (result_scan != null){
            if(result_scan.getContents() == null){
                Toast.makeText(this, "No scanned", LENGTH_LONG).show();
            }
            else{
                Result_text = result_scan.getContents();
                Intent result_scan_text = new Intent(Main_scan_Activity.this, Result_scan_activity.class);
                startActivity(result_scan_text);
            }}
        else{
            super.onActivityResult(requestCode, result_code_scan, data);
        }
    }
}
