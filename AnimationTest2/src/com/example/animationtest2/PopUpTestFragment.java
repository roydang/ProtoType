package com.example.animationtest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.Keyframe;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.ValueAnimator;



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
		Button startAni2 = (Button)rootView.findViewById(R.id.button2);
		startAni2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageView badge01 = (ImageView)rootView.findViewById(R.id.badge_02);
				if (!isClick) {
					
					Animation appearAni = AnimationUtils.loadAnimation(getActivity(), R.anim.enter);
					badge01.setAnimation(appearAni);
					badge01.setVisibility(View.VISIBLE);
	//				badge01.startAnimation(appearAni);
					isClick = true;
				} else {
					
					Animation appearAni = AnimationUtils.loadAnimation(getActivity(), R.anim.exit);
					badge01.setAnimation(appearAni);
					badge01.setVisibility(View.GONE);
	//				badge01.startAnimation(appearAni);
					isClick = false;
				}
			}			
		});
		Button startAni3 = (Button)rootView.findViewById(R.id.button3);
		startAni3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageView badge03 = (ImageView)rootView.findViewById(R.id.badge_03);
			 
					
					startAnimation();
			 
			}
		});
		
		
	}
	
	public void nineOldAni() {
		ImageView ball = (ImageView)rootView.findViewById(R.id.badge_03);

		  PropertyValuesHolder pvhW = PropertyValuesHolder.ofFloat("width", ball.getWidth(),   ball.getWidth() * 2);
          PropertyValuesHolder pvhH = PropertyValuesHolder.ofFloat("height", ball.getHeight(),  ball.getHeight() * 2);
          PropertyValuesHolder pvTX = PropertyValuesHolder.ofFloat("x", ball.getX(),  ball.getX() - BALL_SIZE/2f);
          PropertyValuesHolder pvTY = PropertyValuesHolder.ofFloat("y", ball.getY(),  ball.getY() - BALL_SIZE/2f);
          ObjectAnimator whxyBouncer = ObjectAnimator.ofPropertyValuesHolder(ball, pvhW, pvhH,  pvTX, pvTY).setDuration(DURATION/2);
          whxyBouncer.setRepeatCount(1);
          whxyBouncer.setRepeatMode(ValueAnimator.REVERSE);
          bounceAnim = new AnimatorSet();
          ((AnimatorSet)bounceAnim).playTogether(whxyBouncer);
	}
	public void nineOldAni2() {
		ImageView ball = (ImageView)rootView.findViewById(R.id.badge_03);

		PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", ball.getY(), ball.getHeight() - BALL_SIZE);
          float ballX = ball.getX();
          Keyframe kf0 = Keyframe.ofFloat(0f, ballX);
          Keyframe kf1 = Keyframe.ofFloat(.5f, ballX + 100f);
          Keyframe kf2 = Keyframe.ofFloat(1f, ballX + 50f);
          PropertyValuesHolder pvhX = PropertyValuesHolder.ofKeyframe("x", kf0, kf1, kf2);
          ObjectAnimator yxBouncer = ObjectAnimator.ofPropertyValuesHolder(ball, pvhY, pvhX).setDuration(DURATION/2);
          yxBouncer.setRepeatCount(1);
          yxBouncer.setRepeatMode(ValueAnimator.REVERSE);
          bounceAnim = new AnimatorSet();
          ((AnimatorSet)bounceAnim).playTogether(yxBouncer);
	
	}
	public void nineOldAni3() {
		ImageView ball = (ImageView)rootView.findViewById(R.id.badge_03);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", ball.getY(), ball.getHeight() - BALL_SIZE);
        PropertyValuesHolder pvhAlpha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0f);
        ObjectAnimator yAlphaBouncer = ObjectAnimator.ofPropertyValuesHolder(ball,   pvhY, pvhAlpha).setDuration(DURATION/2);
        yAlphaBouncer.setInterpolator(new AccelerateInterpolator());
        yAlphaBouncer.setRepeatCount(1);
        yAlphaBouncer.setRepeatMode(ValueAnimator.REVERSE);
          bounceAnim = new AnimatorSet();
          ((AnimatorSet)bounceAnim).playTogether(yAlphaBouncer);
	
	}	
	public void nineOldAni4() {
		ImageView ball = (ImageView)rootView.findViewById(R.id.badge_03);
        ObjectAnimator yBouncer = ObjectAnimator.ofFloat(ball, "y",  ball.getY(), ball.getHeight() - BALL_SIZE).setDuration(DURATION);
        yBouncer.setInterpolator(new CycleInterpolator(2));

          bounceAnim = new AnimatorSet();
          ((AnimatorSet)bounceAnim).playTogether(yBouncer);
	
	}	
	
	 
	 float BALL_SIZE = 100f;
	 int DURATION = 1500;
	Animator bounceAnim;
    public void startAnimation() {
    	nineOldAni4();
        bounceAnim.start();
    }
    
}
