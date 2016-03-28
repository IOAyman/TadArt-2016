package com.github.ioayman.tadart2016.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.util.BitmapUtils;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        ImageView welcomeImage = (ImageView) rootView.findViewById(R.id.welcomeImage);
        BitmapUtils.loadBitmap(getContext(),
                R.drawable.welcome,
                welcomeImage,
                1024, 720);

        return rootView;
    }

}
