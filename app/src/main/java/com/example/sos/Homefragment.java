package com.example.sos;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sos.modal.Contact;

import java.io.Serializable;
import java.util.ArrayList;

public class Homefragment extends Fragment {

    Button helpButton;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);


        final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.siren);

        helpButton = (Button) view.findViewById(R.id.helpButton);


        helpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sendSMS();
                if (mp.isPlaying()) {
                    mp.pause();
                } else
                    mp.start();

        }

});
        return view;
    }

    private void sendSMS() {


        ArrayList<contacts> recipient = new ArrayList<contacts>();
        GPStracker g = new GPStracker(getActivity().getApplicationContext());
        Location l = g.getLocation();
        if (l != null){
            double lat = l.getLatitude();
            double lon = l.getLongitude();
            String message="http://maps.google.com/maps?saddr="+lat+","+lon;
            java.util.ArrayList<contacts> phoneNo = recipient;
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(String.valueOf(phoneNo), null, message, null,null);
        }
                /*Create the intent.
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                // Set the data for the intent as the phone number.
                smsIntent.setData(Uri.parse(phoneNo));
                // Add the message (sms) with the key ("sms_body").
                smsIntent.putExtra("sms_body", message);
                // If package resolves (target app installed), send intent.
                if (smsIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(smsIntent);
                } else {
                    Log.e(TAG, "Can't resolve app for ACTION_SENDTO Intent");
                }*/
    }
}

