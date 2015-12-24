package com.example.root.qurantest;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by root on 12/23/15.
 */
public class ScreenSlidePageAdapter extends PagerAdapter {
    //Section indicator
    int sectionIndicator = 0;
    //Home pics
    private int[] homeImages = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};
    //First section pics
    private int[] first = {R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11,
            R.drawable.a12, R.drawable.a13, R.drawable.a14};
    //Second section pics
    private int[] second = {R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20,
            R.drawable.a21, R.drawable.a22, R.drawable.a23};
    //third section pics
    private int[] third = {R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a27, R.drawable.a28, R.drawable.a29,
            R.drawable.a30, R.drawable.a31, R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35, R.drawable.a36,
            R.drawable.a37, R.drawable.a38, R.drawable.a39};
    //forth section pics
    private int[] forth = {R.drawable.a40, R.drawable.a41, R.drawable.a42, R.drawable.a43, R.drawable.a44, R.drawable.a45,
            R.drawable.a46, R.drawable.a47, R.drawable.a48};
    private LayoutInflater layoutInflater;
    private Context context;

    public ScreenSlidePageAdapter(Context context) {
        this.context = context;
    }

    public ScreenSlidePageAdapter(Context context, int Section) {
        this.context = context;
        sectionIndicator = Section;
    }

    @Override
    public int getCount() {

        if (sectionIndicator == 1) {
            return first.length;
        } else if (sectionIndicator == 2) {
            return second.length;
        } else if (sectionIndicator == 3) {
            return third.length;
        } else if (sectionIndicator == 4) {
            return forth.length;
        }
        return homeImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.screen_slide_page, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        switch (sectionIndicator){
            case 0:
                imageView.setImageResource(homeImages[position]);
                break;
            case 1:
                imageView.setImageResource(first[position]);
                break;
            case 2:
                imageView.setImageResource(second[position]);
                break;
            case 3:
                imageView.setImageResource(third[position]);
                break;
            case 4:
                imageView.setImageResource(forth[position]);
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
