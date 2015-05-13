package com.example.awesomemusicselectorapp;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	Button b1, b2, b3, b4, b5, b6, b7, b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);

        createListeners();
    }

    private void createListeners() {
    	b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startBeat(1);
            }
        });
        
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startBeat(2);
            }
        });
        
        b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startBeat(3);
            }
        });
        
        b4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startBeat(4);
            }
        });
	}

    // play beat when button is pressed
    private void startBeat(int buttonNum) {
        int beat = 0;
        switch (buttonNum) {
            case 1: beat = R.raw.bassdown;
               break;
            case 2: beat = R.raw.bassdrum;
                break;
            case 3: beat = R.raw.bubble;
                break;
            case 4: beat = R.raw.byoh;
                break;
            case 5: beat = R.raw.clap;
                break;
            case 6: beat = R.raw.clapclap;
                break;
            case 7: beat = R.raw.drop;
                break;
            case 8: beat = R.raw.gunshot;
                break;
            default: beat = R.raw.bassdown;
                break;
        }
        MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, beat);
        mPlayer.start();
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
