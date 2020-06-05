package com.ciber.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.ciber.retoandroid_asier_iker.R;
import com.ciber.retoandroid_asier_iker.SQLLite;

public class AllowancesFragment extends Fragment {

    private EditText txtAllowanceCode, txtAllowanceName, txtAllowanceStartDate, txtAllowanceEndDate, txtTravelledDistances, txtTollAmount, txtParkingAmount;
    private Spinner spinnerLocation, spinnerTransport;
    private Button btnAddAllowance;

    public AllowancesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_allowances, container, false);
        txtAllowanceCode = (EditText) v.findViewById(R.id.txtAllowanceCode);
        txtAllowanceName = (EditText) v.findViewById(R.id.txtAllowanceName);
        txtAllowanceStartDate = (EditText) v.findViewById(R.id.txtAllowanceStartDate);
        txtAllowanceEndDate = (EditText) v.findViewById(R.id.txtAllowanceEndDate);
        spinnerLocation = (Spinner) v.findViewById(R.id.spinnerLocation);
        spinnerTransport = (Spinner) v.findViewById(R.id.spinnerTransport);
        txtTravelledDistances = (EditText) v.findViewById(R.id.txtTravelledDistances);
        txtTollAmount = (EditText) v.findViewById(R.id.txtTollAmount);
        txtParkingAmount = (EditText) v.findViewById(R.id.txtParkingAmount);
        btnAddAllowance = (Button) v.findViewById(R.id.btnAddAllowance);
        btnAddAllowance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtAllowanceCode.getText().toString().equals("")|| txtAllowanceName.getText().toString().equals("")||txtAllowanceStartDate.getText().toString().equals("") ||
                        txtAllowanceEndDate.getText().toString().equals("") || txtTravelledDistances.getText().toString().equals("") || txtTollAmount.getText().toString().equals("") ||
                        txtParkingAmount.getText().toString().equals("")){
                    ValidateText();
                }else {
                    SaveAllowances(view);
                    CleanText();
                    Toast.makeText(getActivity(), "Allowance Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

    private void SaveAllowances(View view) {
        SQLLite sqlLite = new SQLLite(getActivity(), "allowances", null, 1);
        SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();

        int code = Integer.parseInt(txtAllowanceCode.getText().toString());
        String allowancename = txtAllowanceName.getText().toString();
        String allowancestartdate = txtAllowanceStartDate.getText().toString();
        String allowanceenddate = txtAllowanceEndDate.getText().toString();
        String spinnerlocation = spinnerLocation.getSelectedItem().toString();
        String spinnertransport = spinnerTransport.getSelectedItem().toString();
        String allowancetravelled = txtTravelledDistances.getText().toString();
        String tollamount = txtTollAmount.getText().toString();
        String parkingamount = txtParkingAmount.getText().toString();

        ContentValues values = new ContentValues();
        values.put("code", code);
        values.put("allowancename",allowancename);
        values.put("allowancestartdate",allowancestartdate);
        values.put("allowanceenddate",allowanceenddate);
        values.put("spinnerlocation",spinnerlocation);
        values.put("spinnertransport",spinnertransport);
        values.put("allowancetravelled",allowancetravelled);
        values.put("tollamount",tollamount);
        values.put("parkingamount",parkingamount);

        Long result = sqLiteDatabase.insert("allowances", null, values);
        Toast.makeText(getActivity(), "Result: " + result, Toast.LENGTH_SHORT).show();
    }

    public void ValidateText() {
        if (txtAllowanceCode.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Code Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtAllowanceName.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance Name Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtAllowanceStartDate.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance Start Date Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtAllowanceEndDate.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance End Date Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtTravelledDistances.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance Travelled Distances Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtTollAmount.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance Toll Amount Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtParkingAmount.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Allowance Parking Amount Is Missing", Toast.LENGTH_SHORT).show();
        }
    }
    private void CleanText() {
        txtAllowanceCode.setText("");
        txtAllowanceName.setText("");
        txtAllowanceStartDate.setText("");
        txtAllowanceEndDate.setText("");
        txtTravelledDistances.setText("");
        txtTollAmount.setText("");
        txtParkingAmount.setText("");
    }
}
