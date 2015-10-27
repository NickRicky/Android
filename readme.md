网络访问的方式很多：
方式一：用Google的volley框架，适合频繁的小型的数据访问（大部分项目中的大多数网络访问都属于这种类型）
1、导入volley.jar包  或者  关联volley框架
2、定义一个RequestQueue mQueue;一般一个activity一个RequestQueue就够了
	mQueue = Volley.newRequestQueue(this); 
3、JsonObjectRequest访问网络的类，并且add到 mQueue……
	public JSONObject setJsonParams(){
		JSONObject jsonSend = null;
		try{
			jsonSend = new JSONObject();
			jsonSend.put("diancaijihao","006");
		}catch (JSONException je) {
			je.printStackTrace();
		}
		Log.d("system.print.response", jsonSend.toString());
		 return jsonSend;
	 }
	
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
		});
		
		mQueue.add(jsonObjectRequest);
	}
总结基本三步操作：
1. 创建一个RequestQueue对象。
2. 创建一个Request对象。
3. 将Request对象添加到RequestQueue里面。


由于ImageLoader已经不是继承自Request的了，所以它的用法也和我们之前学到的内容有所不同，总结起来大致可以分为以下四步：
1. 创建一个RequestQueue对象。
2. 创建一个ImageLoader对象。
3. 获取一个ImageListener对象。
4. 调用ImageLoader的get()方法加载网络上的图片。

3. NetworkImageView的用法
1. 创建一个RequestQueue对象。
2. 创建一个ImageLoader对象。
3. 在布局文件中添加一个NetworkImageView控件。
4. 在代码中获取该控件的实例。
5. 设置要加载的图片地址。