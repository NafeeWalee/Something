package pureinternational.something.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import pureinternational.something.LoginPage;
import pureinternational.something.R;
import pureinternational.something.RegistrationPage;

import static android.view.Window.FEATURE_NO_TITLE;

public class SplashScreen extends AppCompatActivity {

    public int SPLASH_TIME_OUT=2500;
    public boolean time=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(time==true) {
                    Intent o = new Intent(SplashScreen.this, RegistrationPage.class);
                    startActivity(o);
                    finish();
                    time=false;
                }
            }
        },SPLASH_TIME_OUT);
    }
    public void onBackPressed()
    {
        time=false;
        finish();
    }
}
