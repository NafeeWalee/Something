package pureinternational.something.RecyclerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import pureinternational.something.R;
import pureinternational.something.WebPage;

public class Recycler extends AppCompatActivity {

    RecyclerView rv;
    RecyclerAdapter rd;
    String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<RecyclerData> info = new ArrayList<>();

        info.add(new RecyclerData(1, "Akali", "Assassin", "https://www.youtube.com/watch?v=b-s2YVbRP8I&t=217s", R.drawable.akali_splash));
        info.add(new RecyclerData(2, "Twitch", "meh", "https://www.youtube.com/watch?v=b-s2YVbRP8I&t=217s", R.drawable.twitch_splash));
        info.add(new RecyclerData(3, "Yi", "....", "https://www.youtube.com/watch?v=b-s2YVbRP8I&t=217s", R.drawable.yi_splash));
        info.add(new RecyclerData(4, "Xin", "$$$", "https://www.youtube.com/watch?v=b-s2YVbRP8I&t=217s", R.drawable.xin_splash));


        rd = new RecyclerAdapter(this, info);
        rv.setAdapter(rd);



    }
    //public void click(){
        //Intent o = new Intent(Recycler.this, WebPage.class);
       // o.putExtra("WEB_URL",address);
       // startActivity(o);
        //Toast.makeText(Recycler.this ,address, Toast.LENGTH_SHORT).show();
   // }

}
