package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author kawabata
 *
 */
public class GenderSelectActivity extends Activity implements OnClickListener {
	// グローバル変数
	Globals globals;
	// ボタン
	Button button;

	EditText editText;
	LinearLayout left;
	LinearLayout right;
	ImageView buttonImage;
	private ArrayList<Human> leftImages = new ArrayList<>();
	private ArrayList<Human> rightImages = new ArrayList<>();
	private int num;
	private ArrayList<String> alList = new ArrayList<>();

	public static int MAN_NUM = 3;
	public static int WOMAN_NUM = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		// レイアウト定義
		setContentView(R.layout.activity_sex);
		// インテントを取得
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		this.num = intent.getIntExtra("NUM", -1);
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		// レイアウトの読み込み
		this.left = (LinearLayout) findViewById(R.id.LinearLayout_left);
		this.right = (LinearLayout) findViewById(R.id.LinearLayout_right);
		MAN_NUM = this.globals.m_member_num;
		WOMAN_NUM = this.globals.w_member_num;
		LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		param1.weight = 1.0f;
		// イメージビューの作成
		for (int i = 0; i < MAN_NUM; i++) {
			Human human = new Human(this);
			human.setMan();
			this.leftImages.add(human);
			this.left.addView(human.getImageView(), param1);
		}
		// イメージビューの作成
		for (int i = 0; i < WOMAN_NUM; i++) {
			Human human = new Human(this);
			human.setWoman();
			this.rightImages.add(human);
			this.right.addView(human.getImageView(), param1);
		}
		buttonImage = (ImageView) findViewById(R.id.imageView2);
		buttonImage.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		this.alList.add("A");
		this.alList.add("B");
		this.alList.add("C");
		this.alList.add("D");
		this.alList.add("E");
		this.alList.add("F");
		this.alList.add("G");
		this.alList.add("H");

		int mCount = 0, wCount = 0;
		// イメージビューの作成
		for (Human human : leftImages) {
			Member member = new Member();
			if (human.isMan) {
				member.setGender("man");
				member.setName(this.alList.get(mCount));
				mCount++;
			} else {
				member.setGender("woman");
				member.setName(this.alList.get(wCount));
				wCount++;
			}
			this.globals.memberList.add(member);
		}
		for (Human human : rightImages) {
			Member member = new Member();
			if (human.isMan) {
				member.setGender("man");
				member.setName(this.alList.get(mCount));
				mCount++;
			} else {
				member.setGender("woman");
				member.setName(this.alList.get(wCount));
				wCount++;
			}
			this.globals.memberList.add(member);
		}
		
//		for (Member member : this.globals.memberList) {
//			System.out.println(member.getGender() + member.getName());
//		}
		Intent intent;
		intent = new Intent(GenderSelectActivity.this, MainActivity.class);
		// アクティビティの起動
		startActivity(intent);

	}

}
