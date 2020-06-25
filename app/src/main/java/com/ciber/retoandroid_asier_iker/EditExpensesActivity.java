package com.ciber.retoandroid_asier_iker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.ciber.fragments.SeeExpensesFragment;

import java.util.Calendar;

public class EditExpensesActivity extends AppCompatActivity {

    private ExpenseAdapter expenseAdapter;
    private EditText expense_code_edit, expense_name_edit, expense_date_edit, amount_expense_edit, department_code_edit, proyect_code_edit;
    private Expense expense;
    private Button button_expenses_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expenses);

        expense_code_edit = findViewById(R.id.expense_code_edit);
        expense_name_edit = findViewById(R.id.expense_name_edit);
        expense_date_edit = findViewById(R.id.expense_date_edit);
        amount_expense_edit = findViewById(R.id.amount_expense_edit);
        department_code_edit = findViewById(R.id.department_code_edit);
        proyect_code_edit = findViewById(R.id.proyect_code_edit);
        button_expenses_edit = findViewById(R.id.button_expenses_edit);
        button_expenses_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditData(v);
            }
        });
        expense=(Expense)getIntent().getSerializableExtra("expenses");
        FillData();
        expense_date_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(EditExpensesActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year) +"-"+String.valueOf(monthOfYear) +"-"+String.valueOf(dayOfMonth);
                        expense_date_edit.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
    }

    private void FillData(){
        expense_code_edit.setText(String.valueOf(expense.getCode()));
        expense_code_edit.setEnabled(false);
        expense_name_edit.setText(expense.getExpenseName());
        expense_date_edit.setText(expense.getExpenseDate());
        amount_expense_edit.setText(expense.getExpenseAmount());
        department_code_edit.setText(String.valueOf(expense.getDepartmentCode()));
        proyect_code_edit.setText(String.valueOf(expense.getProyectCode()));
    }

    private void EditData(View v) {
        SQLLite sqlLite = new SQLLite(this,"expenses",null,1);
        SQLiteDatabase sqLiteDatabase = sqlLite.getWritableDatabase();
        Integer code = Integer.parseInt(expense_code_edit.getText().toString());
        String expense_name = expense_name_edit.getText().toString();
        String expense_date = expense_date_edit.getText().toString();
        String expense_amount = amount_expense_edit.getText().toString();
        Integer department_code = Integer.parseInt(department_code_edit.getText().toString());
        Integer proyect_code = Integer.parseInt(proyect_code_edit.getText().toString());


        ContentValues values = new ContentValues();
        values.put("code", code);
        values.put("expensename", expense_name);
        values.put("expensedate", expense_date);
        values.put("expenseamount", expense_amount);
        values.put("departmentcode", department_code);
        values.put("proyectcode", proyect_code);

        sqLiteDatabase.update("expenses", values, "code="+code,null);
        sqLiteDatabase.close();

        Toast.makeText(this, "Data Edited, refresh this page to see the changes",Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}