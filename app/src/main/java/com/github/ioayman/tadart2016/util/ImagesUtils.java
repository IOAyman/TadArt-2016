package com.github.ioayman.tadart2016.util;

import android.content.Context;
import android.support.annotation.DrawableRes;

/**
 * [3/24/16:18:19]
 *
 * @author @IOAyman
 */
public class ImagesUtils {
    private ImagesUtils() {
    }

    public static @DrawableRes int getImageResourceId(Context context, int number) {
        return context.getResources().getIdentifier(CONFIG.IMAGE_NAME_PREFIX + number, "drawable", context.getPackageName());
    }
}
