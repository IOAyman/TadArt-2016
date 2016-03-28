package com.github.ioayman.tadart2016.app;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.util.CONFIG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.mainFragmentContainer, WelcomeFragment.newInstance())
                .commit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentManager.beginTransaction()
                        .replace(R.id.mainFragmentContainer, GalaryFragment.newInstance())
                        .commit();
            }
        }, CONFIG.WELCOME_DELAY);
    }
}
