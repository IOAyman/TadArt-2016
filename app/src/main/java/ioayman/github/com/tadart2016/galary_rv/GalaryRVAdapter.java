package ioayman.github.com.tadart2016.galary_rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ioayman.github.com.tadart2016.R;

/**
 * [3/24/16:18:10]
 *
 * @author @IOAyman
 */
public class GalaryRVAdapter extends RecyclerView.Adapter<ElementViewHolder> {
    private final Context mContext;

    public GalaryRVAdapter(Context context) {mContext = context;}

    @Override
    public ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.element, parent, false);
        return  new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, int position) {
        // TODO: 3/24/16 -- implement this
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
