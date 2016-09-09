package com.example.adityalaksana.elepark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raufimusaddiq on 09/09/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "positionManager";

    // Contacts table name
    private static final String TABLE_POSITION = "position";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FLOOR = "floor";
    private static final String KEY_BLOCK = "block";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_LATITUDE = "latitude";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POSITION_TABLE = "CREATE TABLE " + TABLE_POSITION + "(" + KEY_ID +
                "INTEGER PRIMARY KEY AUTO INCREMENT," + KEY_FLOOR + " TEXT" + KEY_BLOCK + " TEXT"
                + KEY_LONGITUDE + " TEXT" + KEY_LATITUDE + "TEXT" + ")";
        db.execSQL(CREATE_POSITION_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSITION);

        // Create tables again
        onCreate(db);
    }

    public void addData(Position position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FLOOR, position.getFloor()); // Contact Floor
        values.put(KEY_BLOCK, position.getBlock());// Contact Block
        values.put(KEY_LONGITUDE, position.getLongitude());
        values.put(KEY_LATITUDE, position.getLatitude());

        // Inserting Row
        db.insert(TABLE_POSITION, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getAllData(){
        String query = "SELECT * FROM " + TABLE_POSITION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(true, TABLE_POSITION, null, null, null, null, null, null,null);
        if (cursor !=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
