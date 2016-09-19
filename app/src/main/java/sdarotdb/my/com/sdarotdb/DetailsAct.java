package sdarotdb.my.com.sdarotdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        Sidra s= getIntent().getParcelableExtra("sidra");

        TextView sidraTV= (TextView) findViewById(R.id.seriesTV);
        sidraTV.setText("name: "+s.name+" episodes: "+s.episodes);
    }
}
