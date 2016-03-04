package com.seanwin.represent;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by Sean Nguyen on 3/1/2016.
 */
public class WatchListenerService extends WearableListenerService {
    // In PhoneToWatchService, we passed in a path, either "/FRED" or "/LEXY"
    // These paths serve to differentiate different phone-to-watch messages
    private static final String ZIP_STR = "/zip";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in WatchListenerService, got: " + messageEvent.getPath());

        if( messageEvent.getPath().equalsIgnoreCase(ZIP_STR) ) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, WatchCongress.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("ZIP_CODE", value);
            Log.d("T", "about to start WatchCongress activity with ZIP_CODE: ");
            startActivity(intent);
        } else {
            super.onMessageReceived( messageEvent );
        }

    }
}
