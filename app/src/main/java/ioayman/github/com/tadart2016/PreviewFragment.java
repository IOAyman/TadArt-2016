package ioayman.github.com.tadart2016;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ioayman.github.com.tadart2016.util.BitmapUtils;
import ioayman.github.com.tadart2016.util.CONFIG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviewFragment extends Fragment {
    private ImageView imageView;
    private @DrawableRes
    static int imageRes;


    public PreviewFragment() {
        // Required empty public constructor
    }

    public static PreviewFragment newInstance(@DrawableRes int imageResource) {
        imageRes = imageResource;
        return new PreviewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_preview, container, false);

        imageView = (ImageView) rootView.findViewById(R.id.imagePreviewHoler);
        BitmapUtils.loadBitmap(getContext(), imageRes, imageView, CONFIG.PREVIEW_WIDTH, CONFIG.PREVIEW_HEIGHT);

        // TODO: 3/25/16 -- Animate the DONE button

        return rootView;
    }

}
