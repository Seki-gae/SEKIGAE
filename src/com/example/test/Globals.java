package com.example.test;

import java.util.ArrayList;

import android.app.Application;

public class Globals extends Application {
	// グローバルに使用する変数
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<Integer> m_member_num = new ArrayList<>();
	ArrayList<Integer> w_member_num = new ArrayList<>();	
	/**
	 * global変数を初期化します
	 */
	public void GlobalsAllInit() {
		if(this.nameList.size() != 0){
			this.nameList.clear();			
		}

	}
}