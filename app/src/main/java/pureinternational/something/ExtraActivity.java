package pureinternational.something;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExtraActivity extends AppCompatActivity {

    private TextView splashText;
    //protected String text;
    private ImageView imageViewPro;
    private static int SPLASH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        //text=getIntent().getStringExtra("WEB_URL");
        splashText=findViewById(R.id.tex);
        imageViewPro=findViewById(R.id.imageView);
        //tv.setText(text);
        //Typeface CustomFont = Typeface.createFromAsset(getActivity().getAssets(),"fonts/ralewayMedium.ttf");

        Typeface CustomFont = Typeface.createFromAsset(getAssets(),"fonts/ralewayMedium.ttf");
        splashText.setTypeface(CustomFont);

        Animation animation99 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        imageViewPro.startAnimation(animation99);

        Animation animation999 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        splashText.startAnimation(animation999);


    }
}
