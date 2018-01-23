package the.appbuilder.coins.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import the.appbuilder.coins.R;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;

import the.appbuilder.coins.utils.PreferenceManager;
import me.relex.circleindicator.CircleIndicator;

import the.appbuilder.coins.utils.TrackableActivity;

public class OnBoardingActivity extends TrackableActivity {

    // https://developer.android.com/guide/topics/permissions/requesting.html#normal-dangerous
    protected final static int ONBOARDING_LOCATION = 1;
    protected final static int ONBOARDING_CAMERA = 2;
    protected final static int ONBOARDING_CONTACTS = 3;
    protected final static int ONBOARDING_CALENDAR = 4;
    protected final static int ONBOARDING_STORAGE = 5;
    
    Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_boarding);

        doneBtn = (Button) findViewById(R.id.done_btn);
        doneBtn.setVisibility(View.GONE);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("OnBoardingActivity", "Location permission");
                PreferenceManager.getInstance().set("FirstLaunch", "no");

                Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

/*
                 PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(OnBoardingActivity.this,
                         new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, new PermissionsResultAction() {

                             @Override
                             public void onGranted() {
                                 Toast.makeText(OnBoardingActivity.this,
                                         "Thanks :)",
                                         Toast.LENGTH_SHORT).show();
                             }

                             @Override
                             public void onDenied(String permission) {
                                 Toast.makeText(OnBoardingActivity.this,
                                         "Sorry, we need the Storage Permission to do that",
                                         Toast.LENGTH_SHORT).show();
                             }
                         });
                         */
            }
        });


        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }


            @Override
            public Object instantiateItem(ViewGroup view, int position) {
                LayoutInflater inflater = (LayoutInflater) view.getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View slide = inflater.inflate(R.layout.image_slide, view, false);


                ImageView imageView = (ImageView) slide.findViewById(R.id.imageView);
                Log.d("OnBoardingActivity", "Load "+position);
                if(position == 0) {
                    imageView.setImageResource(R.drawable.tuto1);
                } else if (position == 1) {
                    imageView.setImageResource(R.drawable.tuto2);
                }
                view.addView(slide);
                return slide;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ViewGroup) object);
            }

        };


        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("OnBoardingActivity", "onPageSelected "+position);
                if(position == 1) {
                    doneBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewpager);

    }
}