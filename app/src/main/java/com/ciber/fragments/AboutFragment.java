package com.ciber.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.ciber.retoandroid_asier_iker.R;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor

    }
    private Button Bcall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        Bcall = (Button) v.findViewById(R.id.btn_call);
        Bcall.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                open();
            }
        } );
        return v;
    }
    public void open(){
        try
        {
            if(Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "1515"));
                startActivity(callIntent);
            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + "1515"));
                startActivity(callIntent);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
