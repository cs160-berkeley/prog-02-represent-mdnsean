package com.seanwin.represent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CongressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congress);

        Intent intent = getIntent();
        String zipCode = intent.getStringExtra("ZIP_CODE");
        Log.d("T", "Now in CongressActivity, zipCode = " + zipCode);
        TextView textView = (TextView) findViewById(R.id.zip);
        textView.setText(zipCode);
    }

}
