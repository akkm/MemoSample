package info.akkuma.memosample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akkuma on 2014/10/06.
 */
public class MemoSampleDatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DATABASE_NAME = "memosample.db";

    public MemoSampleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS '" + MemoEntity.TABLE_NAME + "' (" +
                "'" + MemoEntity.COLUMN_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'" + MemoEntity.COLUMN_TEXT + "' TEXT," +
                "'" + MemoEntity.COLUMN_TIME_STAMP + "' LONG );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
