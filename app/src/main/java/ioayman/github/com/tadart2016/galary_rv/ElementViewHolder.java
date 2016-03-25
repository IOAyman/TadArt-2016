package ioayman.github.com.tadart2016.galary_rv;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import ioayman.github.com.tadart2016.R;
import ioayman.github.com.tadart2016.util.CONFIG;

/**
 * [3/24/16:18:11]
 *
 * @author @IOAyman
 */
public class ElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected ImageView imageThumbnail;

    public ElementViewHolder(View itemView) {
        super(itemView);
        imageThumbnail = (ImageView) itemView.findViewById(R.id.imageThumbnail);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (GalaryRVAdapter.clickListener!=null)
            GalaryRVAdapter.clickListener.itemClicked(v, getAdapterPosition());
        else
            Log.e(CONFIG.DEBUG_TAG,
                    "onClick: Error!  You must set GalaryRVAdapter#setClickListener form your fragrment",
                    new Exception("Error!  You must set GalaryRVAdapter#setClickListener form your fragrment"));
    }
}
