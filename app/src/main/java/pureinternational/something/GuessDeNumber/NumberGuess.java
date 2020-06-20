package pureinternational.something.GuessDeNumber;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import pureinternational.something.R;

public class NumberGuess extends AppCompatActivity {

    private TextView tv, tv1;
    private Button btn;
    private EditText et;
    private int gen_num;
    private String string;
    public int x = 5;
    public int flag;
    private ImageView l1, l2, l3, l4, l5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_guess);
        l1 = findViewById(R.id.IV1);
        l2 = findViewById(R.id.IV2);
        l3 = findViewById(R.id.IV3);
        l4 = findViewById(R.id.IV4);
        l5 = findViewById(R.id.IV5);
        lifeReset();
        tv = findViewById(R.id.TV);
        tv1 = findViewById(R.id.TV1);
        btn = findViewById(R.id.BTN);
        et = findViewById(R.id.ET);
        gen_num = Integer.parseInt(getIntent().getStringExtra("num"));
        string = getIntent().getStringExtra("num");


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (et.getText().toString().equals("777")) {
                    tv1.setText(string);
                    tv1.setVisibility(View.VISIBLE);
                } else if (et.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Gimme something", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(et.getText().toString()) >= 101 || Integer.parseInt(et.getText().toString()) <= 0) {
                    Toast.makeText(getApplicationContext(), "Input between 1 to 100", Toast.LENGTH_SHORT).show();
                } else {
                    play();
                }
            }
        });
    }

    private void lifeReset() {
        l1.setImageResource(R.drawable.lifeheart);
        l2.setImageResource(R.drawable.lifeheart);
        l3.setImageResource(R.drawable.lifeheart);
        l4.setImageResource(R.drawable.lifeheart);
        l5.setImageResource(R.drawable.lifeheart);
    }

    private void play() {

        if (x > 0) {
            int number = Integer.parseInt(et.getText().toString());
            if (number < gen_num) {
                flag = 1;
                customToast();
            }
            if (number > gen_num) {
                flag = 2;
                customToast();
            }
            if (number == gen_num) {
                flag = 3;
                customToast();
                restart();

            }
        }
        x--;
        if (x == 1) {
            if (flag != 3) {
                l2.setImageResource(R.drawable.deadheart);
            }
        }
        if (x == 2) {
            if (flag != 3) {
                l3.setImageResource(R.drawable.deadheart);
            }
        }
        if (x == 3) {
            if (flag != 3) {
                l4.setImageResource(R.drawable.deadheart);
            }
        }
        if (x == 4) {
            if (flag != 3) {
                l5.setImageResource(R.drawable.deadheart);
            }

        }
        if (x == 0) {
            if (flag != 3) {
                limit();
                l1.setImageResource(R.drawable.deadheart);

            }

        }

    }

    private void customToast() {
        LayoutInflater LF = getLayoutInflater();
        View layout = LF.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.cus_toast));

        TextView tv = layout.findViewById(R.id.TextV);
        ImageView iv = layout.findViewById(R.id.ImageV);
        if (flag == 1) {

            tv.setText("Increase Your Number!");
            iv.setImageResource(R.drawable.arrowright);
        }
        if (flag == 2) {
            tv.setText("Decrease Your Number! ");
            iv.setImageResource(R.drawable.arrowleft);
        }
        if (flag == 3) {
            tv.setText("BINGO!");
            iv.setImageResource(R.drawable.rainbow_poop);

        }


        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, -270);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
        new CountDownTimer(500, 1000) {

            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            public void onFinish() {
                toast.cancel();
            }

        }.start();
    }

    private void limit() {

        final AlertDialog.Builder ab = new AlertDialog.Builder(NumberGuess.this);
        ab.setMessage("The number is " + string + " Try again?");
        ab.setCancelable(true);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                x = 5;
                lifeReset();
                tv1.setVisibility(View.INVISIBLE);
                Random random = new Random();
                gen_num = random.nextInt(100) + 1;
                string = String.valueOf(gen_num);
                dialogInterface.cancel();
            }
        });
        ab.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });
        AlertDialog AD = ab.create();
        AD.show();

    }

    private void restart() {

        final AlertDialog.Builder ab = new AlertDialog.Builder(NumberGuess.this);
        ab.setMessage("Success!" + "\n" + "Try again?");
        ab.setCancelable(true);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                x = 5;
                lifeReset();
                tv1.setVisibility(View.INVISIBLE);
                Random random = new Random();
                gen_num = random.nextInt(100) + 1;
                string = String.valueOf(gen_num);
                dialogInterface.cancel();
            }
        });
        ab.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });
        AlertDialog AD = ab.create();
        AD.show();

    }
}
