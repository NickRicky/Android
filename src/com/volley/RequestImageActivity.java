package com.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.demo_webrequest.R;
import com.volley.utils.MyBitMapObject;
import com.volley.utils.RequestImageUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

public class RequestImageActivity extends Activity {
	private RequestImageUtils requestImageUtils;
	private RequestQueue mQueue;
	
	private ImageView iv_image;
	private NetworkImageView niv_image;

	
	private Handler requestImageUtils1 = new Handler() {
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			MyBitMapObject image = (MyBitMapObject)bundle.getSerializable("image");
			iv_image.setImageBitmap(image.getBitMap());
			
//			iv_image.setImageBitmap((Bitmap) msg.obj);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		iv_image = (ImageView) findViewById(R.id.iv_image);
		niv_image = (NetworkImageView) findViewById(R.id.niv_image);
		
		mQueue = Volley.newRequestQueue(this);  
		requestImageUtils = new RequestImageUtils(mQueue, this);
		
		
//		requestImageUtils.request1("http://192.168.3.46:8080/bb.jpg", requestImageUtils1);
		
//		requestImageUtils.request2("http://192.168.3.46:8080/bb.jpg", iv_image);
		
		requestImageUtils.request3("http://192.168.3.46:8080/bb.jpg", niv_image);
	}
	
	

}
