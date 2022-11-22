package com.example.textnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number = findViewById(R.id.number);
                String no = number.getText().toString();
                Boolean valid = true;
                for(int i= 0;i<no.length();i++){
                    valid = Character.isDigit(no.charAt(i));
                    if(valid == false){
                        break;
                    }
                }
                if (no.length() < 5 || no.length() > 15 || valid == false) {
                    Toast.makeText(getApplicationContext(), "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
                else {
                    CountryCodePicker ccp = findViewById(R.id.ccp);
                    String cc = ccp.getSelectedCountryCode();
                    String url = "https://wa.me/"+cc+no;
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("URL",url);
                    startActivity(intent);
                }
            }
        });
        ImageButton info = findViewById(R.id.infoButton);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                startActivity(intent);
            }
        });
        ImageButton mail = findViewById(R.id.emailButton);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
//                intent.setType("message/rfc882");
                String to = "nirupomboseroy99@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Query: No Save Text ");
                startActivity(intent);
            }
        });
    }
}