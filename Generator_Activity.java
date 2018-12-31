package com.example.mikha.qr_code;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Generator_Activity extends AppCompatActivity {
    EditText text;
    Button gen_batton;
    ImageView image;
    String main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator_);
        text = findViewById(R.id.enter_text_gen);
        gen_batton = findViewById(R.id.generate_button);
        image = findViewById(R.id.image);
        gen_batton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    main_text = text.getText().toString().trim();
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(main_text, BarcodeFormat.QR_CODE, 200, 200);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        image.setImageBitmap(bitmap);
                        text.setText("");
                    }
                    catch (WriterException e) {
                            e.printStackTrace();
                    }
                }
                catch (IllegalArgumentException exceptionObject){
                    int k = 0;
                }
            }
        });
    }
}
