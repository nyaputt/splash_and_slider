package com.example.avinlagi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avinlagi.Onboarding_one;
import com.example.avinlagi.R;

import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    private TextView[] dots;

    //List of Image

    public int[] lst_images = {
            R.drawable.img_slide_one,
            R.drawable.img_slide_two,
            R.drawable.img_slide_three,
            R.drawable.img_slide_four

   };

    //List of tittle

    public String[] lst_title = {
            "Tracking",
            "Tax Payment",
            "Accident Report",
            "Stolen Report"
    };

    //List of Description
    public String[] lst_description = {
            "Description 1",
            "Description 2",
            "Description 3",
            "description 4"
    };

    public sliderAdapter (Context context){this.context = context;}


    @Override
    public int getCount() {
        return lst_title.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view   == (ConstraintLayout)object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.slide,container,false);
        ConstraintLayout layoutslide = view.findViewById(R.id.layout_slide);
        ImageView img_onboarding = (ImageView) view.findViewById(R.id.img_onboarding);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView description = (TextView) view.findViewById(R.id.description);

        img_onboarding.setImageResource(lst_images[position]);
        title.setText(lst_title[position]);
        description.setText(lst_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout)object);
    }
}
