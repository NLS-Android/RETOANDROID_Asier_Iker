package com.ciber.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ciber.retoandroid_asier_iker.R;


public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor

    }
    private Button Bcall;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        Bcall = (Button) v.findViewById(R.id.boton_call);
        Bcall.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                open();

            }
        } );
        return v;

    }

    public void open (){
        AlertDialog.Builder builder = new AlertDialog.Builder (getActivity());
        builder.setMessage ( "Quieres llamar a soporte?" );
        builder.setPositiveButton ( "si", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText ( getContext (), "Ha pulsado si",
                        Toast.LENGTH_SHORT ).show ();
                //LLAMAR?
                //Intent callIntent =new Intent(Intent.ACTION_CALL);
                //callIntent.setData( Uri.parse("tel:1515"));
                //startActivity(callIntent);

            }

        } );
        builder.setNegativeButton ( "no", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText ( getContext (), "Ha pulsado no",
                        Toast.LENGTH_SHORT ).show ();
            }
        } );
        builder.show ();


    }
}
