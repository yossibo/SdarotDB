package sdarotdb.my.com.sdarotdb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    SQLHelper  myHelper;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper= new SQLHelper(this);

//run only once...
     //   fillDummyData();




        ListView sdarotLV= (ListView) findViewById(R.id.sdarotLV);

        cursor= myHelper.getReadableDatabase().query(DBConstants.tableName, null,null, null,null,null,null);


      //  String[] from= { DBConstants.series_name, DBConstants.number_of_episodes };
    //    int[] to=  { R.id.seriesnameTV , R.id.episodesTV };

     //   SimpleCursorAdapter adapter= new SimpleCursorAdapter(this, R.layout.sdarot_item, cursor, from, to);

        MySdarotAdapter adapter= new MySdarotAdapter(this, cursor);

        sdarotLV.setAdapter(adapter);

       // Log.d("dsfsd","");



        sdarotLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(cursor.moveToPosition(position))
                {
                    String name= cursor.getString(cursor.getColumnIndex(DBConstants.series_name));
                    int episodes= cursor.getInt(cursor.getColumnIndex(DBConstants.number_of_episodes));

                    Intent intent= new Intent(MainActivity.this, DetailsAct.class);

                    Sidra sidra= new Sidra(name,episodes);
                    intent.putExtra("sidra", sidra);
                    startActivity(intent);

                }

            }
        });



    }

    private void fillDummyData() {


        ContentValues contentValues= new ContentValues();
        contentValues.put(DBConstants.series_name, "lost");
        contentValues.put(DBConstants.number_of_episodes, 60);
        myHelper.getWritableDatabase().insert(DBConstants.tableName, null ,contentValues );


         contentValues= new ContentValues();
        contentValues.put(DBConstants.series_name, "desperate housewives");
        contentValues.put(DBConstants.number_of_episodes, 60);
        myHelper.getWritableDatabase().insert(DBConstants.tableName, null ,contentValues );

        contentValues= new ContentValues();
        contentValues.put(DBConstants.series_name, "supranos");
        contentValues.put(DBConstants.number_of_episodes, 600);
        myHelper.getWritableDatabase().insert(DBConstants.tableName, null ,contentValues );

    }
}
