package com.example.avinlagi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.avinlagi.adapter.sliderAdapter;
import com.example.avinlagi.adapter.sliderAdapter;

public class Onboarding_one extends AppCompatActivity {

    private ViewPager viewPager;
    private sliderAdapter myAdapter;
    LinearLayout mDotLayout;
    private TextView [] mDots;
    Button btn_get_started;

    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_one);

        btn_get_started = findViewById(R.id.btn_get_started);
        viewPager =(ViewPager) findViewById(R.id.viewpager);
        myAdapter = new sliderAdapter(this);
        viewPager.setAdapter(myAdapter);
        mDotLayout = findViewById(R.id.mDotLayout);
        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i< mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(40);
            mDots[i].setTextColor(getResources().getColor(R.color.inactivedots));
            mDotLayout.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.activedots));
        }


    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (i == mDots.length-1)
            {
                btn_get_started.setEnabled(true);
                btn_get_started.setVisibility(View.VISIBLE);
            }
            else
            {
                btn_get_started.setEnabled(false);
                btn_get_started.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
