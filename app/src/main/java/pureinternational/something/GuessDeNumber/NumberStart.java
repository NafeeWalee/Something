package pureinternational.something.GuessDeNumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import pureinternational.something.R;

public class NumberStart extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_start);

        btn = findViewById(R.id.BTN);
    }

    public void generate(View view) {
        Random random = new Random();
        int number = random.nextInt(100)+1;
        String string = String.valueOf(number);
        Intent o = new Intent(NumberStart.this, NumberGuess.class);
        o.putExtra("num",string);
        startActivity(o);
    }
}
