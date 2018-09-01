package com.example.yasinkhan.mealexplorer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.yasinkhan.mealexplorer.models.Expense;

import java.util.ArrayList;

/**
 * Created by YasinKhan on 29-Aug-18.
 */

public class ExpenseDatabaseManager {
    private Context context;
    private DatabaseHelper databaseHelper;

    public ExpenseDatabaseManager(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    public long addExpense(Expense expense){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_EXPENSE_DATE, expense.getExpenseDate());
        contentValues.put(DatabaseHelper.COLUMN_EXPENSE_NAME, expense.getExpenseName());
        contentValues.put(DatabaseHelper.COLUMN_EXPENSE_AMOUNT, expense.getExpenseAmount());
        long dataInserted = sqLiteDatabase.insert(DatabaseHelper.TABLE_EXPENSE, null, contentValues);
        sqLiteDatabase.close();
        return dataInserted;
    }

    public long updateExpense(Expense expense){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_EXPENSE_NAME, expense.getExpenseName());
        contentValues.put(DatabaseHelper.COLUMN_EXPENSE_AMOUNT, expense.getExpenseAmount());
        long dataUpdated = sqLiteDatabase.update(DatabaseHelper.TABLE_EXPENSE, contentValues,
                DatabaseHelper.COLUMN_EXPENSE_DATE+" =? ",new String[]{String.valueOf(expense.getExpenseDate())});
        sqLiteDatabase.close();
        return dataUpdated;
    }

    public ArrayList<Expense> getAllExpenses(){
        ArrayList<Expense> expenseArrayList = new ArrayList<>();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_EXPENSE+";";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                int date = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_DATE));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_NAME));
                String amount = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_AMOUNT));
                Expense expense = new Expense(date, name, amount);
                expenseArrayList.add(expense);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return expenseArrayList;
    }

    public Expense getSingleExpense(int date){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_EXPENSE+" where "+DatabaseHelper.COLUMN_EXPENSE_DATE+" = "+date;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        Expense expense =null;
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_NAME));
            String amount = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_AMOUNT));
            expense = new Expense(date, name, amount);
        }
        return expense;
    }

    public ArrayList<Double> allExpenseReturn(){
        ArrayList<Double> allExpenseList = new ArrayList<>();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_EXPENSE+";";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Double expense = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EXPENSE_AMOUNT)));
                allExpenseList.add(expense);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return allExpenseList;
    }
}
