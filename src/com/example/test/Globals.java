package com.example.test;

import java.util.ArrayList;

import android.app.Application;

public class Globals extends Application {
	// グローバルに使用する変数たち
	int hoge;
	String str;
	boolean fuga;
	int[] hogera = new int[10];
	ArrayList<String> nameList = new ArrayList<>();
	
	/**
	 * global変数を初期化します
	 */
	public void GlobalsAllInit() {
		this.hoge = 0;
		this.str = ""; //$NON-NLS-1$
		this.fuga = true;
		for (int i = 0; i < this.hogera.length; i++) {
			 this.hogera[i] = 0;
		}
		this.nameList.clear();
	}
}