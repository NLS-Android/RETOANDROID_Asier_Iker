package com.ciber.retoandroid_asier_iker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLLite extends SQLiteOpenHelper {

    public SQLLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS expenses(code 'int', expensename 'varchar',expensedate 'varchar', expenseamount 'varchar', departmentcode 'int', proyectcode 'int')");
        db.execSQL("CREATE TABLE IF NOT EXISTS allowances(code 'int', allowancename 'varchar',allowancestartdate 'varchar', allowanceenddate 'varchar', allowancelocation 'varchar', " +
                "allowancetransport 'varchar', allowancetravelleddistances 'varchar', allowancetollamount 'varchar', allowanceparkingamount 'varchar', daysbetweendates 'int')");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
