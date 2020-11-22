package com.example.animacion_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	ImageView oImagen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		oImagen = findViewById(R.id.ball_imageView);

	}

	public void mover(View v) {
		Animation oAnimacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mover_derecha);
		oImagen.startAnimation(oAnimacion);
	}
}