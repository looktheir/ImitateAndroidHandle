package com.example.hello;

import android.util.Log;

public class MyHandler {
	private MyLooper looper;
	
	public MyHandler(){
		looper = LooperManger.getLooper();
		Log.v(" ", "looper start");
		looper.start();//其实什么时候启动它应该值得考虑
	}
	
	public void handlerMessage(MyMessage msg){
	}
	public void sendMessage(MyMessage msg){
		msg.target = this;
		looper.insert(msg);		
	}
}
