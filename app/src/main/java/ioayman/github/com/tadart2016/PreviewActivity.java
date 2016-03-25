package ioayman.github.com.tadart2016;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity implements PreviewFragment.PreviewFragmentInteraction {

    public static final String INTENT_TAG = String.valueOf(PreviewActivity.class);
    private FragmentManager mFragmentManager;
    private int imageNumber;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        imageNumber = getIntent().getIntExtra(INTENT_TAG, 0);

        mFragmentManager = getSupportFragmentManager();

        final adapter adapter = new adapter(mFragmentManager);
        pager = (ViewPager) findViewById(R.id.previewPager);
        //noinspection ConstantConditions
        pager.setAdapter(adapter);
    }

    @Override // PreviewFragment.PreviewFragmentInteraction
    public void onDoneClick(int imageNumber) {
        // TODO: 3/25/16 -- store the imageNumber in db
        pager.setCurrentItem(ThanksFragment.ID, true);
    }

    class adapter extends FragmentPagerAdapter{
        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f;
            switch (position){
                case ThanksFragment.ID:
                    f = ThanksFragment.newInstance();
                    break;

                default:
                case PreviewFragment.ID:
                f = PreviewFragment.newInstance(imageNumber);
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
