package com.ciber.retoandroid_asier_iker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.expenseView> {

    private List<Expense>expenseList=new ArrayList<>();
    private Context context;
    private ArrayList<Expense>expenseArrayList;
    private OPExpense opExpense;

    public ExpenseAdapter( OPExpense opExpense, ArrayList<Expense> expenseList) {
        this.opExpense = opExpense;
        this.expenseList = expenseList;
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
        expenseView.btnEdit.setOnClickListener(new EditEvent(expense));
        expenseView.btnDelete.setOnClickListener(new DeleteEvent(expense));

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        this.notifyDataSetChanged();
    }
    public void deleteExpense(Expense expense) {
        expenseList.remove(expense);
        this.notifyDataSetChanged();
    }


    class EditEvent implements View.OnClickListener{
        private Expense expense;
        public EditEvent(Expense expense) {
            this.expense = expense;

        }
        @Override
        public void onClick(View view) {
            opExpense.OptionEdit(expense);

        }
    }

    class DeleteEvent implements View.OnClickListener {

        private Expense expense;

        public DeleteEvent(Expense expense) {
            this.expense = expense;
        }

        @Override
        public void onClick(View view) {
            opExpense.OptionDelete(expense);

        }
    }

    public class expenseView extends RecyclerView.ViewHolder{

        private TextView txtcodeShow, txtExpenseNameShow, txtExpenseDateShow, txtExpenseAmountShow;
        private Button btnEdit, btnDelete;

        public expenseView(View itemView) {
            super(itemView);
            txtcodeShow = itemView.findViewById(R.id.txtcodeShow);
            txtExpenseNameShow = itemView.findViewById(R.id.txtExpenseName);
            txtExpenseDateShow = itemView.findViewById(R.id.txtDateShow);
            txtExpenseAmountShow = itemView.findViewById(R.id.txtAmountShow);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
