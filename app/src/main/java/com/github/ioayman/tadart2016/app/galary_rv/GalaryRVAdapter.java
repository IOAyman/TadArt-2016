package com.github.ioayman.tadart2016.app.galary_rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.util.AnimationUtils;
import com.github.ioayman.tadart2016.util.BitmapUtils;
import com.github.ioayman.tadart2016.util.CONFIG;

import java.util.List;

/**
 * [3/24/16:18:10]
 *
 * @author @IOAyman
 */
public class GalaryRVAdapter extends RecyclerView.Adapter<ElementViewHolder> {
    protected static ClickListener clickListener;
    private final Context mContext;
    private List<ElementModel> data;
    private int previousPosition = 0;

    public GalaryRVAdapter(Context context, List<ElementModel> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.element, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        ElementModel model = data.get(position);
        BitmapUtils.loadBitmap(mContext,
                model.getImageId(), holder.imageThumbnail,
                CONFIG.THUMBNAIL_WIDTH, CONFIG.THUMBNAIL_HEIGHT);
        AnimationUtils.animate(holder, position > previousPosition);
        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setClickListener(ClickListener clickListener) {
        GalaryRVAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(View view, int position);
    }
}
