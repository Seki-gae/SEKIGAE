package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import com.example.mock.*;

public class ResultActivity extends Activity implements OnClickListener{
	private Globals globals;
	private int num;
	private LinearLayout left;
	private LinearLayout right;
	
	private ArrayList<String> alList = new ArrayList<>();
	ArrayList<Member> array = new ArrayList<Member>();
	private ArrayList<ManOrWoman> leftImages = new ArrayList<>();
	private ArrayList<ManOrWoman> rightImages = new ArrayList<>();
	
	
	private Object imageView;
	private Context context;
	public static int MAN_NUM = 3;
	public static int WOMAN_NUM = 3;
	
	public static int left_NUM = 3;
	public static int right_NUM = 3;
	
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		// レイアウト定義
		setContentView(R.layout.activity_result);
		// インテントを取得
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		this.num = intent.getIntExtra("NUM", -1);
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		// レイアウトの読み込み
		this.left = (LinearLayout) findViewById(R.id.LinearLayout_left_result1);
		this.right = (LinearLayout) findViewById(R.id.LinearLayout_right_result1);//親Viewを取得してremoveView実行
		
		
		
		ViewGroup parent = (ViewGroup)left.getParent(); 
		if ( parent != null ) {
		    parent.removeView(left);
		}
	
		ArrayList<Member> right_array = Mock.getRightMembers();
		ArrayList<Member> left_array = Mock.getLeftMembers();

		left_NUM = left_array.size();
		right_NUM = right_array.size();
		
		WindowManager wm = getWindowManager();
		Display disp = wm.getDefaultDisplay();
		LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
				disp.getHeight() / 8, LayoutParams.FILL_PARENT);
		//this.imageView = new ImageView(context);
		
		ManOrWoman manOrWoman = new ManOrWoman(this);
//		for(int i=0; i<left_NUM; i++){
//				manOrWoman.setName(left_array.get(i));
//				this.leftImages.add(manOrWoman);
//				this.left.addView(manOrWoman.getImageView(), param1);
//		}
		for (Member member : left_array) {
			manOrWoman.setName(member);
			this.leftImages.add(manOrWoman);
			ImageView imageview = new ImageView(this);
			imageview.setImageResource(R.drawable.chair_m);
			left.addView(manOrWoman.getImageView(), param1);
			//this.left.addView(manOrWoman.getImageView());//, param1);
		}
		for (Member member : right_array) {
			manOrWoman.setName(member);
			this.rightImages.add(manOrWoman);
			this.right.addView(manOrWoman.getImageView(), param1);
			
		}
	
//		for(int i=0; i<right_NUM; i++){
//			manOrWoman.setName(right_array.get(i));
//			this.leftImages.add(manOrWoman);
//			this.left.addView(manOrWoman.getImageView(), param1);		
//			}
		
	}
	
	
	@Override
	public void onClick(View v) {
		this.alList.add("A");
		this.alList.add("B");
		this.alList.add("C");
		this.alList.add("D");
		this.alList.add("E");
		
		int mCount = 0, wCount = 0;
		for (ManOrWoman manOrWoman : leftImages) {
			Member member = new Member();
			if (manOrWoman.isMan) {
				member.setGender("man");
				member.setName(this.alList.get(mCount));
				mCount++;
			} else {
				member.setGender("woman");
				member.setName(this.alList.get(wCount));
				wCount++;
			}
			
			for (ManOrWoman manOrWoman2: rightImages) {
				Member member2 = new Member();
				if (manOrWoman2.isMan) {
					member.setGender("man");
					member.setName(this.alList.get(mCount));
					mCount++;
				} else {
					member.setGender("woman");
					member.setName(this.alList.get(wCount));
					wCount++;
				}
				Intent intent;
				intent = new Intent(ResultActivity.this, MainActivity.class);
				// アクティビティの起動
				startActivity(intent);
			}		
		}
	}
}
	
