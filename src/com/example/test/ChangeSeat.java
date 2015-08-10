package com.example.test;


import java.util.ArrayList;
import java.util.HashMap;

public class ChangeSeat {

	public static void main(String[] args) {
		// mapにサンプル値代入
		HashMap<String,Member> map = new HashMap<String,Member>();
		
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
		
		//男Aは女Cが気になる。ときの処理
		mA.setLike(wC);
		
		//mapにメンバ情報を代入。
		map.put("mA", mA);
		map.put("mB", mB);
		map.put("mC", mC);
		
		//mapをグローバルクラスに格納
		
		
		//mapから読み込み
		map.get("mA");
		System.out.println(mA.getLike());

	}

}
