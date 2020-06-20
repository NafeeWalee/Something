package pureinternational.something;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistrationPage extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Spinner spinner;
    private Button btn;
    private EditText getSalary;
    private TextView skip;
    public static final String DATABASE_NAME="DATABASE_NAME";
    SQLiteDatabase mDatabase;

    //private TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_page);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        spinner = findViewById(R.id.spinner);
        getSalary = findViewById(R.id.salary);
        btn = findViewById(R.id.button);
        skip = findViewById(R.id.already);
        btn.setOnClickListener(this);
        skip.setOnClickListener(this);

        //database creation

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createEmployTable();
    }

    /*
    public void btn(View view) {
        Intent o = new Intent(RegistrationPage.this, LoginPage.class);
        startActivity(o);
    }
    */

    private void createEmployTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS employees(\n" +
                        "id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "name varchar(200) NOT NULL,\n" +
                        "department varchar(200) NOT NULL,\n" +
                        "joiningdate datetime NOT NULL,\n" +
                        "salary double NOT NULL\n" +
                        ");"
        );
    }

    private boolean inputsAreCorrect(String name, String salary) {
        if (name.isEmpty()) {
            username.setError("Please enter a name");
            username.requestFocus();
            return false;
        }
        if (salary.isEmpty() || Integer.parseInt(salary) <= 0) {
            getSalary.setError("Please enter salary");
            getSalary.requestFocus();
            return false;
        }
        return true;
    }

    private void addEmployee() {
        String name = username.getText().toString().trim();
        String salary = getSalary.getText().toString().trim();
        String dept = spinner.getSelectedItem().toString();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joininngdate = sdf.format(cal.getTime());

        if (inputsAreCorrect(name, salary)) {
            String insertSQL = "INSERT INTO employees \n" +
                    "(name,department,joiningdate,salary)\n" +
                    "VALUES \n" +
                    "(?,?,?,?);";

            mDatabase.execSQL(insertSQL, new String[]{name, dept, joininngdate, salary});

            Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addEmployee();
                break;

            case R.id.already:
                Intent o = new Intent(RegistrationPage.this, LoginPage.class);
                startActivity(o);
        }
    }

   /* public void alreadyRegistered(View view) {
        Intent o = new Intent(RegistrationPage.this, LoginPage.class);
        startActivity(o);
    }
    */

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder ab = new AlertDialog.Builder(RegistrationPage.this);
        ab.setMessage("Are you sure want to exit?");
        ab.setCancelable(true);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog AD = ab.create();
        AD.show();
    }
}
