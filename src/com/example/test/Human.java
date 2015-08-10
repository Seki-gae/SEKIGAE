package com.example.test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Human {
	private ImageView imageView;
	private Boolean isMan = false;

	public Human(Context context) {
		// TODO Auto-generated constructor stub
		this.imageView = new ImageView(context);
	}

	public void setMan() {
		this.imageView.setImageResource(R.drawable.bule);
		this.isMan = true;
	}

	public void setWoman() {
		this.imageView.setImageResource(R.drawable.pink);
		this.isMan = false;
	}
	
	public ImageView getImageView(){
		return this.imageView;
	}
}
