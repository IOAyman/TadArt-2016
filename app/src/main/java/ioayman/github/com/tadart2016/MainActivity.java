package ioayman.github.com.tadart2016;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainFragmentContainer, GalaryFragment.newInstance())
                .commit();
    }
}
