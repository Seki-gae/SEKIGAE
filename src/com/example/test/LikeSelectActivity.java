package com.example.test;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @author kawabata
 *
 */
public class LikeSelectActivity extends Activity implements OnSelectListner {
	// グローバル変数
	Globals globals;
	// ボタン
	Button button;
	EditText editText;
	LinearLayout left;
	LinearLayout right;
	ImageView buttonImage;
	private ArrayList<Selector> leftImages = new ArrayList<>();
	private ArrayList<Selector> rightImages = new ArrayList<>();
	private int num;
	private ArrayList<String> alList = new ArrayList<>();
	public int MEMBER_NUM;
	private Member selectMember;
	public static int MAN_NUM = 3;
	public static int WOMAN_NUM = 3;
	public static int LEFT_NUM = 3;
	public static int RIGHT_NUM = 3;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		// レイアウト定義
		setContentView(R.layout.activity_like_select);
		// インテントを取得
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		this.num = intent.getIntExtra("NUM", -1);
		if (this.num == -1) {
			this.num = 1;
		}
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		// レイアウトの読み込み
		this.left = (LinearLayout) findViewById(R.id.LinearLayout_left_select);
		this.left.setGravity(Gravity.CENTER);
		this.right = (LinearLayout) findViewById(R.id.LinearLayout_right_select);
		this.right.setGravity(Gravity.CENTER);

		MAN_NUM = this.globals.m_member_num;
		WOMAN_NUM = this.globals.w_member_num;
		LEFT_NUM = MAN_NUM;
		RIGHT_NUM = WOMAN_NUM;
		this.MEMBER_NUM = this.globals.m_member_num + this.globals.w_member_num;
		this.selectMember = this.globals.memberList.get(this.num-1);
		WindowManager wm = getWindowManager();
		Display disp = wm.getDefaultDisplay();
		LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
				disp.getHeight() / 6, disp.getHeight() / 6);
		param1.weight = 1.0f;
		int count=0;
		// イメージビューの作成
		for (int i = 0; i < LEFT_NUM; i++) {
			System.out.println("leftSet");
			Selector selector = new Selector(this);
			selector.setListner(this);
			selector.setSelectorGender(this.selectMember.getGender());
			
			if (this.num - 1 == i)
				selector.setSelector();
			selector.setMember(this.globals.memberList.get(count));
			this.leftImages.add(selector);
			this.left.addView(selector.getImageView(), param1);
			count++;
		}
		// イメージビューの作成
		for (int i = 0; i < RIGHT_NUM; i++) {
			Selector selector = new Selector(this);
			selector.setListner(this);
			selector.setSelectorGender(this.selectMember.getGender());
			if (this.num - 1 == count)
				selector.setSelector();
			selector.setMember(this.globals.memberList.get(count));
			this.rightImages.add(selector);
			this.right.addView(selector.getImageView(), param1);
			count++;
		}
	}


	@Override
	public boolean onTouchListner(Member member) {
		int i = this.globals.memberList.indexOf(member);
		this.selectMember.setLike(this.globals.memberList.get(i));
		
		Intent intent;
		if (this.MEMBER_NUM - this.num != 0) {
			intent = new Intent(LikeSelectActivity.this, LikeSelectActivity.class);
			intent.putExtra("NUM", this.num + 1);
		} else {
			ChangeSeat changeSeat = new ChangeSeat();
			changeSeat.setMemberList(this.globals.memberList);
			changeSeat.setMemberNum(this.globals.m_member_num, this.globals.w_member_num);
			changeSeat.doChange();
			this.globals.leftList=changeSeat.getLeftSeat();
			this.globals.rightList=changeSeat.getRightSeat();
			intent = new Intent(LikeSelectActivity.this, ResultActivity.class);
			//intent = new Intent(LikeSelectActivity.this, NextActivity.class);
		}
		// アクティビティの起動
		startActivity(intent);
		return true;
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
