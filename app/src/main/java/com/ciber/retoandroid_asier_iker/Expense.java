package com.ciber.retoandroid_asier_iker;

import java.io.Serializable;

public class Expense implements Serializable {

    private  int code;
    private String expensename;
    private String expensedate;
    private String expenseamount;

    public Expense() {
    }

    public Expense(int code, String expensename, String expensedate, String expenseamount) {
        this.code = code;
        this.expensename = expensename;
        this.expensedate = expensedate;
        this.expenseamount = expenseamount;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getExpenseName() {
        return expensename;
    }
    public void setExpenseName(String expensename) {
        this.expensename = expensename;
    }

    public String getExpenseDate() {
        return expensedate;
    }
    public void setExpenseDate(String expensedate) {
        this.expensedate = expensedate;
    }

    public String getExpenseAmount() {
        return expenseamount;
    }
    public void setExpenseamount(String expenseamount) {
        this.expenseamount = expenseamount;
    }

}
