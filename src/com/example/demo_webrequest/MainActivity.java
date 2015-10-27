package com.example.demo_webrequest;

import com.volley.VolleyActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btn_volley).setOnClickListener(this);
		findViewById(R.id.btn_myutils).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_volley:
			intent = new Intent();
			intent.setClass(this, VolleyActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_myutils:
//			intent = new Intent();
//			intent.setClass(this, RequestStringActivity.class);
//			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
