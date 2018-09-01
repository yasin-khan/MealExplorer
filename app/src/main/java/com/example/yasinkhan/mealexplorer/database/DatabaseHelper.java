package com.example.yasinkhan.mealexplorer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YasinKhan on 27-Aug-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    static final String DATABASE_NAME="member_database.db";

    static final int DATABASE_VERSION=3;

    static final String TABLE_MEMBER="member";
    static final String COLUMN_MEMBER_ID="id";
    static final String COLUMN_MEMBER_NAME="name";
    static final String COLUMN_MEMBER_DEPOSITE="deposite";
    static final String COLUMN_MEMBER_MEAL = "meal";

    static final String TABLE_EXPENSE="expense";
    static final String COLUMN_EXPENSE_DATE="date";
    static final String COLUMN_EXPENSE_NAME="name";
    static final String COLUMN_EXPENSE_AMOUNT="amount";

    private static final String CREATE_TABLE_MEMBER = "create table "+TABLE_MEMBER+
            "("+COLUMN_MEMBER_ID+" integer primary key autoincrement,"+COLUMN_MEMBER_NAME+
            " text,"+COLUMN_MEMBER_DEPOSITE+" text,"+COLUMN_MEMBER_MEAL+" text);";

    private static final String CREATE_TABLE_EXPENSE = "create table "+TABLE_EXPENSE+
            "("+COLUMN_EXPENSE_DATE+" integer primary key,"+COLUMN_EXPENSE_NAME+
            " text,"+COLUMN_EXPENSE_AMOUNT+" text);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEMBER);
        db.execSQL(CREATE_TABLE_EXPENSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_MEMBER);
        db.execSQL("drop table if exists "+TABLE_EXPENSE);
        onCreate(db);
    }
}
