package com.bignerdranch.android.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.setWebViewClient(new WebViewClient());

        /* allow me to access native code from my javascript */
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");

        /* please allow javascript inside the webview */
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        /* let the show begin */
        myWebView.loadUrl("http://www.toledo.com/index.php?src=directory&view=GigGuide&srctype=App_GigGuide_lister");

    }
}
