package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ShuffleActivity extends Activity implements OnClickListener {
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// レイアウト定義
		setContentView(R.layout.activity_shuffle);
		this.imageView = (ImageView) findViewById(R.id.imageViewShuffle);
		this.imageView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(ShuffleActivity.this, ResultActivity.class);
		// アクティビティの起動
		startActivity(intent);
	}
}
