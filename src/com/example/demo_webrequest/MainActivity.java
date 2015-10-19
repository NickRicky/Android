package com.example.demo_webrequest;

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
		
		findViewById(R.id.btn_requestImage).setOnClickListener(this);
		findViewById(R.id.btn_requestString).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_requestImage:
			intent = new Intent();
			intent.setClass(this, RequestImageActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_requestString:
			intent = new Intent();
			intent.setClass(this, RequestStringActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
