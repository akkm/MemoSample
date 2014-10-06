package info.akkuma.memosample;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class InputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.input, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_submit) {

            EditText editText = (EditText) findViewById(R.id.editText);

            MemoEntity entity = new MemoEntity();
            entity.setText(editText.getText().toString());
            entity.setTimeStamp(System.currentTimeMillis());

            SQLiteDatabase db = new MemoSampleDatabaseHelper(this).getWritableDatabase();
            new MemoEntityDao().insert(db, entity);
            db.close();

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
