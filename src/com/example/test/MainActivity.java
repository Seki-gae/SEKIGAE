package com.example.test;

import java.util.HashMap;

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

	public static int MEMBER_NUM = 1;

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
		//10人分のメンバインスタンス生成。
		Member mA = new Member();
		Member mB = new Member();
		Member mC = new Member();
		Member mD = new Member();
		Member mE = new Member();
		Member wA = new Member();
		Member wB = new Member();
		Member wC = new Member();
		Member wD = new Member();
		Member wE = new Member();
		
		Member lefsMember = new Member(likeName);
//		lefsMember.setGender(gender);
		int i = this.globals.memberList.indexOf(lefsMember);
		//男Aは女Cが気になる。ときの処理
		mA.setLike(globals.memberList.get(i));
		System.out.println(mA.getLike());
		//mapにメンバ情報を代入。
		//map.put("mA",);
		//mapから読み込み
		//map.get("mA");
		//System.out.println(mA.getLike());
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
