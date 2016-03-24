package ioayman.github.com.tadart2016;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ioayman.github.com.tadart2016.data.ImagesDataSource;
import ioayman.github.com.tadart2016.galary_rv.GalaryRVAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalaryFragment extends Fragment {
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
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
