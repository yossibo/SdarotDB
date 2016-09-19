package sdarotdb.my.com.sdarotdb;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by jbt on 9/18/2016.
 */
public class MySdarotAdapter  extends CursorAdapter {



    //Constructor to match the parent
    public MySdarotAdapter(Context context, Cursor c) {
        super(context, c);
    }


    //inflate the XML
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.sdarot_item, null);

    }


    //Bind the data
    //use the cursor
    //no need to move to position
    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView sdarotName=(TextView) view.findViewById(R.id.seriesnameTV);
        TextView sdarotEpisodes=(TextView) view.findViewById(R.id.episodesTV);

        String name= cursor.getString(cursor.getColumnIndex(DBConstants.series_name));
        sdarotName.setText(name);


        int episodes= cursor.getInt(cursor.getColumnIndex(DBConstants.number_of_episodes));
        if(episodes>60)
        {
            sdarotEpisodes.setTextColor(Color.RED);
        }
        else
        {
            sdarotEpisodes.setTextColor(Color.BLUE);
        }
        sdarotEpisodes.setText(""+episodes);



    }
}
