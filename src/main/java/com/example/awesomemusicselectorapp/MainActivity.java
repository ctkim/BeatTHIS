package com.example.awesomemusicselectorapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = "AudioRecord";

	Button b1, b2, b3, b4, b5, b6, b7, b8;
    private MediaPlayer m1, m2, m3, m4, m5, m6, m7, m8, songPlayer, samplePlayer;
    private ArrayList<Song> mSongs;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private MediaRecorder mRecorder;
    private boolean recording = false;

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
        mSongs = new ArrayList<Song>();
        // add sample beat
        Song sample = new Song("Sample Beat", "no path");
        mSongs.add(sample);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerList.setAdapter(new ArrayAdapter<Song>(this,
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
                mDrawerList.bringToFront();
                mDrawerLayout.requestLayout();
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
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
    }

    // add action buttons
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (recording) {
            getMenuInflater().inflate(R.menu.recording, menu);
        } else {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // nav menu
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // handle action button presses
        switch (item.getItemId()) {
            case R.id.action_record:
                userFileName();
                return true;
            case R.id.action_stop:
                stopRecording();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this,
                        "No settings available at this time.",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void stopRecording() {
        // update action bar with play button
        recording = false;
        invalidateOptionsMenu();

        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    private void startRecording() {
        Song song = mSongs.get(mSongs.size() - 1);
        String mFileName = song.getPath();

        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile(mFileName);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed while preparing " + mFileName);
        }
        // update action bar with stop button
        recording = true;
        invalidateOptionsMenu();

        Toast.makeText(MainActivity.this, "Recording...", Toast.LENGTH_SHORT).show();
        mRecorder.start();
    }

    // prompt user for file name
    private void userFileName() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Type the name of your new dope beat:");
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alert.setView(input);

        alert.setPositiveButton("Aight LEGGO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input.getText().toString();
                createSong(name);
                startRecording();
            }
        });
        alert.create().show();
    }

    // make new song from recording and add to arraylist of songs
    // refreshes listview in nav drawer to update playlist
    private void createSong(String name) {
        name = name.trim();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String n = name.toLowerCase().replace(" ", "_");
        path += "/" + n + ".3gp";
        Song song = new Song(name, path);
        mSongs.add(song);

        mDrawerList.setAdapter(new ArrayAdapter<Song>(this,
                R.layout.drawer_list_item, mSongs));
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
        private DrawerLayout mDrawerLayout;
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            if (songPlayer!=null && songPlayer.isPlaying()) {
                songPlayer.stop();
                songPlayer.release();
            }
            if (samplePlayer!=null && samplePlayer.isPlaying()) {
                samplePlayer.stop();
                samplePlayer.release();
            }
            Toast.makeText(MainActivity.this, "Playing song...", Toast.LENGTH_SHORT).show();
            playSong(position);
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerList.setItemChecked(position, true);
            mDrawerLayout.closeDrawers();
        }
    }

    // plays selected song from nav menu
    // position is index in Arraylist mSongs
    private void playSong(int position) {
        if (position==0) {
            samplePlayer  = MediaPlayer.create(this, R.raw.sample_beat);
            samplePlayer.start();
        } else {
            String songPath = mSongs.get(position).getPath();
            songPlayer = new MediaPlayer();
            try {
                songPlayer.setDataSource(songPath);
                songPlayer.prepare();
                songPlayer.start();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (songPlayer != null) {
            songPlayer.release();
            songPlayer = null;
        }
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }
        if (samplePlayer != null) {
            samplePlayer.release();
            samplePlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (songPlayer != null) {
            songPlayer.release();
            songPlayer = null;
        }
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }
        if (samplePlayer != null) {
            samplePlayer.release();
            samplePlayer = null;
        }
    }
}
