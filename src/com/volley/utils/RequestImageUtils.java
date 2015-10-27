package com.volley.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.example.demo_webrequest.R;

public class RequestImageUtils {
	private RequestQueue mQueue;
	private Context context;
	
	public RequestImageUtils(RequestQueue mQueue,Context context){
		this.mQueue = mQueue;
		this.context = context;
	}
	
	
	public void request1(String url,final Handler handler){
		ImageRequest imageRequest = new ImageRequest(url,  
		        new Response.Listener<Bitmap>() {  
		            @Override  
		            public void onResponse(Bitmap response) {
		            	Message message = new Message();
//		            	message.obj = response;
//		            	message.what...
		            	
		            	Bundle bundle = new Bundle();
		        		bundle.putSerializable("image", new MyBitMapObject(response));
		        		message.setData(bundle);
		                
		                if(handler != null){
		                	handler.sendMessage(message);
		                }
		            }  
		        }, 0, 0, Config.RGB_565, new Response.ErrorListener() {  
		            @Override  
		            public void onErrorResponse(VolleyError error) {  
		            	Message message = new Message();
//		            	message.obj = BitmapFactory.decodeResource(context.getResources(), R.drawable.aa);
		            	
		            	Bundle bundle = new Bundle();
		        		bundle.putSerializable("image", new MyBitMapObject(BitmapFactory.decodeResource(context.getResources(), R.drawable.aa)));
		        		message.setData(bundle);
		                
		                if(handler != null){
		                	handler.sendMessage(message);
		                }
		            }  
		        }); 
		
		mQueue.add(imageRequest);
	}
	
	
	
	public void request2(String url,ImageView imageview){
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache()); 
		
		ImageListener listener = ImageLoader.getImageListener(imageview,R.drawable.aa, R.drawable.aa);
		
		imageLoader.get(url, listener,200,200); 
	}
	
	
	
	public void request3(String url,NetworkImageView Nimageview){
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache()); 
		
		Nimageview.setDefaultImageResId(R.drawable.aa);  
		Nimageview.setErrorImageResId(R.drawable.aa);  
		Nimageview.setImageUrl(url,imageLoader); 
	}

}
