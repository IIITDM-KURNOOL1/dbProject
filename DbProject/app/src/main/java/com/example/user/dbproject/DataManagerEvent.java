package com.example.user.dbproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 08-05-2018.
 */

class DataManagerEvent {

    private SQLiteDatabase db;
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_TEAM_SIZE = "teamsize";
    public static final String TABLE_ROW_EVENT_NAME = "eventname";
    public static final String TABLE_ROW_DATE = "date";
    public static final String TABLE_ROW_EVENT_ID = "eventid";
    public static final String TABLE_ROW_VENUE = "venue";
    public static final String TABLE_ROW_ORGANIZER = "organizer";
    public static final String TABLE_ROW_LEVEL = "level";
    public static final String TABLE_ROW_AWARD_TYPE = "awardtype";

    private static final String DB_NAME = "event_book_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "eventTable";

   public  DataManagerEvent(Context context)
   {
       CustomSQLiteOpenHelper helper=new CustomSQLiteOpenHelper(context);
       db = helper.getWritableDatabase();


   }
    public void insert(String teamsize, String eventname,String date,String eventid,String venue,String organizer,String level,String awardtype ){

        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_TEAM_SIZE + ", " +
                TABLE_ROW_EVENT_NAME + ", " +
                TABLE_ROW_DATE + ", " +
                TABLE_ROW_EVENT_ID + ", " +
                TABLE_ROW_VENUE + ", " +
                TABLE_ROW_ORGANIZER +  ", " +
                TABLE_ROW_LEVEL + ", " +
                TABLE_ROW_AWARD_TYPE  +
                ") " +
                "VALUES (" +
                "'" + teamsize + "'" + ", " +
                "'" + eventname + "'" + ", " +
                "'" + date + "'" + ", " +
                "'" + eventid + "'" + ", " +
                "'" + venue + "'" + ", " +
                "'" + organizer + "'" + ", " +
                "'" + level + "'" + ", " +
                "'" + awardtype + "'" +
                ");";

        //Log.i("insert() = ", query);

        db.execSQL(query);

    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            // Create a table for photos and all their details
            String newTableQueryString = "create table "
                    + TABLE_N_AND_A + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_TEAM_SIZE
                    + " text not null,"
                    + TABLE_ROW_EVENT_NAME
                    + " text not null,"
                    + TABLE_ROW_DATE
                    + " text not null,"
                    + TABLE_ROW_EVENT_ID
                    + " text not null,"
                    + TABLE_ROW_VENUE
                    + " text not null,"
                    + TABLE_ROW_ORGANIZER
                    + " text not null,"
                    + TABLE_ROW_LEVEL
                    + " text not null,"
                    + TABLE_ROW_AWARD_TYPE
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

