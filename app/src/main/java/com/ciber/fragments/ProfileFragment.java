package com.ciber.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ciber.retoandroid_asier_iker.R;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        Calendar calendar = Calendar.getInstance();
        Date date = new Date ();
        SimpleDateFormat h=new SimpleDateFormat ("h:mm:a");
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String sdate = h.format (date);
        TextView textViewDate = v.findViewById(R.id.lastconnection);
        textViewDate.setText(currentDate);
        TextView hour = v.findViewById(R.id.lastconnection_hour);
        hour.setText(sdate);
        return v;
    }
}
