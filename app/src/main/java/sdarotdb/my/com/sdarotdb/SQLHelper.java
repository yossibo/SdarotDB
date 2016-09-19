package sdarotdb.my.com.sdarotdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jbt on 9/18/2016.
 */
public class SQLHelper extends SQLiteOpenHelper {


    public SQLHelper(Context context) {
        super(context, "sdarot.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="CREATE TABLE "+DBConstants.tableName+" (_id INTEGER PRIMARY KEY AUTOINCREMENT , "+DBConstants.series_name+" TEXT , "+DBConstants.number_of_episodes+" INT) ";
        db.execSQL(sql);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
