package com.github.ioayman.tadart2016.app;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.ioayman.tadart2016.R;
import com.github.ioayman.tadart2016.app.galary_rv.GalaryRVAdapter;
import com.github.ioayman.tadart2016.data.ImagesDataSource;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalaryFragment extends Fragment implements GalaryRVAdapter.ClickListener {
    private ImagesDataSource dataSource;

    public GalaryFragment() {
        // Required empty public constructor
    }


    public static GalaryFragment newInstance() {
        return new GalaryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataSource = ImagesDataSource.getInstance(getContext());

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_galary, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.galary_recycleriew);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);

        GalaryRVAdapter adapter = new GalaryRVAdapter(getContext(), dataSource.getData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        final TextView ioayman = (TextView) rootView.findViewById(R.id.ioayman);
        ioayman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://fb.me/draymanb")));
            }
        });
        return rootView;
    }

    @Override
    public void itemClicked(View view, int position) {
        final Intent intent = new Intent(getContext(), PreviewActivity.class);
        intent.putExtra(PreviewActivity.INTENT_TAG, position);
        startActivity(intent);
    }
}
