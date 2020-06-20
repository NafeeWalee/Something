package pureinternational.something.MediaPlayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import pureinternational.something.R;


public class MediaPlayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        final Button btn = findViewById(R.id.BTN);
        final VideoView vv = findViewById(R.id.VV);
    }

    public void videoplay(View V) {
        // String videopath = "android.resource://pureinternational.something.MediaPlayer/"+R.raw.madara;

    }
}
