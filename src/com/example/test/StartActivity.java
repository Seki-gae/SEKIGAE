package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StartActivity extends Activity{
	
	private Globals globals;
	
	protected void onCreate(Bundle savedInstanceState){
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_number);
		
		//グローバル変数を取得
        this.globals = (Globals) this.getApplication();
        TextView textView = (TextView) findViewById(R.id.textView2);
        String memberList = "" ;
		
	}
}
