package pureinternational.something;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pureinternational.something.Fragment.Frag_Nav_Activity;
import pureinternational.something.GuessDeNumber.NumberStart;
import pureinternational.something.MediaPlayer.MediaPlayer;
import pureinternational.something.NumberTesting.CheckList;
import pureinternational.something.RecyclerView.Recycler;
import pureinternational.something.SqLiteDBList.DbList;


public class HomePage extends AppCompatActivity {

    private EditText et;
    private TextView tv;
    private TextView tv_t;
    private Button btn;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private ImageView iv;


    final int[] images = {R.drawable.gaara, R.drawable.lux, R.drawable.shinra_tensei, R.drawable.meh};
    private String title[] = {"GARRA", "LUX", "PAIN", "MEH"};
    int x = images.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        et = findViewById(R.id.ET);
        btn = findViewById(R.id.BTN);
        tv = findViewById(R.id.TV);
        iv = findViewById(R.id.IV);
        tv_t = findViewById(R.id.TV_TITLE);
        btn2 = findViewById(R.id.o);
        btn3 = findViewById(R.id.o2);
        btn4 = findViewById(R.id.o3);
        btn5 = findViewById(R.id.o4);
        btn6 = findViewById(R.id.o5);
        btn7 = findViewById(R.id.o6);
        btn8 = findViewById(R.id.o7);
        btn9 = findViewById(R.id.o8);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(HomePage.this, ListPage.class);
                startActivity(o);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, NumberStart.class);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, CheckList.class);
                startActivity(i);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, Recycler.class);
                startActivity(i);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, MediaPlayer.class);
                startActivity(i);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, Frag_Nav_Activity.class);
                startActivity(i);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, ExtraActivity.class);
                startActivity(i);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this, DbList.class);
                startActivity(i);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String something = et.getText().toString();
                if (et.getText().toString().equals("garra")) {
                    tv_t.setText(title[0]);
                    iv.setImageResource(images[0]);
                    tv.setText("Shikaku!!");

                } else if (et.getText().toString().equals("lux")) {
                    tv_t.setText(title[1]);
                    iv.setImageResource(images[1]);
                    tv.setText("Double Rainbow!");

                } else if (et.getText().toString().equals("pain")) {
                    tv_t.setText(title[2]);
                    iv.setImageResource(images[2]);
                    tv.setText("Universal Push!");

                } else if (et.getText().toString().equals("me")) {
                    tv_t.setText(title[3]);
                    iv.setImageResource(images[3]);
                    tv.setText("this is meh");
                } else {
                    if (something.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please type something", Toast.LENGTH_LONG).show();
                    }
                    if (et.getText().toString().equals("something")) {
                        Toast.makeText(getApplicationContext(), "I knew u'd do that!", Toast.LENGTH_LONG).show();
                    }
                    tv.setText(something);

                }

            }
        });

    }


}
