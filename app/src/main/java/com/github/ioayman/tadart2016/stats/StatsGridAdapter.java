package com.github.ioayman.tadart2016.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.util.ImagesUtils;
import com.github.ioayman.tadart2016.data.db.DBHelper;
import com.github.ioayman.tadart2016.util.BitmapUtils;
import com.github.ioayman.tadart2016.util.CONFIG;

import java.util.Arrays;
import java.util.List;

/**
 * [3/25/16:20:48]
 *
 * @author @IOAyman
 */
public class StatsGridAdapter extends BaseAdapter {
    private Context context;
    private DBHelper db;
    private List<int[]> top3;

    public StatsGridAdapter(Context context) {
        this.context = context;
        this.db = DBHelper.getInstance(this.context);
        top3 = db.getTopX(3);
    }

    @Override
    public int getCount() {
        return top3.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null)
            rootView = LayoutInflater.from(context).inflate(R.layout.element_stats, parent, false);

        final TextView hitsCount = (TextView) rootView.findViewById(R.id.hitsCountText);
        final int[] stats = top3.get(position);
        Log.d(CONFIG.DEBUG_TAG, "getView: STATS: " + Arrays.toString(stats));
        hitsCount.setText(String.valueOf(stats[1]));

        final ImageView thumbnail = (ImageView) rootView.findViewById(R.id.thumbnail);
        BitmapUtils.loadBitmap(context, ImagesUtils.getImageResourceId(context, stats[0]),
                thumbnail, CONFIG.THUMBNAIL_WIDTH, CONFIG.THUMBNAIL_HEIGHT);

        return rootView;
    }
}
