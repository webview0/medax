package com.thriveim.medax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {
    private final String TAG = "splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "splashing up!");

        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
