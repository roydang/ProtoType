package com.example.nhnent.myweartestapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyWearActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                initView(stub);
            }
        });
    }
    private void initView(WatchViewStub stub) {
        Button gridViewStartBtn = (Button)findViewById(R.id.btn_grid_view);
        gridViewStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Btn click",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), GridViewPagerActivity.class);
                startActivity(intent);

            }
        });

        CircledImageView circleImgView = (CircledImageView)findViewById(R.id.circle_view);
        circleImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        circleImgView.setCircleColor(Color.RED);
//        circleImgView.setImageResource(R.drawable.ic_launcher);

    }
}
