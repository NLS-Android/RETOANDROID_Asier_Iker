package com.ciber.retoandroid_asier_iker;

import java.io.Serializable;

public class Expense implements Serializable {

    private  int code;
    private String expensename;
    private String expensedate;
    private String expenseamount;
    private int departmentcode;
    private int proyectcode;

    public Expense() {
    }

    public Expense(int code, String expensename, String expensedate, String expenseamount, int departmentcode, int proyectcode) {
        this.code = code;
        this.expensename = expensename;
        this.expensedate = expensedate;
        this.expenseamount = expenseamount;
        this.departmentcode = departmentcode;
        this.proyectcode = proyectcode;
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

    public int getDepartmentCode() {
        return departmentcode;
    }
    public void setDepartmentCode(int departmentcode) {
        this.departmentcode = departmentcode;
    }

    public int getProyectCode() {
        return proyectcode;
    }
    public void setProyectCode(int proyectcode) {
        this.proyectcode = proyectcode;
    }

}
