package com.example.test;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Selector {
	private ImageView imageView;
	public Boolean isMan;
	private Context context;
	private Boolean select = false;

	public Selector(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.imageView = new ImageView(context);
		this.imageView.setScaleType(ScaleType.FIT_CENTER);
		this.imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// イメージ画像がクリックされたときに実行される処理
				if (Selector.this.isMan()) {
					Selector.this.setWoman();
				} else {
					Selector.this.setMan();
				}
			}
		});
	}

	private void setMan() {
		// this.imageView.setImageResource(R.drawable.marum);
		this.isMan = true;
	}

	private void setWoman() {
		// this.imageView.setImageResource(R.drawable.maruw);
		this.isMan = false;
	}

	public void setMember(Member member) {
		if (member.getGender().equals("man")) {
			setMan();
		} else {
			setWoman();
		}
		setImage(member);
	}

	private void setImage(Member member) {
		// TODO Auto-generated method stub
		String name = member.getName();
		if(member.getGender()=="man"){
			name = "m" + name;
			this.isMan = true;
		}
		else{
			name = "w" + name;
			this.isMan = false;
		}
		if(isSelector()){
			name = name + "a";
		}
		int strId = this.context.getResources().getIdentifier(name, "drawable",
				this.context.getPackageName());
		System.out.println("strID" + strId);
		System.out.println("name" + name);
		int ma = R.drawable.ma;
		System.out.println("ma" + ma);
		this.imageView.setImageResource(strId);
	}

	private boolean isSelector() {
		// TODO Auto-generated method stub
		return this.select;
	}

	public ImageView getImageView() {
		return this.imageView;
	}

	public Boolean isMan() {
		return this.isMan;
	}
	
	public void setSelector(){
		this.select = true;
	}
}
