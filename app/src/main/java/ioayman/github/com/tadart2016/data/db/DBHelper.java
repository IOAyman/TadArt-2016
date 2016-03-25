package ioayman.github.com.tadart2016.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * [3/25/16:14:11]
 *
 * @author @IOAyman
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "stats";
    public static final int DB_VERSION = 1;
    private static DBHelper ourInstance = null;

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DBHelper getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new DBHelper(context, DB_NAME, null, DB_VERSION);
        return ourInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_STRUCTURE.STATS_TABLE.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_STRUCTURE.STATS_TABLE.SQL_DROP);
        onCreate(db);
    }
}
