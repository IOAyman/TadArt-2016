package com.github.ioayman.tadart2016;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.ioayman.tadart2016.data.ImagesDataSource;
import com.github.ioayman.tadart2016.util.BitmapUtils;
import com.github.ioayman.tadart2016.util.CONFIG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviewFragment extends Fragment implements View.OnClickListener {
    public static final int ID = 0;
    private ImageView imageView;
    private
    @DrawableRes
    static int imageNumber;
    private PreviewFragmentInteraction clickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickListener = (PreviewFragmentInteraction) getActivity();
    }

    public PreviewFragment() {
        // Required empty public constructor
    }

    public static PreviewFragment newInstance(int imageNumber) {
        PreviewFragment.imageNumber = imageNumber;
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
        BitmapUtils.loadBitmap(getContext(),
                ImagesDataSource.getImageResourceId(imageNumber), imageView,
                CONFIG.PREVIEW_WIDTH, CONFIG.PREVIEW_HEIGHT);

        // TODO: 3/25/16 -- Animate the DONE button
        ImageButton buttonDone = (ImageButton) rootView.findViewById(R.id.button_done);
        buttonDone.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (clickListener == null)
            Log.e(CONFIG.DEBUG_TAG,
                    "onClick: I have to make the PreviewActivity implement PreviewFragment.PreviewFragmentInterraction",
                    new Exception("onClick: I have to make the PreviewActivity implement PreviewFragment.PreviewFragmentInterraction"));
        else
            clickListener.onDoneClick(imageNumber);
    }

    interface PreviewFragmentInteraction {
        void onDoneClick(@DrawableRes int imageNumber);
    }
}
