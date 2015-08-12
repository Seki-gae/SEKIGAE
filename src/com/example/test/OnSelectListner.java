package com.example.test;

import android.view.View.OnTouchListener;

public interface OnSelectListner extends OnTouchListener {
	/**
	 * イメージがタッチされた時のリスナーです
	 * @param member 
	 * @return 
	 */
	public boolean onTouchListner(Member member);
}
