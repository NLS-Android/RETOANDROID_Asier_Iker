package com.ciber.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import com.ciber.retoandroid_asier_iker.EditExpensesActivity;
import com.ciber.retoandroid_asier_iker.Expense;
import com.ciber.retoandroid_asier_iker.ExpenseAdapter;
import com.ciber.retoandroid_asier_iker.OPExpense;
import com.ciber.retoandroid_asier_iker.R;
import com.ciber.retoandroid_asier_iker.SQLLite;
import java.util.ArrayList;

public class SeeExpensesFragment extends Fragment implements OPExpense {

    RecyclerView idrecyclerview;
    ArrayList<Expense> expenseArrayList;
    SQLLite sqlLite;
    private ExpenseAdapter expenseAdapter;

    public SeeExpensesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_see_expenses, container, false);
        idrecyclerview = v.findViewById(R.id.idrecyclerview);
        expenseArrayList = new ArrayList<>();
        sqlLite = new SQLLite(getActivity(),"expenses",null,1);
        expenseAdapter = new ExpenseAdapter(this,expenseArrayList);
        RecyclerView recyclerView= v.findViewById(R.id.idrecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setAdapter(expenseAdapter);
        showExpenses();

        return v;
    }

    public void showExpenses() {
        SQLiteDatabase sqLiteDatabase = sqlLite.getReadableDatabase();
        Expense expense = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM expenses", null);
        while (cursor.moveToNext()) {
            expense = new Expense();
            expense.setCode(cursor.getInt(0));
            expense.setExpenseName(cursor.getString(1));
            expense.setExpenseDate(cursor.getString(2));
            expense.setExpenseamount(cursor.getString(3));
            expenseAdapter.addExpense(expense);
        }
    }

    @Override
    public void OptionEdit(Expense expense) {
        Intent intent = new Intent(getActivity(), EditExpensesActivity.class);
        intent.putExtra("expenses", expense);
        startActivity(intent);
    }

    @Override
    public void OptionDelete(final Expense expense) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Message");
        alert.setMessage("");
        alert.setMessage("Are you sure you want to delete "+ expense.getExpenseName()+" ?" );
        alert.setCancelable(false);
        alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteExpense(expense);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.show();
    }

    private void deleteExpense(Expense expense) {
      SQLLite sqlLite = new SQLLite(getActivity(),"expenses", null, 1);
      SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();
      String code = String.valueOf(expense.getCode());
        if(!code.isEmpty()){
            sqLiteDatabase.delete("expenses","code="+code,null);
            Toast.makeText(getActivity(), "Correctly Removed", Toast.LENGTH_SHORT).show();
            expenseAdapter.deleteExpense(expense);
            sqLiteDatabase.close();
        }else{
            Toast.makeText(getActivity(), "It could not be removed", Toast.LENGTH_SHORT).show();
        }
    }

}
