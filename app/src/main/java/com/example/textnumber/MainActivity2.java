package com.example.textnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        String url = null;
        if(extras!=null){
            url = extras.getString("URL");
        }
        WebView wb = findViewById(R.id.webView1);
        // done to use javascript and enable things like mailto: , whatsapp: etc
        //returns false if generic email
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url == null || url.startsWith("http://") || url.startsWith("https://")) return false;
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    view.getContext().startActivity(intent);
                    return true;
                } catch (Exception e) {
                    Log.i("Exeception", "shouldOverrideUrlLoading Exception:" + e);
                    return true;
                }
            }
        });
        // Enable Javascript
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Use remote resource

        wb.loadUrl(url);
    }
}