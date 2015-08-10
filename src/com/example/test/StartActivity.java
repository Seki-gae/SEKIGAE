package com.example.test;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;


public class StartActivity extends Activity{
	
	private Globals globals;
	private NumberPicker numberpicker1;
	private NumberPicker numberpicker2;
	private Button button;
	
	protected void onCreate(Bundle savedInstanceState){
		System.out.println("ACTIVITY ONCLEATE"); //$NON-NLS-1$
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_number);
		
		//グローバル変数を取得
        this.globals = (Globals) this.getApplication();
        TextView textView = (TextView) findViewById(R.id.textView2);
		this.button = (Button) findViewById(R.id.button1);	
		this.numberpicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
		this.numberpicker2 = (NumberPicker) findViewById(R.id.NumberPicker01);
	}
	
	public void onClick(View v){
		// グローバル変数に値を入れる
		StartActivity.this.globals.m_member_num.add(StartActivity.this.numberpicker1
				.getValue());
		
		StartActivity.this.globals.m_member_num.add(StartActivity.this.numberpicker2
				.getValue());
		
		Intent intent;
		intent = new Intent(StartActivity.this, SexActivity.class);
		
		// アクティビティの起動
		startActivity(intent);
	}
	
	
	
	
	
}
