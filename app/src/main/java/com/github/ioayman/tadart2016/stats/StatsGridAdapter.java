package com.github.ioayman.tadart2016.stats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.data.ImagesDataSource;
import com.github.ioayman.tadart2016.util.BitmapUtils;
import com.github.ioayman.tadart2016.util.CONFIG;

import java.util.List;

/**
 * [3/25/16:20:48]
 *
 * @author @IOAyman
 */
public class StatsGridAdapter extends RecyclerView.Adapter<ElementStatsViewHolder> {

    private Context mContext;
    private List<ElementStats> data;

    public StatsGridAdapter(Context mContext, List<ElementStats> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ElementStatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.element_stats, parent, false);
        return new ElementStatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementStatsViewHolder holder, int position) {
        final ElementStats stats = data.get(position);

        ImagesDataSource.getInstance(mContext);
        holder.hitsCount.setText(String.valueOf(stats.getHits()));
        BitmapUtils.loadBitmap(mContext,
                ImagesDataSource.getImageResourceId(stats.getImageNumber()),
                holder.thumbnail,
                CONFIG.THUMBNAIL_WIDTH * 2, CONFIG.THUMBNAIL_HEIGHT * 2);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
