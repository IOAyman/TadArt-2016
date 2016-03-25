package ioayman.github.com.tadart2016;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ioayman.github.com.tadart2016.data.ImagesDataSource;
import ioayman.github.com.tadart2016.util.CONFIG;

public class PreviewActivity extends AppCompatActivity {

    public static final String INTENT_TAG = String.valueOf(PreviewActivity.class);
    private FragmentManager mFragmentManager;
    private int imageResource;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        imageResource = ImagesDataSource.getImageResourceId(getIntent().getIntExtra(INTENT_TAG, R.mipmap.ic_launcher));
        if (imageResource == 0)
            Log.e(CONFIG.DEBUG_TAG,
                    "onCreate: Could not get the ImageResource",
                    new Exception("Could not get the ImageResource"));

        mFragmentManager = getSupportFragmentManager();

        final adapter adapter = new adapter(mFragmentManager);
        pager = (ViewPager) findViewById(R.id.previewPager);
        pager.setAdapter(adapter);

        mFragmentManager.beginTransaction()
                .add(R.id.previewFragmentContainer, PreviewFragment.newInstance(imageResource))
                .commit();
    }

    class adapter extends FragmentPagerAdapter{
        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f;
            switch (position){
                // TODO: 3/25/16 -- Create ThanksFragment
//                case ThanksFragment.ID:
//                    f = ThanksFragment.newInstance();
//                    break;

                default:
                case PreviewFragment.ID:
                f = PreviewFragment.newInstance(imageResource);
                break;
            }
            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
