package ioayman.github.com.tadart2016.util;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * [3/24/16:18:59]
 *
 * @author @IOAyman
 */
public class AnimationUtils {
    public static final int TRANSLATION_X_SPEED = 30;
    public static final int TRANSLATION_X_DURATION = 700;

    public static void animate(RecyclerView.ViewHolder holder, boolean isGoingRight) {
        ObjectAnimator translationX = ObjectAnimator
                .ofFloat(holder, "translationX",
                        isGoingRight ? TRANSLATION_X_SPEED : -TRANSLATION_X_SPEED);
        translationX.setDuration(TRANSLATION_X_DURATION);
        translationX.start();
    }
}
