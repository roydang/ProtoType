package com.example.nhnent.myweartestapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridViewPagerActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_pager);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
               initView(stub);
            }
        });
    }
    private void initView(WatchViewStub stub) {
        WViewPagerAdapter adapter = new WViewPagerAdapter(GridViewPagerActivity.this);

        ViewPager viewpager = (ViewPager)stub.findViewById(R.id.view_pager);
        viewpager.setAdapter(adapter);

    }

    private static class WViewPagerAdapter extends PagerAdapter {

        private LayoutInflater inflater;
        public WViewPagerAdapter (Context context) {
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            View view = inflater.inflate(R.layout.grid_view_item, null);
            ViewPager curPager = (ViewPager) container;

            curPager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {

        }
    }
}
