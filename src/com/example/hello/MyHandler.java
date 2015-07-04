package com.example.hello;

import android.util.Log;

public class MyHandler {
	private MyLooper looper;
	
	public MyHandler(){
		looper = LooperManger.getLooper();
		Log.v(" ", "looper start");
		looper.start();//��ʵʲôʱ��������Ӧ��ֵ�ÿ���
	}
	
	public void handlerMessage(MyMessage msg){
	}
	public void sendMessage(MyMessage msg){
		msg.target = this;
		looper.insert(msg);		
	}
}
