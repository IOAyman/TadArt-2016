package com.github.ioayman.tadart2016.stats;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.data.db.DBHelper;
import com.github.ioayman.tadart2016.util.CONFIG;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class StatsActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private StatsGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        RecyclerView statsGrid = (RecyclerView) findViewById(R.id.statsGrid);
        assert statsGrid != null;

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        statsGrid.setLayoutManager(layoutManager);

        dbHelper = DBHelper.getInstance(this);
        final List<ElementStats> list = dbHelper.getTopX(CONFIG.IMAGES_COUNT);

        adapter = new StatsGridAdapter(this, list);
        statsGrid.setAdapter(adapter);
    }

    public void resetLikes(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Reset confirmation")
                .setMessage("Etes-vous SURS de vouloir reinitialiser le compteur à zero?")
                .setPositiveButton("Je confirme!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.reset();
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("retour", null)
                .show();
    }
}
