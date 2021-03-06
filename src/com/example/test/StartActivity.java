package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class StartActivity extends Activity implements OnClickListener {
	private static final int INITIAL_VALUE = 3;
	private Globals globals;
	private NumberPicker numberpicker1;
	private NumberPicker numberpicker2;
	private ImageView imageView;

	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_number);

		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		this.numberpicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
		this.numberpicker2 = (NumberPicker) findViewById(R.id.NumberPicker01);
		this.imageView = (ImageView) findViewById(R.id.imageView3);
		this.imageView.setOnClickListener(this);
		// 設定できる上限、下限を設定する
		this.numberpicker1.setMaxValue(5);
		this.numberpicker1.setMinValue(3);
		this.numberpicker2.setMaxValue(5);
		this.numberpicker2.setMinValue(3);
		// 初期値を設定する
		this.numberpicker1.setValue(INITIAL_VALUE);
		this.numberpicker2.setValue(INITIAL_VALUE);
	}

	@Override
	public void onClick(View v) {
		// グローバル変数に値を入れる
		StartActivity.this.globals.m_member_num = (StartActivity.this.numberpicker1
				.getValue());

		StartActivity.this.globals.w_member_num = StartActivity.this.numberpicker2
				.getValue();

		Intent intent;
		intent = new Intent(StartActivity.this, GenderSelectActivity.class);

		// アクティビティの起動
		startActivity(intent);
	}

}
