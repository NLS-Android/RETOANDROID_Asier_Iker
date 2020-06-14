package com.ciber.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ciber.fragments.SeeAllowancesFragment;
import com.ciber.retoandroid_asier_iker.Allowance;
import com.ciber.retoandroid_asier_iker.AllowanceAdapter;
import com.ciber.retoandroid_asier_iker.EditAllowanceActivity;
import com.ciber.retoandroid_asier_iker.OPAllowances;
import com.ciber.retoandroid_asier_iker.R;
import com.ciber.retoandroid_asier_iker.SQLLite;
import java.util.ArrayList;

public class SeeAllowancesFragment extends Fragment implements OPAllowances {

    RecyclerView idrecyclerviewAllowance;
    ArrayList<Allowance> allowanceArrayList;
    SQLLite sqlLite;
    private AllowanceAdapter allowanceAdapter;

    public SeeAllowancesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_see_allowances, container, false);
        idrecyclerviewAllowance = v.findViewById(R.id.idrecyclerviewAllowance);
        allowanceArrayList = new ArrayList<>();
        sqlLite = new SQLLite(getActivity(),"allowances",null,1);
        allowanceAdapter = new AllowanceAdapter(this, allowanceArrayList);
        RecyclerView recyclerView= v.findViewById(R.id.idrecyclerviewAllowance);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setAdapter(allowanceAdapter);
        showAllowances();
        return v;
    }

    public void showAllowances() {
        SQLiteDatabase sqLiteDatabase = sqlLite.getReadableDatabase();
        Allowance allowance = null;
        /***/
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT code, allowancename, allowancestartdate, allowanceenddate, allowancelocation, allowancetransport, allowancetravelleddistances, " +
                "allowancetollamount, allowanceparkingamount, " +
                "CASE " +
                "WHEN allowancelocation = 'Europe' THEN (allowanceparkingamount+allowancetollamount)+(allowancetravelleddistances*0.3) + ((allowanceenddate-allowancestartdate)*60) " +
                "WHEN allowancelocation = 'Out Of Europe' THEN (allowanceparkingamount+allowancetollamount)+(allowancetravelleddistances*0.3) + ((allowanceenddate-allowancestartdate)*100)  " +
                "ELSE 0 " +
                "END " +
                "FROM allowances",null);
        /***/
        while (cursor.moveToNext()) {
            allowance = new Allowance();
            allowance.setCode(cursor.getInt(0));
            allowance.setAllowancename(cursor.getString(1));
            allowance.setAllowancestartdate(cursor.getString(2));
            allowance.setAllowanceenddate(cursor.getString(3));
            allowance.setAllowancelocation(cursor.getString(4));
            allowance.setAllowancetransport(cursor.getString(5));
            allowance.setAllowancetravelleddistances(cursor.getString(6));
            allowance.setAllowancetollamount(cursor.getString(7));
            allowance.setAllowanceparkingamount(cursor.getString(8));
            allowance.setTotalprice(cursor.getString(9));
            allowanceAdapter.addAllowance(allowance);
        }
    }

    @Override
    public void OptionEditAllowance(Allowance allowance) {
        Intent intent = new Intent(getActivity(), EditAllowanceActivity.class);
        intent.putExtra("allowances", allowance);
        startActivity(intent);
    }

    @Override
    public void OptionDeleteAllowance(final Allowance allowance) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Message");
        alert.setMessage("");
        alert.setMessage("Are you sure you want to delete "+ allowance.getAllowancename()+" ?" );
        alert.setCancelable(false);
        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteAllowance(allowance);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.show();
    }
    private void deleteAllowance(Allowance allowance) {
        SQLLite sqlLite = new SQLLite(getActivity(),"allowances", null, 1);
        SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();
        String code = String.valueOf(allowance.getCode());
        if(!code.isEmpty()){
            sqLiteDatabase.delete("allowances","code="+code,null);
            Toast.makeText(getActivity(), "Correctly Removed", Toast.LENGTH_SHORT).show();
            allowanceAdapter.deleteAllowance(allowance);
            sqLiteDatabase.close();
        }else{
            Toast.makeText(getActivity(), "It could not be removed", Toast.LENGTH_SHORT).show();
        }
    }
}
