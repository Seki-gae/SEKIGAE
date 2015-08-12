package com.example.test;

import java.util.HashMap;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

/**
 * @author kawabata
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	// グローバル変数
	Globals globals;
	// ボタン
	Button button;
	private int num;

	public
	int MEMBER_NUM ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		// レイアウト定義
		setContentView(R.layout.activity_main);
		// インテントを取得
		Intent intent = getIntent();
		// インテントに保存されたデータを取得
		this.num = intent.getIntExtra("NUM", -1);
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		//　合計人数を計算
		MEMBER_NUM =this.globals.m_member_num + this.globals.w_member_num;
		
		// 選択者の性別を判定
//		Member selectMember = this.globals.memberList.get(num-1);
//		if (selectMember.getGender()=="man"){
//			
//		}else{
//			
//		}
		
		if (this.num == -1) {
			this.num = 1;
			// 初期化
			this.globals.GlobalsAllInit();
		}
		this.button = (Button) findViewById(R.id.button1);
		this.button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		HashMap<String,Member> map = new HashMap<String,Member>();
		// Spinnerオブジェクトを取得
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
		// 選択された値を取得
		String likeName = (String)spinner.getSelectedItem();
		// 名前と性別が一致する人を検索
		Member lefsMember = new Member(likeName);
        //lefsMember.setGender();
		Member selectMember = this.globals.memberList.get(num-1);
		int i = this.globals.memberList.indexOf(lefsMember);
		selectMember.setLike(globals.memberList.get(i));
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
