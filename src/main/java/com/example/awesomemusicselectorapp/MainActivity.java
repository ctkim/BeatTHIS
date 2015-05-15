package com.example.awesomemusicselectorapp;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	Button b1, b2, b3, b4, b5, b6, b7, b8;
    private MediaPlayer m1, m2, m3, m4, m5, m6, m7, m8;
    //private MediaPlayer[] allMPlayers = new MediaPlayer[]{m1, m2, m3, m4, m5, m6, m7, m8};

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

        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(1);
                    m1 = MediaPlayer.create(MainActivity.this, beat);
                    m1.start();
                    m1.setLooping(true);
                    b1.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    b1.setPressed(false);
                    m1.release();
                }
                return false;
            }
        });
        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(2);
                    m2 = MediaPlayer.create(MainActivity.this, beat);
                    m2.start();
                    m2.setLooping(true);
                    b2.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m2.release();
                    b2.setPressed(false);
                }
                return false;
            }
        });
        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(3);
                    m3 = MediaPlayer.create(MainActivity.this, beat);
                    m3.start();
                    m3.setLooping(true);
                    b3.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m3.release();
                    b3.setPressed(false);
                }
                return false;
            }
        });
        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(4);
                    m4 = MediaPlayer.create(MainActivity.this, beat);
                    m4.start();
                    m4.setLooping(true);
                    b4.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m4.release();
                    b4.setPressed(false);
                }
                return false;
            }
        });
        b5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(5);
                    m5 = MediaPlayer.create(MainActivity.this, beat);
                    m5.start();
                    m5.setLooping(true);
                    b5.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m5.release();
                    b5.setPressed(false);
                }
                return false;
            }
        });
        b6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(6);
                    m6 = MediaPlayer.create(MainActivity.this, beat);
                    m6.start();
                    m6.setLooping(true);
                    b6.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m6.release();
                    b6.setPressed(false);
                }
                return false;
            }
        });
        b7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(7);
                    m7 = MediaPlayer.create(MainActivity.this, beat);
                    m7.start();
                    m7.setLooping(true);
                    b7.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m7.release();
                    b7.setPressed(false);
                }
                return false;
            }
        });
        b8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    int beat = getBeat(8);
                    m8 = MediaPlayer.create(MainActivity.this, beat);
                    m8.start();
                    m8.setLooping(true);
                    b8.setPressed(true);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    m8.release();
                    b8.setPressed(false);
                }
                return false;
            }
        });

	}

    // play beat when button is pressed
    private int getBeat(int buttonNum) {
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
        return beat;
        //mPlayer = MediaPlayer.create(MainActivity.this, beat);
        //mPlayer.start();
    }

    // only required is onTouchListener doesn't work
    /*@Override
    protected void onPause() {
        super.onPause();
        for (int i=0; i<allMPlayers.length; i++) {
            if (allMPlayers[i].isPlaying()) {
                allMPlayers[i].stop();
            }
        }
    }*/

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
