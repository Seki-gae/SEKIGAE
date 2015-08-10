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
public class SexActivity extends Activity implements OnClickListener {
	// グローバル変数
	Globals globals;
	// ボタン
	Button button;

	EditText editText;
	LinearLayout left;
	LinearLayout right;
	private ArrayList<Human> leftImages;
	private ArrayList<Human> rightImages;
	private int num;

	public static int M_NUM = 4;
	public static int F_NUM = 4;

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

	}

	@Override
	public void onClick(View v) {}

}
