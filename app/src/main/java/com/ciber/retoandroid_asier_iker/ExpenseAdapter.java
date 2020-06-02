package com.ciber.retoandroid_asier_iker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.expenseView> {

    private List<Expense>expenseList=new ArrayList<>();
    private Context context;

    private ArrayList<Expense>expenseArrayList;


    public ExpenseAdapter( Context context, ArrayList<Expense> expenseList) {
        this.expenseList = expenseList;
        this.context = context;
        this.expenseArrayList=expenseList;
    }

    @NonNull
    @Override
    public expenseView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_item,viewGroup,false);
        return new expenseView(view);
    }

    @Override
    public void onBindViewHolder(expenseView expenseView, int i) {
        Expense expense = expenseList.get(i);
        expenseView.txtcodeShow.setText(String.valueOf(expense.getCode()));
        expenseView.txtExpenseNameShow.setText(expense.getExpenseName());
        expenseView.txtExpenseDateShow.setText(expense.getExpenseDate());
        expenseView.txtExpenseAmountShow.setText(expense.getExpenseAmount());

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        this.notifyDataSetChanged();
    }


    public class expenseView extends RecyclerView.ViewHolder{

        private TextView txtcodeShow, txtExpenseNameShow, txtExpenseDateShow, txtExpenseAmountShow;
        private Button btnEdit, btnDelete;

        public expenseView(@NonNull View itemView) {
            super(itemView);
            txtcodeShow = itemView.findViewById(R.id.txtcodeshow);
            txtExpenseNameShow = itemView.findViewById(R.id.txtExpenseName);
            txtExpenseDateShow = itemView.findViewById(R.id.txtDateShow);
            txtExpenseAmountShow = itemView.findViewById(R.id.txtAmountShow);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
