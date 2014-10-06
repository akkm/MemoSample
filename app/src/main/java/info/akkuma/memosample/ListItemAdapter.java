package info.akkuma.memosample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by akkuma on 2014/10/06.
 */
public class ListItemAdapter extends ArrayAdapter<MemoEntity> {

    public ListItemAdapter(Context context, List<MemoEntity> objects) {
        super(context, R.layout.list_item, R.id.text_body, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        MemoEntity item = getItem(position);

        TextView body = (TextView) view.findViewById(R.id.text_body);
        TextView timeStamp = (TextView) view.findViewById(R.id.time_stamp);

        body.setText(item.getText());

        Date date = new Date(item.getTimeStamp());

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd, E, HH:mm:ss");

        timeStamp.setText(format.format(date));

        return view;
    }
}
