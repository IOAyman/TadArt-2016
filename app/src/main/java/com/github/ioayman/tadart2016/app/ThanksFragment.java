package com.github.ioayman.tadart2016.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.data.ImagesDataSource;
import com.github.ioayman.tadart2016.data.db.DBHelper;
import com.github.ioayman.tadart2016.util.BitmapUtils;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThanksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThanksFragment extends Fragment {
    public static final int ID = 1;
    private View rootView;

    public ThanksFragment() {
        // Required empty public constructor
    }

    public static ThanksFragment newInstance() {
        return new ThanksFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_thanks, container, false);
        BitmapUtils.loadBitmap(getContext(),
                ImagesDataSource.getImageResourceId(DBHelper.getInstance(getContext()).getBestOne()),
                ((ImageView) rootView.findViewById(R.id.cuImage)),
                1024, 720);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        rootView.setBackgroundResource(android.R.drawable.btn_minus);
    }
}
