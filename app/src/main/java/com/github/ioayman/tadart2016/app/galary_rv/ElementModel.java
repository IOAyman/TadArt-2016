package com.github.ioayman.tadart2016.app.galary_rv;

import android.support.annotation.DrawableRes;

/**
 * [3/24/16:18:06]
 *
 * @author @IOAyman
 */
public class ElementModel {
    private
    @DrawableRes
    int imageId;

    public ElementModel(int imageId) {
        this.imageId = imageId;
    }

    public
    @DrawableRes
    int getImageId() {
        return imageId;
    }
}
