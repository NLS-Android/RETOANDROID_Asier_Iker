package com.ciber.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ciber.retoandroid_asier_iker.Expense;
import com.ciber.retoandroid_asier_iker.ExpenseAdapter;
import com.ciber.retoandroid_asier_iker.R;
import com.ciber.retoandroid_asier_iker.SQLLite;
import java.util.ArrayList;

public class SeeExpensesFragment extends Fragment {

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
        expenseAdapter = new ExpenseAdapter(getActivity(),expenseArrayList);
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

}
