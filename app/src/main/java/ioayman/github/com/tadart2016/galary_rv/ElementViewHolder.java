package ioayman.github.com.tadart2016.galary_rv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import ioayman.github.com.tadart2016.R;

/**
 * [3/24/16:18:11]
 *
 * @author @IOAyman
 */
public class ElementViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageThumbnail;

    public ElementViewHolder(View itemView) {
        super(itemView);
        imageThumbnail = (ImageView) itemView.findViewById(R.id.imageThumbnail);
    }
}
