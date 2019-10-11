package com.example.ladiesfirst;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class HomeScreen  extends Fragment {
    Button alarm;     //button which produces sound on click
    Button send;
    SmsManager smsManager;
    private static final String TAG = "Home";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page, container, false);
        alarm = v.findViewById(R.id.sound);
        send = v.findViewById(R.id.sendSMS);
//         final MediaPlayer mp = MediaPlayer.create(this.getActivity(), R.raw.action);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        smsManager=SmsManager.getDefault();

        if(ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.SEND_SMS},2);
            Toast.makeText(this.getActivity(), "permission not granted", Toast.LENGTH_SHORT).show();
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsManager.sendTextMessage("+917767832966",null,"hello",null
                        ,null );

            }
        });
        return v;
    }


}
