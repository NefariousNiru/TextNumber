package com.example.textnumber;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.Year;

public class InfoActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView info = findViewById(R.id.infoText);
        String display = "Created and Developed by \nNirupom Bose Roy \n2022 - %s \nIndia\n\n\n\n\n\n\nContact me by clicking the Email button on the Homepage";
        info.setText(String.format(display, Year.now()));
    }
}