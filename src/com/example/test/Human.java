package com.example.test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.test.IsolatedContext;
import android.view.View;
import android.widget.ImageView;

public class Human {
	private ImageView imageView;
	private Boolean isMan = false;

	public Human(Context context) {
		// TODO Auto-generated constructor stub
		this.imageView = new ImageView(context);
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
		this.imageView.setImageResource(R.drawable.bule);
		this.isMan = true;
	}

	public void setWoman() {
		this.imageView.setImageResource(R.drawable.pink);
		this.isMan = false;
	}

	public ImageView getImageView() {
		return this.imageView;
	}

	public Boolean isMan() {
		return isMan;
	}
}
