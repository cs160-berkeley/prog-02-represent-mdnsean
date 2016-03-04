package com.seanwin.represent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String ZIP_CODE = "com.seanwin.represent.ZIP_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goButton = (Button) findViewById(R.id.go_btn);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zipCode = ((TextView)findViewById(R.id.input_zip_code)).getText().toString();

                Intent intent = new Intent(MainActivity.this, CongressActivity.class);
                Log.d("T", "From Main main, zipCode = " + zipCode);
                intent.putExtra("ZIP_CODE", zipCode);
                startActivity(intent);

                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                sendIntent.putExtra("ZIP_CODE", zipCode);
                startService(sendIntent);
            }
        });
    }
}
