package com.ciber.fragments;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import com.ciber.retoandroid_asier_iker.R;
import com.ciber.retoandroid_asier_iker.SQLLite;
import android.widget.EditText;
import java.util.Calendar;

public class ExpensesFragment extends Fragment {

    private EditText txtExpenseName, txtExpenseDate, txtExpenseAmount, txtCodeExpense;
    private Button btnAddExpense;

    public ExpensesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_expenses, container, false);
        txtCodeExpense = (EditText) v.findViewById(R.id.expense_code);
        txtExpenseName = (EditText) v.findViewById(R.id.expense_name);
        txtExpenseDate = (EditText) v.findViewById(R.id.expense_date);
        txtExpenseAmount = (EditText) v.findViewById(R.id.amount_expense);
        btnAddExpense = (Button) v.findViewById(R.id.button_expenses);
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCodeExpense.getText().toString().equals("")|| txtExpenseName.getText().toString().equals("")||txtExpenseDate.getText().toString().equals("") || txtExpenseAmount.getText().toString().equals("")){
                    ValidateText();
                }else {
                    SaveExpenses(view);
                    CleanText();
                    Toast.makeText(getActivity(), "Expense Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtExpenseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year) +"-"+String.valueOf(monthOfYear) +"-"+String.valueOf(dayOfMonth);
                        txtExpenseDate.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
        return v;
    }

    public void SaveExpenses(View view) {
        SQLLite sqlLite = new SQLLite(getActivity(), "expenses", null, 1);
        SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();

        int code = Integer.parseInt(txtCodeExpense.getText().toString());
        String expensename = txtExpenseName.getText().toString();
        String expensedate = txtExpenseDate.getText().toString();
        String expenseamount = txtExpenseAmount.getText().toString();

        ContentValues values = new ContentValues();
        values.put("code", code);
        values.put("expensename",expensename);
        values.put("expensedate",expensedate);
        values.put("expenseamount",expenseamount);

        Long result = sqLiteDatabase.insert("expenses", null, values);
        Toast.makeText(getActivity(), "Result: " + result, Toast.LENGTH_SHORT).show();
    }
    public void ValidateText() {
        if (txtCodeExpense.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Code Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtExpenseName.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Expense Name Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtExpenseDate.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Expense Date Is Missing", Toast.LENGTH_SHORT).show();
        }
        if (txtExpenseAmount.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Expense Amount Is Missing", Toast.LENGTH_SHORT).show();
        }
    }
    private void CleanText() {
        txtCodeExpense.setText("");
        txtExpenseName.setText("");
        txtExpenseDate.setText("");
        txtExpenseAmount.setText("");
    }
}