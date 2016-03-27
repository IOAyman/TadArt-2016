package com.github.ioayman.tadart2016.stats;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ioayman.tadart2016.R;

/**
 * [3/27/16:11:38]
 *
 * @author @IOAyman
 */
public class ElementStatsViewHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView hitsCount;

    public ElementStatsViewHolder(View itemView) {
        super(itemView);

        thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        hitsCount = (TextView) itemView.findViewById(R.id.hitsCountText);
    }
}
