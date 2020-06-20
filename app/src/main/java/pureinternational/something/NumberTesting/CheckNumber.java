package pureinternational.something.NumberTesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pureinternational.something.R;

public class CheckNumber extends AppCompatActivity {

    private EditText et;
    private Button btn;
    private String select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checking_number);

        btn=findViewById(R.id.Check);
        et=findViewById(R.id.ET);
        select=getIntent().getStringExtra("select");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(select.equals("1")){
                    Square sqr = new Square();
                    sqr.num1=Integer.parseInt(et.getText().toString());
                    sqr.flag-=0;
                    sqr.isSquare();
                    if(sqr.flag==1)
                    {
                        Toast.makeText(CheckNumber.this,"Is A Square Number",Toast.LENGTH_SHORT).show();
                    }
                    if(sqr.flag==0)
                    {
                        Toast.makeText(CheckNumber.this,"Is Not A Square Number",Toast.LENGTH_SHORT).show();
                    }
                }
                if(select.equals("2"))
                {
                    Triangle tri =  new Triangle();
                    tri.num1=Integer.parseInt(et.getText().toString());
                    tri.flag=0;
                    tri.isTriangle();
                    if(tri.flag==1)
                    {
                        Toast.makeText(CheckNumber.this,"Is A Triangle Number",Toast.LENGTH_SHORT).show();
                    }
                    if(tri.flag==0)
                    {
                        Toast.makeText(CheckNumber.this,"Is Not A Triangle Number",Toast.LENGTH_SHORT).show();
                    }
                }
                if(select.equals("3"))
                {
                    Fibonacci fib = new Fibonacci();
                    fib.num1=Integer.parseInt(et.getText().toString());
                    fib.flag=0;
                    fib.isFibo();
                    if(fib.flag==1)
                    {
                        Toast.makeText(CheckNumber.this,"Is A Fibonacci Number",Toast.LENGTH_SHORT).show();
                    }
                    if(fib.flag==0)
                    {
                        Toast.makeText(CheckNumber.this,"Is Not A Fibonacci Number",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}
