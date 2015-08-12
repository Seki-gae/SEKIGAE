package com.example.test;

import java.util.ArrayList;

import android.content.Context;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import android.widget.ImageView;

public class ManOrWoman {

	private ImageView imageView;
	public Boolean isMan;
	Context context;
	
	public ManOrWoman(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.imageView = new ImageView(context);
	}
	
	public void setName(Member member){
		String name = member.getName();
		if(member.getGender()=="man"){
			name = "m" + name;
			this.isMan = true;
		}
		else{
			name = "w" + name;
			this.isMan = false;
		}
		//リソースIDの取得
/*		int strId = context.getResources().
				getIdentifier("drawable", name, context.getPackageName());*/
		int strId = context.getResources().
				getIdentifier(name,"drawable",context.getPackageName());
		System.out.println("strID" + strId);
		System.out.println("name" + name);
		int ma =R.drawable.ma;
		System.out.println("ma" + ma);
		
		this.imageView.setImageResource(strId);
	}
	
	

	
	/*public void setMan() {
		this.imageView.setImageResource(R.drawable.chair_m);
		this.isMan = true;
	}

	public void setWoman() {
		this.imageView.setImageResource(R.drawable.chair_w);
		this.isMan = false;
	}*/

	public ImageView getImageView() {
		return this.imageView;
	}

	public Boolean isMan() {
		return isMan;
	}
}


