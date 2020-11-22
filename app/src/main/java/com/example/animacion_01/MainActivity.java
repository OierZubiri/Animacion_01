package com.example.animacion_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	ImageView o_ImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		o_ImageView = findViewById(R.id.balon_imageView);

		//o_ImageView.setOnClickListener(this::mover);
		o_ImageView.setOnClickListener(this::mover_ObjectAnimator_2);
	}

	public void mover_Animation(View v) {
		Animation oAnimacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mover_derecha_y_rotar);
		o_ImageView.startAnimation(oAnimacion);
	}

	public void mover_ValueAnimator(View v) {
		ConstraintLayout oConstraint = (ConstraintLayout) o_ImageView.getParent();
		float fInicio   = oConstraint.getLeft();
		float fFin     = 700;
		//Log.i("LLLLL", "fInicio: " + fInicio + " fFin: " + fFin);
		ValueAnimator oValueAnimator = ValueAnimator.ofFloat(fInicio, fFin);
		oValueAnimator.setDuration(2000L);
		oValueAnimator.setStartDelay(500L);
		oValueAnimator.setInterpolator(new AccelerateInterpolator());
		oValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			public void onAnimationUpdate(ValueAnimator animation) {
				o_ImageView.setTranslationX((float)animation.getAnimatedValue());
			}
		});
		oValueAnimator.start();
	}

	public void mover_ObjectAnimator(View v) {
		float fFin     = 700;
		ObjectAnimator oObjectAnimator = ObjectAnimator.ofFloat(o_ImageView, "translationX", fFin);
		oObjectAnimator.setDuration(2000L);
		oObjectAnimator.setStartDelay(500L);
		oObjectAnimator.setInterpolator(new AccelerateInterpolator());
		oObjectAnimator.start();
	}

	public void mover_ObjectAnimator_2(View v) {
		float fFin     = 700;
		ObjectAnimator oObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
				o_ImageView,
				PropertyValuesHolder.ofFloat("translationX", fFin),
				PropertyValuesHolder.ofFloat("scaleX", 2f),
				PropertyValuesHolder.ofFloat("scaleY", 2f)
		);
		oObjectAnimator.setDuration(2000L);
		oObjectAnimator.setStartDelay(500L);
		oObjectAnimator.start();
	}

}