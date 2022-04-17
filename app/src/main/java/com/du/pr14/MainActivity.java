package com.du.pr14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isPlaying = false;
    private Button button;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        intent = new Intent(this, MyService.class);
    }

    @Override
    public void onClick(View view) {
        if(isPlaying){
            isPlaying = false;
            button.setText("Play");
            stopService(intent);
        }else{
            isPlaying = true;
            button.setText("Pause");
            startService(intent);
        }
    }
}