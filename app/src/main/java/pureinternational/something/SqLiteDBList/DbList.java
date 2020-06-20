package pureinternational.something.SqLiteDBList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import pureinternational.something.R;

public class DbList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_list);
        final ArrayList<DbListData> info = new ArrayList<>();


        info.add(new DbListData(1,"tithi","EEE","29/12/1996",100000.0));
        info.add(new DbListData(1,"tithi","EEE","29/12/1996",100000.0));
        info.add(new DbListData(1,"tithi","EEE","29/12/1996",100000.0));

        final ListView listView = findViewById(R.id.db_list);
        DbListAdapter adapter = new DbListAdapter(this, R.layout.db_list_layout, info);
        listView.setAdapter(adapter);
    }
}
