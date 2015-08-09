package com.example.test;

import android.app.Application;

public class Globals extends Application {
	// グローバルに使用する変数たち
	int hoge;
	String str;
	boolean fuga;
	int[] hogera = new int[10];

	// ぜんぶ初期化するメソッド
	public void GlobalsAllInit() {
		this.hoge = 0;
		this.str = "あいうえお";
		this.fuga = true;
		for (int i = 0; i < this.hogera.length; i++) {
			 this.hogera[i] = 0;
		}
	}
}