package com.example.test;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Human {
	private ImageView imageView;
	public Boolean isMan;

	public Human(Context context) {
		// TODO Auto-generated constructor stub
		this.imageView = new ImageView(context);
		this.imageView.setScaleType(ScaleType.FIT_CENTER);
		this.imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// イメージ画像がクリックされたときに実行される処理
				if (Human.this.isMan()) {
					Human.this.setWoman();
				} else {
					Human.this.setMan();
				}
			}
		});
	}
	public void setMan() {
		this.imageView.setImageResource(R.drawable.chair_m);
		this.isMan = true;
	}

	public void setWoman() {
		this.imageView.setImageResource(R.drawable.chair_w);
		this.isMan = false;
	}

	public ImageView getImageView() {
		return this.imageView;
	}

	public Boolean isMan() {
		return isMan;
	}
}
