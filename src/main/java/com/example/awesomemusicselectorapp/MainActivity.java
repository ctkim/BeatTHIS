package com.example.awesomemusicselectorapp;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	Button b1, b2, b3, b4, b5, b6, b7, b8;
    private MediaPlayer m1, m2, m3, m4, m5, m6, m7, m8;
    private String[] mSongs;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;

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

        mTitle = getTitle();
        mDrawerTitle = "Playlist";
        mSongs = new String[] {"this", "is", "space", "filler"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mSongs));
        // disable swipe to open
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        setupDrawer();
        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        createListeners();
    }

    // make hamburger icon
    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void createListeners() {
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

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
        // nav menu
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    // click on nav menu item
    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "Playing song...", Toast.LENGTH_SHORT).show();
        }
    }
}
