package com.example.animationtest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



public class PopUpTestFragment extends Fragment {
	public static String title = "PopUpTest";
	View rootView;
	boolean isClick = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.pop_up_test_fragment, container, false);
		initView();
		return rootView;
	}
	public void initView() {
		
		Button startAni = (Button)rootView.findViewById(R.id.button1);
		startAni.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageView badge01 = (ImageView)rootView.findViewById(R.id.badge_01);
				if (!isClick) {
					
					Animation appearAni = AnimationUtils.loadAnimation(getActivity(), R.anim.appear);
					badge01.setAnimation(appearAni);
					badge01.setVisibility(View.VISIBLE);
	//				badge01.startAnimation(appearAni);
					isClick = true;
				} else {
					
					Animation appearAni = AnimationUtils.loadAnimation(getActivity(), R.anim.disappear);
					badge01.setAnimation(appearAni);
					badge01.setVisibility(View.GONE);
	//				badge01.startAnimation(appearAni);
					isClick = false;
				}
			}
		});
	
	}
}
