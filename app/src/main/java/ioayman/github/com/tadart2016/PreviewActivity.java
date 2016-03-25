package ioayman.github.com.tadart2016;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import ioayman.github.com.tadart2016.data.ImagesDataSource;
import ioayman.github.com.tadart2016.util.BitmapUtils;
import ioayman.github.com.tadart2016.util.CONFIG;

public class PreviewActivity extends AppCompatActivity {

    public static final String INTENT_TAG = String.valueOf(PreviewActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageView imageView = (ImageView) findViewById(R.id.imagePreviewHoler);
        int imageResource = ImagesDataSource.getImageResourceId(getIntent().getIntExtra(INTENT_TAG, R.mipmap.ic_launcher));
        if (imageResource != 0) {
//            imageView.setImageResource(imageResource);
            BitmapUtils.loadBitmap(this, imageResource, imageView, CONFIG.PREVIEW_WIDTH, CONFIG.PREVIEW_HEIGHT);
        }
    }
}
