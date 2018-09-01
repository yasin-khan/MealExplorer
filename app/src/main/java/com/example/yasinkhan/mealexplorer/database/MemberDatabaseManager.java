package com.example.yasinkhan.mealexplorer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.yasinkhan.mealexplorer.models.Member;

import java.util.ArrayList;

/**
 * Created by YasinKhan on 27-Aug-18.
 */

public class MemberDatabaseManager {
    private Context context;
    private DatabaseHelper databaseHelper;

    public MemberDatabaseManager(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    public long addMember(Member member){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_NAME, member.getMemberName());
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_DEPOSITE, member.getMemberDeposite());
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_MEAL, member.getMemberMeal());
        long dataInserted = sqLiteDatabase.insert(DatabaseHelper.TABLE_MEMBER, null, contentValues);
        sqLiteDatabase.close();
        return dataInserted;
    }

    public long updateMember(Member member){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_NAME, member.getMemberName());
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_DEPOSITE, member.getMemberDeposite());
        contentValues.put(DatabaseHelper.COLUMN_MEMBER_MEAL, member.getMemberMeal());
        long dataUpdated = sqLiteDatabase.update(DatabaseHelper.TABLE_MEMBER, contentValues,
                DatabaseHelper.COLUMN_MEMBER_ID+" =? ",new String[]{String.valueOf(member.getMemberId())});
        sqLiteDatabase.close();
        return dataUpdated;
    }

    public long deleteMember(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        long deletedRow = sqLiteDatabase.delete(DatabaseHelper.TABLE_MEMBER,
                DatabaseHelper.COLUMN_MEMBER_ID+" =?", new String[]{String.valueOf(id)});
        return deletedRow;
    }

    public ArrayList<Member> getAllMembers(){
        ArrayList<Member> memberArrayList = new ArrayList<>();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+";";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_NAME));
                String deposite = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_DEPOSITE));
                String meal = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_MEAL));
                Member member = new Member(id, name, deposite,meal);
                memberArrayList.add(member);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return memberArrayList;
    }

    public Member getSingleMember(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+" where "+DatabaseHelper.COLUMN_MEMBER_ID+" = "+id;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        Member member =null;
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_NAME));
            String deposite = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_DEPOSITE));
            String meal = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_MEAL));
            member = new Member(id, name, deposite,meal);
        }
        return member;
    }

    public ArrayList<Double> allMealReturn(){
        ArrayList<Double> allMealList = new ArrayList<>();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+";";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Double meal = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_MEAL)));
                allMealList.add(meal);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return allMealList;
    }

    public ArrayList<Double> allDepositeReturn(){
        ArrayList<Double> allDepositeList = new ArrayList<>();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+";";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Double deposite = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_DEPOSITE)));
                allDepositeList.add(deposite);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return allDepositeList;
    }

    /*public Double individualDeposite(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+" where "+DatabaseHelper.COLUMN_MEMBER_ID+" = "+id;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        Double deposite =null;
        if(cursor.moveToFirst()){
            deposite = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_DEPOSITE)));
        }
        return deposite;
    }

    public Double individualMeal(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery = "select * from "+DatabaseHelper.TABLE_MEMBER+" where "+DatabaseHelper.COLUMN_MEMBER_ID+" = "+id;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        Double meal =null;
        if(cursor.moveToFirst()){
            meal = Double.parseDouble(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MEMBER_MEAL)));
        }
        return meal;
    }*/

}
