package com.example.user.dbproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 08-05-2018.
 */

class DataManagerCultural {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_CROLL = "Croll";
    public static final String TABLE_ROW_CID = "Cid";
    public static final String TABLE_ROW_CNAME = "Cname";

    private static final String DB_NAME = "cultural";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "culturalEntry";

    public DataManagerCultural(Context context)
    {
        CustomSQLiteOpenHelper customSQLiteOpenHelper=new CustomSQLiteOpenHelper(context);

        db=customSQLiteOpenHelper.getWritableDatabase();
    }

    public void insert(String sroll, String sid,String sname ){

        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_CROLL + ", " +
                TABLE_ROW_CID + ", " +
                TABLE_ROW_CNAME  +
                ") " +
                "VALUES (" +
                "'" + sroll + "'" + ", " +
                "'" + sid + "'" + ", " +
                "'" + sname + "'" +
                ");";

        //Log.i("insert() = ", query);

        db.execSQL(query);

    }



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
                    + TABLE_ROW_CROLL
                    + " text not null,"
                    + TABLE_ROW_CID
                    + " text not null,"
                    + TABLE_ROW_CNAME
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
