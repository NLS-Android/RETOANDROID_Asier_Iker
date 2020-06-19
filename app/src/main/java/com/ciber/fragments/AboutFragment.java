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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.ciber.retoandroid_asier_iker.R;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor

    }
    private Button Bcall, Bgeo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        Bcall = (Button) v.findViewById(R.id.btn_call);
        Bgeo = (Button) v.findViewById(R.id.btn_geolocalitation);
        Bcall.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                opencall();
            }
        } );
        Bgeo.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                opengeo();
            }
        } );
        return v;
    }

    private void opengeo() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else{
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }

    }

    public void opencall(){
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
