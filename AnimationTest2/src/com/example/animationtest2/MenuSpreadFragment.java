package com.example.animationtest2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;



public class MenuSpreadFragment extends Fragment {
	public static String title = "MenuSpread";
	View rootView;
	boolean isClick = false;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.menu_spread_fragment, container, false);
		initView();
		return rootView;
	}
	public void initView() {
		
		Button startAni = (Button)rootView.findViewById(R.id.button1);
		ImageView badge03 = (ImageView)rootView.findViewById(R.id.badge_01);
		final MyAnimationView animView = new MyAnimationView(getActivity(), badge03);
		startAni.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				if (!isClick) {
					animView.startAnimation();
					
					isClick = true;
				} else {
					animView.reverseAnimation();
					isClick = false;
				}
			}
		});
	
		
	}
    public class MyAnimationView implements ValueAnimator.AnimatorUpdateListener {

    	ImageView badgeView;
        ValueAnimator bounceAnim = null;


        public MyAnimationView(Context context, ImageView badge) {
            badgeView = badge;
        }

        private void createAnimation() {
            if (bounceAnim == null) {
//                bounceAnim = ObjectAnimator.ofFloat(badgeView, "y", badgeView.getY(), badgeView.getHeight() - 50f).setDuration(1500);
                bounceAnim = ObjectAnimator.ofFloat(badgeView, "y", badgeView.getY(), 600).setDuration(800);
                bounceAnim.setInterpolator(new AccelerateDecelerateInterpolator());
                bounceAnim.addUpdateListener(this);
            }
        }

        public void startAnimation() {
            createAnimation();
            bounceAnim.start();
        }

        public void reverseAnimation() {
            createAnimation();
            bounceAnim.reverse();
        }

        public void seek(long seekTime) {
            createAnimation();
            bounceAnim.setCurrentPlayTime(seekTime);
        }

        public void onAnimationUpdate(ValueAnimator animation) {
//        	badgeView.invalidate();
        }

    }
    
}
