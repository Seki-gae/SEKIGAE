package com.example.test;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {
	private Globals globals;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		//グローバル変数を取得
        this.globals = (Globals) this.getApplication();
        TextView textView = (TextView) findViewById(R.id.textView1);
        String memberList = "" ;
        for (Member member : this.globals.memberList) {
			memberList += member.getName() + ":" + member.getLike()+ member.getLiked() +member.getGender()+member.getSit()+ "\n"; 
		}
        textView.setText(memberList);
	}
}
