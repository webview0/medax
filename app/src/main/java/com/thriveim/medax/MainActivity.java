package com.thriveim.medax;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.thriveim.medax.R;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "mainactivity";
    private final String url = "http://www.medaxiom.com/index.php?src=directory&view=ResourceCenter&srctype=ResourceCenter";

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Extract data included in the Intent
            String m = intent.getStringExtra("message");

            Toast t = Toast.makeText(getApplicationContext(), m, Toast.LENGTH_LONG);
            t.setGravity(Gravity.TOP, 0, 0);
            t.show();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        // This registers mMessageReceiver to receive messages.
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mMessageReceiver,
                        new IntentFilter("message"));
    }

    @Override
    protected void onPause() {
        // Unregister since the activity is not visible
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mMessageReceiver);
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "starting up!");

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
        myWebView.loadUrl(url);
    }
}
