package ioayman.github.com.tadart2016.galary_rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ioayman.github.com.tadart2016.R;
import ioayman.github.com.tadart2016.util.AnimationUtils;
import ioayman.github.com.tadart2016.util.BitmapUtils;

/**
 * [3/24/16:18:10]
 *
 * @author @IOAyman
 */
public class GalaryRVAdapter extends RecyclerView.Adapter<ElementViewHolder> {
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
        BitmapUtils.loadBitmap(mContext, model.getImageId(), holder.imageThumbnail);
        AnimationUtils.animate(holder, position > previousPosition);
        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
