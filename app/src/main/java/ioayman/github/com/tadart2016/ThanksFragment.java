package ioayman.github.com.tadart2016;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThanksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThanksFragment extends Fragment {
    public static final int ID = 1;

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
        return inflater.inflate(R.layout.fragment_thanks, container, false);
    }
}
