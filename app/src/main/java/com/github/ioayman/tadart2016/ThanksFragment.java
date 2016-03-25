package com.github.ioayman.tadart2016;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ioayman.tadart2016.data.ImagesDataSource;
import com.github.ioayman.tadart2016.data.db.DBHelper;


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
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rootView.setBackgroundResource(
                ImagesDataSource.getImageResourceId(
                        DBHelper.getInstance(getContext()).getBestOne()
                )
        );
    }

    @Override
    public void onPause() {
        super.onPause();
        rootView.setBackgroundResource(android.R.drawable.btn_minus);
    }
}
