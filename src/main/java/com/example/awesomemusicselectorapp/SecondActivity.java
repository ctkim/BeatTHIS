package com.example.awesomemusicselectorapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {

	private MediaPlayer mPlayer;
	private int currentSong = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
		int number = intent.getIntExtra("BUTTON NUMBER", 1);
		
		TextView tv = (TextView) findViewById(R.id.textView);
		tv.setText(String.valueOf(number));
		
		if (number == 1) {
	            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song1);
	            currentSong = R.raw.song1;
	    } else if (number == 2) {
	            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song2);
	            currentSong = R.raw.song2;

	    } else if (number == 3) {
	            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song3);
	            currentSong = R.raw.song3;

	    } else if (number == 4) {
	            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song4);
	            currentSong = R.raw.song4;

	            // Defaults are always a good idea:
	    } else {
	            mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song1);
	            currentSong = R.raw.song1;

	    }

		 mPlayer.start();
	}
	
	@Override
    protected void onPause() {
        super.onPause();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }
	
	@Override
    protected void onResume() {
        super.onResume();
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(SecondActivity.this, currentSong);
        }

        mPlayer.start();
    }
	
	@Override
    protected void onStop() {
        super.onStop();

        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
