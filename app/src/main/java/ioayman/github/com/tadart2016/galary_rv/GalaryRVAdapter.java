package ioayman.github.com.tadart2016.galary_rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ioayman.github.com.tadart2016.R;
import ioayman.github.com.tadart2016.data.ImagesDataSource;
import ioayman.github.com.tadart2016.util.AnimationUtils;

/**
 * [3/24/16:18:10]
 *
 * @author @IOAyman
 */
public class GalaryRVAdapter extends RecyclerView.Adapter<ElementViewHolder> {
    private final Context mContext;
    private ImagesDataSource dataSource;
    private int previousPosition = 0;

    public GalaryRVAdapter(Context context) {
        mContext = context;
        dataSource = ImagesDataSource.getInstance(mContext);
    }

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.element, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        ElementModel model = dataSource.getData().get(position);
        holder.imageThumbnail.setImageResource(model.getImageId());
        AnimationUtils.animate(holder, position > previousPosition);
        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return dataSource == null ? 0 : dataSource.getData().size();
    }
}
