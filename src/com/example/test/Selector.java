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
	OnSelectListner listner;
	private String selectorGender;
	Member member;

	public Selector(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.imageView = new ImageView(context);
		this.imageView.setScaleType(ScaleType.FIT_CENTER);
		this.imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// イメージ画像がクリックされたときに実行される処理
				if (!Selector.this.isSameSex()) {
					Selector.this.listner.onTouchListner(Selector.this.member);
				}
			}
		});
	}

	boolean isSameSex() {
		// TODO Auto-generated method stub
		if (this.member.getGender().equals(this.selectorGender)) {
			return true;
		}
		return false;
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
		this.member = member;
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
		if (isMan()) {
			name = "m" + name;
		} else {
			name = "w" + name;
		}
		if (isSelector()) {
			name = name + "a";
		}
		int strId = this.context.getResources().getIdentifier(name, "drawable",
				this.context.getPackageName());
		System.out.println("strID" + strId);
		System.out.println("name" + name);
		int ma = R.drawable.ma;
		System.out.println("ma" + ma);
		this.imageView.setImageResource(strId);
		if (isSameSex() && !isSelector())
			imageView.setColorFilter(0xccAAAAAA);

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

	public void setSelector() {
		this.select = true;
	}

	public void setListner(OnSelectListner likeSelectActivity) {
		// TODO Auto-generated method stub
		this.listner = likeSelectActivity;
	}

	public void setSelectorGender(String gender) {
		// TODO Auto-generated method stub
		selectorGender = gender;
	}
}
