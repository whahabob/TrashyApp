package com.example.projecthomescreenpreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    String text1 = new String(Character.toChars(0x1F333)) +
            new String(Character.toChars(0x1F332)) + " 0,4 Trees planted " +
            new String(Character.toChars(0x1F332)) +
            new String(Character.toChars(0x1F333));
    String text2 = "62kg CO2 emission saved " + new String(Character.toChars(0x1F3ED));

    private String [] texties = {text1, text2};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return texties.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.content_tree, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(texties[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}