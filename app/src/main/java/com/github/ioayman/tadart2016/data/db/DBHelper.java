package com.github.ioayman.tadart2016.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.github.ioayman.tadart2016.util.CONFIG;

/**
 * [3/25/16:14:11]
 *
 * @author @IOAyman
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "stats";
    public static final int DB_VERSION = 1;
    private static DBHelper ourInstance = null;
    private SQLiteDatabase db;

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        db = getWritableDatabase();
    }

    public static DBHelper getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new DBHelper(context, DB_NAME, null, DB_VERSION);
        }
        return ourInstance;
    }

    public void like(int id) {
        Cursor c = db.rawQuery("select HITS from STATS where IMAGE_ID = ?", new String[]{String.valueOf(id)});
        c.moveToFirst();
        int hits = c.getInt(c.getColumnIndex(SQL_STRUCTURE.STATS_TABLE.COLUMN_HITS.NAME));
        Log.d(CONFIG.DEBUG_TAG, "like: hits: " + hits);
        c.close();

        ContentValues values = new ContentValues();
        values.put(SQL_STRUCTURE.STATS_TABLE.COLUMN_HITS.NAME, ++hits);
        db.update(SQL_STRUCTURE.STATS_TABLE.NAME,
                values,
                SQL_STRUCTURE.STATS_TABLE.COLUMN_ID.NAME + " = ?", new String[]{String.valueOf(id)});
    }

    private void init(SQLiteDatabase db) {
        for (int i = 0; i < CONFIG.IMAGES_COUNT; i++) {
            final ContentValues values = new ContentValues();
            values.put(SQL_STRUCTURE.STATS_TABLE.COLUMN_ID.NAME, i);
            values.put(SQL_STRUCTURE.STATS_TABLE.COLUMN_HITS.NAME, 0);
            db.insert(SQL_STRUCTURE.STATS_TABLE.NAME, String.valueOf(i), values);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_STRUCTURE.STATS_TABLE.SQL_CREATE);
        init(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_STRUCTURE.STATS_TABLE.SQL_DROP);
        onCreate(db);
    }
}
