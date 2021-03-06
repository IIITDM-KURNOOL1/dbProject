package com.example.user.dbproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 08-05-2018.
 */

public class DataManager {

    // This is the actual database
    private SQLiteDatabase db;

    /*
        Next we have a public static final string for
        each row/table that we need to refer to both
        inside and outside this class
    */

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_MINIT = "middle";
    public static final String TABLE_ROW_LNAME = "lastname";
    public static final String TABLE_ROW_ROLLNO = "rollno";
    public static final String TABLE_ROW_SEX = "sex";
    public static final String TABLE_ROW_DOB = "dob";
    public static final String TABLE_ROW_DNO = "dno";
    public static final String TABLE_ROW_USERNO = "userno";

    /*
        Next we have a private static final strings for
        each row/table that we need to refer to just
        inside this class
    */

    private static final String DB_NAME = "address_book_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "names_and_addresses";

    public DataManager(Context context) {
        // Create an instance of our internal CustomSQLiteOpenHelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        // Get a writable database
        db = helper.getWritableDatabase();
    }


    // Here are all our helper methods

    // Insert a record
    public void insert(String name, String middle,String lastname,String rollno,String sex,String dob,String dno,String userno ){

        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_MINIT + ", " +
                TABLE_ROW_LNAME + ", " +
                TABLE_ROW_ROLLNO + ", " +
                TABLE_ROW_SEX + ", " +
                TABLE_ROW_DOB +  ", " +
                TABLE_ROW_DNO + ", " +
                TABLE_ROW_USERNO  +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + middle + "'" + ", " +
                "'" + lastname + "'" + ", " +
                "'" + rollno + "'" + ", " +
                "'" + sex + "'" + ", " +
                "'" + dob + "'" + ", " +
                "'" + dno + "'" + ", " +
                "'" + userno + "'" +
                ");";

        //Log.i("insert() = ", query);

        db.execSQL(query);

    }


    // Delete a record
   /* public void delete(String name){

        // Delete the details from the table if already exists
        String query = "DELETE FROM " + TABLE_N_AND_A +
                " WHERE " + TABLE_ROW_NAME +
                " = '" + name + "';";

        Log.i("delete() = ", query);

        db.execSQL(query);

    }*/

    // Get all the records
    public Cursor selectAll() {

        Cursor c = db.rawQuery("SELECT *" +" from " +
                TABLE_N_AND_A, null);
        return c;
    }

    // Find a specific record
    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_MINIT +
                ", " + TABLE_ROW_LNAME +
                ", " + TABLE_ROW_ROLLNO +
                ", " + TABLE_ROW_SEX +
                ", " + TABLE_ROW_DOB +
                ", " + TABLE_ROW_DNO +
                ", " + TABLE_ROW_USERNO +
                " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";

        Log.i("searchName() = ", query);

        Cursor c = db.rawQuery(query, null);


        return c;
    }





    // This class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // This method only runs the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {

            // Create a table for photos and all their details
            String newTableQueryString = "create table "
                    + TABLE_N_AND_A + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    + " text not null,"
                    + TABLE_ROW_MINIT
                    + " text not null,"
                    + TABLE_ROW_LNAME
                    + " text not null,"
                    + TABLE_ROW_ROLLNO
                    + " text not null,"
                    + TABLE_ROW_SEX
                    + " text not null,"
                    + TABLE_ROW_DOB
                    + " text not null,"
                    + TABLE_ROW_DNO
                    + " text not null,"
                    + TABLE_ROW_USERNO
                    + " text not null);";


            db.execSQL(newTableQueryString);

        }

        // This method only runs when we increment DB_VERSION
        // We will look at this in chapter 26
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }

}
