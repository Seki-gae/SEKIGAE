package com.example.test;


import java.util.HashMap;

public class ChangeSeat {

	public static void main(String[] args) {
		// mapにサンプル値代入
		HashMap<String,Member> map = new HashMap<String,Member>();
		
		//男Aは女Cが気になる。ときの処理
		Member mA = new Member();
		mA.setLike("wC");
		map.put("mA", mA);
		
		
		//mapから読み込み
		map.get("mA");
		System.out.println(mA.getLike());

	}

}
