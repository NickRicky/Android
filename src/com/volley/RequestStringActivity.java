package com.volley;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo_webrequest.R;
import com.example.demo_webrequest.R.layout;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

public class RequestStringActivity extends Activity {
	RequestQueue mQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_string);
		
		mQueue = Volley.newRequestQueue(this);  
		
//		request1();
//		request2();
//		request3();
		request4();
	}
	
	public JSONObject setJsonParams(){
		JSONObject jsonSend = null;
		try{
			jsonSend = new JSONObject();
//			jsonSend.put("user", "01");
//			jsonSend.put("password", "");
//			jsonSend.put("shebeihao","1234567011");
			jsonSend.put("diancaijihao","006");
		}catch (JSONException je) {
			je.printStackTrace();
		}
		Log.d("system.print.response", jsonSend.toString());
		 return jsonSend;
	 }
	
	
	/**
	 * Request.Method : POST
	 * Request Params-Type : JSONObject  ,the third param
	 * Response Params-Type : JSONObject
	 */
	public void request4(){
		//JsonRequest也是继承自Request类的，不过由于JsonRequest是一个抽象类
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,"http://192.168.3.10:808/system/cxdcbztzt/", 
				setJsonParams(), 
				new Response.Listener<JSONObject>(){
			@Override
			public void onResponse(JSONObject response) {
				Log.d("system.print.response", response.toString());
			}
		}, new Response.ErrorListener(){
			@Override
			public void onErrorResponse(VolleyError error){
				Log.e("system.print.response", error.getMessage(), error);
			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();  
		        map.put("user", "01");  
		        map.put("password", "");  
		        map.put("shebeihao", "1234567010");  
		        map.put("diancaijihao", "006");  
		        return map;
			}
		 @Override
		    public Map<String, String> getHeaders() {
		        HashMap<String, String> headers = new HashMap<String, String>();
		        headers.put("Accept", "application/json");
		        headers.put("Content-Type", "application/json; charset=UTF-8");
		                 
		        return headers;
		    }
		};
		
		mQueue.add(jsonObjectRequest);
	}
	
	
	/**
	 * Request.Method : GET
	 * Request Params-Type : null
	 * Response Params-Type : JSONObject
	 */
	public void request3(){
		//JsonRequest也是继承自Request类的，不过由于JsonRequest是一个抽象类
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", 
				null, 
				new Response.Listener<JSONObject>(){
			@Override
			public void onResponse(JSONObject response) {
				Log.d("system.print.response", response.toString());
				}
			}, new Response.ErrorListener(){
				@Override
				public void onErrorResponse(VolleyError error){
					Log.e("system.print.response", error.getMessage(), error);
					}
				});
		mQueue.add(jsonObjectRequest);
	}

	
	/**
	 * Request.Method : GET
	 * Request Params-Type : null
	 * Response Params-Type : String
	 */
	public void request1(){
		//http://www.baidu.com
		StringRequest stringRequest = new StringRequest("http://m.weather.com.cn/mweather/101010300.shtml",  
                new Response.Listener<String>() {  
                    @Override  
                    public void onResponse(String response) {  
                        Log.d("system.print.response", response);  
                    }  
                }, new Response.ErrorListener() {  
                    @Override  
                    public void onErrorResponse(VolleyError error) {  
                        Log.e("system.print.response", error.getMessage(), error);  
                    }  
                }); 
		
		mQueue.add(stringRequest);
	}
	
	
	/**
	 * Request.Method : POST
	 * Request Params-Type : String
	 * Response Params-Type : String
	 */
	public void request2(){
		StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.3.10:808/system/log/",  
                new Response.Listener<String>() {  
            @Override  
            public void onResponse(String response) {  
                Log.d("system.print.response", response);  
            }  
        }, new Response.ErrorListener() {  
            @Override  
            public void onErrorResponse(VolleyError error) {  
                Log.e("system.print.response", error.getMessage(), error);  
            }  
        }){
			 @Override  
			    protected Map<String, String> getParams() throws AuthFailureError {  
			        Map<String, String> map = new HashMap<String, String>();  
			        map.put("user", "01");  
			        map.put("password", "");  
			        map.put("shebeihao", "1234567010");  
			        map.put("diancaijihao", "006");  
			        return map;  
			    } 
		};
		
		mQueue.add(stringRequest);
	}

}
