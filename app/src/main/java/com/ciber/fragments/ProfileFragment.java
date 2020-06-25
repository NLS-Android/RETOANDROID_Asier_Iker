package com.ciber.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ciber.retoandroid_asier_iker.DatabaseHelper;
import com.ciber.retoandroid_asier_iker.R;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProfileFragment extends Fragment {

    TextView name, surname, idcard, username,username2;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    DatabaseHelper sqlLite;
    private String user_score;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            user_score = getArguments().getString("score");
        }
    }

    public ProfileFragment() { }

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

        username2 = (TextView) v.findViewById(R.id.ED_username);
        Bundle bundle=getActivity().getIntent().getExtras();
        String value = bundle.getString("user");

        name = (TextView) v.findViewById(R.id.name_text);
        surname = (TextView) v.findViewById(R.id.surname_text);
        idcard = (TextView) v.findViewById(R.id.dnitextview);
        username = (TextView) v.findViewById(R.id.username_text);
        databaseHelper = new DatabaseHelper(getActivity());

        sqlLite = new DatabaseHelper(getActivity());
        SQLiteDatabase sqLiteDatabase = sqlLite.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM users where username = ?", new String [] {String.valueOf(value)});

        if (cursor.moveToFirst()) {
            name.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            surname.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SURNAME)));
            idcard.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_IDCARD)));
            username.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USERNAME)));
        }
        cursor.close();
        return v;
    }
}
