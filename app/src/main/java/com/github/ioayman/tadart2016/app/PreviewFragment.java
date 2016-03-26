package com.github.ioayman.tadart2016.app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.util.BitmapUtils;
import com.github.ioayman.tadart2016.util.CONFIG;
import com.github.ioayman.tadart2016.util.ImagesUtils;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreviewFragment extends Fragment implements View.OnClickListener {
    public static final int ID = 0;
    private final Random random = new Random();
    private ImageView imagePreview;
    private Timer timer;
    private PreviewFragmentInteraction clickListener;

    public PreviewFragment() {
        // Required empty public constructor
    }

    public static PreviewFragment newInstance() {
        return new PreviewFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickListener = (PreviewFragmentInteraction) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timer = new Timer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_preview, container, false);

        imagePreview = (ImageView) rootView.findViewById(R.id.imagePreviewHoler);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                BitmapUtils.loadBitmap(getContext(),
                        ImagesUtils.getImageResourceId(getContext(),
                                random.nextInt(CONFIG.IMAGES_COUNT)),
                        imagePreview,
                        CONFIG.PREVIEW_WIDTH, CONFIG.PREVIEW_HEIGHT);
            }
        }, 0, 5000);

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
//        else
//            clickListener.onDoneClick(text.getText()); // // TODO: 3/27/16
//            clickListener.onDoneClick(imageNumber);
    }

    interface PreviewFragmentInteraction {
        void onDoneClick(int imageNumber);
    }
}
