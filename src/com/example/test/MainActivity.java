package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author kawabata
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	// グローバル変数
	Globals globals;
	// ボタン
	Button button;

	EditText editText;
	private int num;

	public static int MEMBER_NUM = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// インテントを取得
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		this.num = intent.getIntExtra("NUM", -1);
		if (this.num == -1) {
			this.num = 1;
		}
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		// 初期化
		this.globals.GlobalsAllInit();
		this.editText = (EditText) findViewById(R.id.editText1);
		// レイアウト定義
		this.button = (Button) findViewById(R.id.button1);
		this.button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// グローバル変数に値を入れる
		MainActivity.this.globals.str = MainActivity.this.editText.getText()
				.toString();
		// インテントの生成
		Intent intent;
		if (this.MEMBER_NUM - this.num != 0) {
			intent = new Intent(MainActivity.this, MainActivity.class);
			intent.putExtra("NUM", this.num + 1);
		} else {
			intent = new Intent(MainActivity.this, NextActivity.class);
		}
		// アクティビティの起動
		startActivity(intent);

	}

}
