������ʵķ�ʽ�ࣺܶ
��ʽһ����Google��volley��ܣ��ʺ�Ƶ����С�͵����ݷ��ʣ��󲿷���Ŀ�еĴ����������ʶ������������ͣ�
1������volley.jar��  ����  ����volley���
2������һ��RequestQueue mQueue;һ��һ��activityһ��RequestQueue�͹���
	mQueue = Volley.newRequestQueue(this); 
3��JsonObjectRequest����������࣬����add�� mQueue����
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
		//JsonRequestҲ�Ǽ̳���Request��ģ���������JsonRequest��һ��������
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
�ܽ��������������
1. ����һ��RequestQueue����
2. ����һ��Request����
3. ��Request������ӵ�RequestQueue���档


����ImageLoader�Ѿ����Ǽ̳���Request���ˣ����������÷�Ҳ������֮ǰѧ��������������ͬ���ܽ��������¿��Է�Ϊ�����Ĳ���
1. ����һ��RequestQueue����
2. ����һ��ImageLoader����
3. ��ȡһ��ImageListener����
4. ����ImageLoader��get()�������������ϵ�ͼƬ��

3. NetworkImageView���÷�
1. ����һ��RequestQueue����
2. ����һ��ImageLoader����
3. �ڲ����ļ������һ��NetworkImageView�ؼ���
4. �ڴ����л�ȡ�ÿؼ���ʵ����
5. ����Ҫ���ص�ͼƬ��ַ��