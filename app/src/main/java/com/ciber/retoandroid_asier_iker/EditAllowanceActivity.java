package com.ciber.retoandroid_asier_iker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.ciber.fragments.SeeAllowancesFragment;
import com.ciber.fragments.SeeExpensesFragment;

public class EditAllowanceActivity extends AppCompatActivity {

    private AllowanceAdapter allowanceAdapter;
    private EditText txt_Allowance_Code, txt_Allowance_Name, txt_Allowance_Start_Date, txt_Allowance_End_Date, txt_Travelled_Distances, txt_Toll_Amount, txt_Parking_Amount;
    private Spinner spinner_Location, spinner_Transport;
    private Allowance allowance;
    private Button button_allowances_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_allowance);

        txt_Allowance_Code = findViewById(R.id.txt_Allowance_Code);
        txt_Allowance_Name = findViewById(R.id.txt_Allowance_Name);
        txt_Allowance_Start_Date = findViewById(R.id.txt_Allowance_Start_Date);
        txt_Allowance_End_Date = findViewById(R.id.txt_Allowance_End_Date);
        spinner_Location = findViewById(R.id.spinner_Location);
        spinner_Transport = findViewById(R.id.spinner_Transport);
        txt_Travelled_Distances = findViewById(R.id.txt_Travelled_Distances);
        txt_Toll_Amount = findViewById(R.id.txt_Toll_Amount);
        txt_Parking_Amount = findViewById(R.id.txt_Parking_Amount);

        button_allowances_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditData(v);
            }
        });
        allowance=(Allowance) getIntent().getSerializableExtra("allowances");
        FillData();
    }

    private void FillData(){
        txt_Allowance_Code.setText(String.valueOf(allowance.getCode()));
        txt_Allowance_Code.setEnabled(false);
        txt_Allowance_Name.setText(allowance.getAllowancename());
        txt_Allowance_Start_Date.setText(allowance.getAllowancestartdate());
        txt_Allowance_End_Date.setText(allowance.getAllowanceenddate());
        /**spinner_Location.getSelectedItem(allowance.getAllowancelocation());
        spinner_Transport.getSelectedItem(allowance.getAllowancetransport());*/
        txt_Travelled_Distances.setText(allowance.getAllowancetravelleddistances());
        txt_Toll_Amount.setText(allowance.getAllowancetollamount());
        txt_Parking_Amount.setText(allowance.getAllowanceparkingamount());
    }

    private void EditData(View v) {
        SQLLite sqlLite = new SQLLite(this,"allowances",null,1);
        SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();
        Integer code = Integer.parseInt(txt_Allowance_Code.getText().toString());
        String allowancename = txt_Allowance_Name.getText().toString();
        String allowancestartdate = txt_Allowance_Start_Date.getText().toString();
        String allowanceenddate = txt_Allowance_End_Date.getText().toString();
        String allowancelocation = spinner_Location.getSelectedItem().toString();
        String allowancetransport = spinner_Transport.getSelectedItem().toString();
        String allowancetravelleddistances = txt_Travelled_Distances.getText().toString();
        String allowancetollamount = txt_Toll_Amount.getText().toString();
        String allowanceparkingamount = txt_Parking_Amount.getText().toString();

        ContentValues values = new ContentValues();
        values.put("code", code);
        values.put("allowancename", allowancename);
        values.put("allowancestartdate", allowancestartdate);
        values.put("allowanceenddate", allowanceenddate);
        values.put("allowancelocation", allowancelocation);
        values.put("allowancetransport", allowancetransport);
        values.put("allowancetravelleddistances", allowancetravelleddistances);
        values.put("allowancetollamount", allowancetollamount);
        values.put("allowanceparkingamount", allowanceparkingamount);

        sqLiteDatabase.update("allowances", values, "code="+code,null);
        sqLiteDatabase.close();

        Toast.makeText(this, "Data Edited",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditAllowanceActivity.this, SeeAllowancesFragment.class);
        startActivity(intent);
    }
}