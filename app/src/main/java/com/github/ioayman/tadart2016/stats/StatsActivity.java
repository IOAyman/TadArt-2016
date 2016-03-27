package com.github.ioayman.tadart2016.stats;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.ioayman.tadart2016.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        RecyclerView statsGrid = (RecyclerView) findViewById(R.id.statsGrid);
        assert statsGrid != null;

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        statsGrid.setLayoutManager(layoutManager);

        // TODO: 3/27/16 -- set adapter
    }
}
