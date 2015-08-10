package com.example.test;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
	private ArrayList<Human> leftImages = new ArrayList<>();
	private ArrayList<Human> rightImages = new ArrayList<>();
	private int num;

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
		//レイアウトの読み込み
		left = (LinearLayout) findViewById(R.id.LinearLayout_left);
		right = (LinearLayout) findViewById(R.id.LinearLayout_right);

		// イメージビューの作成
		for (int i = 0; i < MAN_NUM; i++) {
			Human human = new Human(this);
			human.setMan();
			leftImages.add(new Human(this));
			left.addView(human.getImageView());
		}
		// イメージビューの作成
		for (int i = 0; i < WOMAN_NUM; i++) {
			Human human = new Human(this);
			human.setWoman();
			rightImages.add(new Human(this));
			right.addView(human.getImageView());
		}
		
	}

	@Override
	public void onClick(View v) {
	}

}
