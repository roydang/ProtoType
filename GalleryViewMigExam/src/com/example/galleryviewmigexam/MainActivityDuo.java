package com.example.galleryviewmigexam;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityDuo extends Activity {

    PagerContainer mContainer;
    PagerContainer mContainerBadge;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_duo);
 
        mContainer = (PagerContainer) findViewById(R.id.pager_container);
        mContainerBadge = (PagerContainer) findViewById(R.id.pager_container_badge);
        
        ViewPager pager = mContainer.getViewPager();
        PagerAdapter adapter = new MyPagerAdapter();
        pager.setAdapter(adapter);
        //Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(adapter.getCount());
        //A little space between pages
        pager.setPageMargin(15);
 
        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        pager.setClipChildren(false);
        
        
        ViewPager pagerBadge = mContainerBadge.getViewPager();
        MyPagerAdapterBadge adapterBadge = new MyPagerAdapterBadge();
        pagerBadge.setAdapter(adapterBadge);
        //Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pagerBadge.setOffscreenPageLimit(adapterBadge.getCount());
        //A little space between pages
        pagerBadge.setPageMargin(15);
 
        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        pagerBadge.setClipChildren(false);
    }
 
    //Nothing special about this adapter, just throwing up colored views for demo
    private class MyPagerAdapter extends PagerAdapter {
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            TextView view = new TextView(MainActivity.this);
//            view.setText("Item "+position);
//            view.setGravity(Gravity.CENTER);
//            view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));
//            view.setTextColor(Color.WHITE);
        	ImageView imageView = new ImageView(MainActivityDuo.this);
        	if (position==0) {
        		imageView.setBackgroundResource(R.drawable.a);
        	} else if (position==1){
        		imageView.setBackgroundResource(R.drawable.b);
        	} else if (position==2) {
        		imageView.setBackgroundResource(R.drawable.c);
        	}
            container.addView(imageView);
            return imageView;
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
 
        @Override
        public int getCount() {
            return 3;
        }
 
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }
    
    
    
    //Nothing special about this adapter, just throwing up colored views for demo
    private class MyPagerAdapterBadge extends PagerAdapter {
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            TextView view = new TextView(MainActivity.this);
//            view.setText("Item "+position);
//            view.setGravity(Gravity.CENTER);
//            view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));
//            view.setTextColor(Color.WHITE);
        	TextView textView = (TextView)findViewById(R.id.count);
        	textView.setText(String.valueOf(position));
        	Log.v("####", "position=" + position);
        	ImageView imageView = new ImageView(MainActivityDuo.this);
        	if (position==0) {
        		imageView.setBackgroundResource(R.drawable.b1);
        	} else if (position==1){
        		imageView.setBackgroundResource(R.drawable.b2);
        	} else if (position==2) {
        		imageView.setBackgroundResource(R.drawable.b3);
        	} else if (position==3) {
        		imageView.setBackgroundResource(R.drawable.b4);
        	} else if (position==4) {
        		imageView.setBackgroundResource(R.drawable.b5);
        	} else if (position==5) {
        		imageView.setBackgroundResource(R.drawable.transparent_background);
        	}
            container.addView(imageView);
            return imageView;
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
 
        @Override
        public int getCount() {
            return 6;
        }
 
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }

}
