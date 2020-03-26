package com.example.broadcasts;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.net.URI;

public class MensajeRecibido extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras().getBoolean("connected")) {

            Intent intent2 = new Intent(intent.ACTION_CALL);
            intent2.setData(Uri.parse("tel:911"));
            if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            context.startActivity(intent2);


        } else {
            Toast.makeText(context, "NO CONECTADO", Toast.LENGTH_LONG).show();
        }
    }
}
