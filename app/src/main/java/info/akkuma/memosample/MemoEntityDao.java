package info.akkuma.memosample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akkuma on 2014/10/06.
 */
public class MemoEntityDao {

    public long insert(SQLiteDatabase db, MemoEntity obj) {

        ContentValues v = new ContentValues();

        v.put(MemoEntity.COLUMN_ID, obj.getId());
        v.put(MemoEntity.COLUMN_TEXT, obj.getText());
        v.put(MemoEntity.COLUMN_TIME_STAMP, obj.getTimeStamp());

        return db.insertOrThrow(MemoEntity.TABLE_NAME, null, v);
    }

    public void delete(SQLiteDatabase db, Integer id) {

        db.delete(MemoEntity.TABLE_NAME, MemoEntity.COLUMN_ID + "=?", new String[] { Integer.toString(id) });

    }

    public List<MemoEntity> list(SQLiteDatabase db) {

        List<MemoEntity> list = new ArrayList<MemoEntity>();

        Cursor cursor = db.query(MemoEntity.TABLE_NAME, null, null, null, null, null, MemoEntity.COLUMN_ID);
        if(!cursor.moveToFirst()){
            return list;
        }

        while(!cursor.isAfterLast()) {
            MemoEntity entity = new MemoEntity();

            entity.setId(cursor.getInt(cursor.getColumnIndexOrThrow(MemoEntity.COLUMN_ID)));
            entity.setText(cursor.getString(cursor.getColumnIndexOrThrow(MemoEntity.COLUMN_TEXT)));
            entity.setTimeStamp(cursor.getLong(cursor.getColumnIndexOrThrow(MemoEntity.COLUMN_TIME_STAMP)));

            list.add(entity);

            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }
}
