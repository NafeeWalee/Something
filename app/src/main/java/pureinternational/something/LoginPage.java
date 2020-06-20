package pureinternational.something;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {
    private EditText username;
    private  EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        button = findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String something1 = username.getText().toString();
                String something2 = password.getText().toString();




                if(something1.equals("q") && something2.equals("q"))
                {
                    Toast.makeText(getApplicationContext(), "Logged In!", Toast.LENGTH_SHORT).show();
                    Intent o = new Intent(LoginPage.this, HomePage.class);
                    startActivity(o);

                }

                else if(something1.isEmpty() || something2.isEmpty())
                {

                    Intent o = new Intent(LoginPage.this, HomePage.class);
                    startActivity(o);
                    //Toast.makeText(getApplicationContext(), "Please type user or pass", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast myToast = Toast.makeText(getApplicationContext(), "Invalid Details!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });
    }

}
