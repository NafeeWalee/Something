package pureinternational.something;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpage);

        //List<Info> charInfo;
        final ArrayList<Info> charInfo = new ArrayList<>();

        charInfo.add(new Info("AKALI", "Assassin's Mark", "THE ROGUE ASSASSIN", R.drawable.akali_splash, "https://www.youtube.com/watch?v=b-s2YVbRP8I&t=217s"));
        charInfo.add(new Info("YASUO", "Steel Tempest", "THE UNFORGIVEN", R.drawable.yasuo_splash, "https://www.youtube.com/watch?v=fkM20LgOdKQ"));
        charInfo.add(new Info("IRELIA", "Ionian Fervor", "THE BLADE DANCER", R.drawable.irelia_splash, "https://www.youtube.com/watch?v=SGxQAs9ULWY&t=69s"));
        charInfo.add(new Info("TWITCH", "Deadly Venom", "THE PLAGUE RAT", R.drawable.twitch_splash, "https://www.youtube.com/watch?v=cFtH_wFJBLs"));
        charInfo.add(new Info("XIN ZHAO", "Determination,", "THE SENESCHAL OF DEMACIA", R.drawable.xin_splash, "https://www.youtube.com/watch?v=9l1lj_9Xg-E"));
        charInfo.add(new Info("MASTER YI", "Alpha Strike", "THE WUJU BLADESMAN", R.drawable.yi_splash, "https://www.youtube.com/watch?v=RJo0YzTyvXw"));
        charInfo.add(new Info("TRYNDAMERE", "Battle Fury,", "THE BARBARIAN KING", R.drawable.tryndamere_splash, "https://www.youtube.com/watch?v=VmXEnxyVcs0"));
        charInfo.add(new Info("MISS FORTUNE", "Love Tap", "THE BOUNTY HUNTER", R.drawable.mf_splash, "https://www.youtube.com/watch?v=vZh_hN-62YA"));

        // String list1[] = {"Wake UP!","Brush","Make UP","Keys","Table","Create","Fabble","back"};
        // ListAdapter myListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //String[] url={"https://www.google.com","https://www.facebook.com"};
        //ListAdapter newadapter = new CustomAdapter(this,url);
        //ListAdapter newadapter = new CustomAdapter(this,charInfo);
        final ListView listView = findViewById(R.id.LV);
        CustomAdapter newadapter = new CustomAdapter(this, R.layout.customadapter, charInfo);
        listView.setAdapter(newadapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                Info info = charInfo.get(pos);
                String name = info.getCharName();
                String address = info.getCharAddress();
                //String list = String.valueOf(adapterView.getItemAtPosition(pos));
                //String url = String.valueOf(adapterView.getItemAtPosition(pos));

                //ExtraActivity ea=new ExtraActivity();
                //ea.text=info.getCharName();

                //String value = listView.getItemAtPosition(pos).toString();
                //int position = adapterView.getPositionForView(view);

                Intent o = new Intent(ListPage.this, WebPage.class);
                o.putExtra("WEB_URL", address);
                startActivity(o);

                Toast.makeText(ListPage.this, name, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
