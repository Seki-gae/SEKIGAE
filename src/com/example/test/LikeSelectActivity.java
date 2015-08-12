package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

/**
 * @author kawabata
 *
 */
public class LikeSelectActivity extends Activity implements OnClickListener {
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
		// グローバル変数を取得
		this.globals = (Globals) this.getApplication();
		// レイアウトの読み込み
		this.left = (LinearLayout) findViewById(R.id.LinearLayout_left_select);
		this.left.setGravity(Gravity.CENTER);
		this.right = (LinearLayout) findViewById(R.id.LinearLayout_right_select);
		this.right.setGravity(Gravity.CENTER);
		
		MAN_NUM = this.globals.m_member_num;
		WOMAN_NUM = this.globals.w_member_num;
		LEFT_NUM= MAN_NUM;
		RIGHT_NUM = WOMAN_NUM;
		this.num = 1;
		WindowManager wm = getWindowManager();
		Display disp = wm.getDefaultDisplay();
		LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
				disp.getHeight() / 9, LayoutParams.FILL_PARENT);
		param1.weight = 1.0f;
		// イメージビューの作成
		for (int i = 0; i < LEFT_NUM; i++) {
			System.out.println("leftSet");
			Selector selector = new Selector(this);
			selector.setMember(this.globals.memberList.get(i));
			if(num-1 == i) selector.setSelector();
			this.leftImages.add(selector);
			this.left.addView(selector.getImageView(), param1);
		}
		// イメージビューの作成
		for (int i = 0; i < RIGHT_NUM; i++) {
			Selector selector = new Selector(this);
			selector.setMember(this.globals.memberList.get(i));
			if(num-1 == i) selector.setSelector();
			this.rightImages.add(selector);
			this.right.addView(selector.getImageView(), param1);
		}
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
		if(mCount == this.MAN_NUM && wCount == this.WOMAN_NUM){
			// for (Member member : this.globals.memberList) {
			// System.out.println(member.getGender() + member.getName());
			// }
			Intent intent;
			intent = new Intent(LikeSelectActivity.this, MainActivity.class);
			// アクティビティの起動
			startActivity(intent);
		}else{
			this.globals.memberList.clear();
	        // 確認ダイアログの生成
	        AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
	        alertDlg.setTitle("男女比がおかしいです！");
	        alertDlg.setMessage("最初に入力された男女比と一致しません。選択をやり直してください。");
	        alertDlg.setPositiveButton(
	            "OK",
	            new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                    // OK ボタンクリック処理
	                }
	            });
	        // 表示
	        alertDlg.create().show();
		}



	}

}
