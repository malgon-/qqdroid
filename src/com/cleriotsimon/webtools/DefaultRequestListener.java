package com.cleriotsimon.webtools;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.pixellostudio.qqdroid.MyApplication;

public class DefaultRequestListener extends AsyncHttpResponseHandler {
	AsyncHttpResponseHandler handler = null;
	long maxTime;
	String url;

	DefaultRequestListener(AsyncHttpResponseHandler h, long mtime, String u) {
		handler = h;
		maxTime = mtime;
		url = u;
	}

	@Override
	public void onSuccess(String response) {
		DBHandler db = new DBHandler(MyApplication.getAppContext());
		db.addContent(url, response, maxTime);
		handler.onSuccess(response);
	}
}
