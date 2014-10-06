package info.akkuma.memosample;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends Activity {

    private List<MemoEntity> list;
    ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = new MemoSampleDatabaseHelper(this).getWritableDatabase();

        list = new MemoEntityDao().list(db);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new ListItemAdapter(this, list);
        listView.setAdapter(adapter);

        db.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            list.clear();
            SQLiteDatabase db = new MemoSampleDatabaseHelper(this).getWritableDatabase();
            list.addAll(new MemoEntityDao().list(db));
            db.close();
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add) {

            Intent intent = new Intent(this, InputActivity.class);
            startActivityForResult(intent, 1);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
