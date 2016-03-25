package ioayman.github.com.tadart2016.data;

import android.content.Context;
import android.support.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

import ioayman.github.com.tadart2016.R;
import ioayman.github.com.tadart2016.galary_rv.ElementModel;
import ioayman.github.com.tadart2016.util.CONFIG;

/**
 * [3/24/16:18:19]
 *
 * @author @IOAyman
 */
public class ImagesDataSource {
    private static List<ElementModel> data;
    private static Context mContext;
    private static ImagesDataSource ourInstance = new ImagesDataSource();

    private ImagesDataSource() {
    }

    public static synchronized ImagesDataSource getInstance(Context context) {
        mContext = context;
        data = new ArrayList<>();

        if (mContext == null)
            // Simulate some pics to work with
            for (int i = 0; i < CONFIG.IMAGES_COUNT*3; i++)
                data.add(new ElementModel(R.mipmap.ic_launcher));
        else
            for (int i = 0; i < CONFIG.IMAGES_COUNT; i++)
                data.add(new ElementModel(getImageResourceId(i)));
        return ourInstance;
    }

    public static @DrawableRes int getImageResourceId(int number) {
        return mContext.getResources().getIdentifier(CONFIG.IMAGE_NAME_PREFIX + number, "drawable", mContext.getPackageName());
    }

    public List<ElementModel> getData() {
        return data;
    }
}
