package pureinternational.something.NumberTesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import pureinternational.something.R;

public class CheckList extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checking_list);


        lv = findViewById(R.id.LV);

        String list[] = {"Square", "Triangle", "Fibonacci"};
        ListAdapter myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(myListAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                String list = String.valueOf(adapterView.getItemAtPosition(pos));
                if (list.equals("Square")) {
                    Intent o = new Intent(CheckList.this, CheckNumber.class);
                    o.putExtra("select", "1");
                    startActivity(o);

                }
                if (list.equals("Triangle")) {
                    Intent o = new Intent(CheckList.this, CheckNumber.class);
                    o.putExtra("select", "2");
                    startActivity(o);

                }
                if (list.equals("Fibonacci")) {
                    Intent o = new Intent(CheckList.this, CheckNumber.class);
                    o.putExtra("select", "3");
                    startActivity(o);
                }
            }
        });
    }
}
