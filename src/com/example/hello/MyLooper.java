package com.example.hello;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class MyLooper extends Thread{
	//消息队列
	private List<MyMessage> list = new ArrayList<MyMessage>();
	private static final boolean Stop = false;
	private MyMessage msg;
		
	//初始化队列
	public void init(){
		list.clear();
	}
	
	//插入消息到队列
	public void insert(MyMessage msg){
		list.add(msg);
	}
	 
	public void run(){
		Log.v(" ", "Runnable run");
		//如果activity没有消亡，那么一直执行
		while(!Stop){
			//如果队列为空
			if(list.isEmpty()){
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			msg = list.get(0);
			msg.target.handlerMessage(msg);
			list.remove(0);
		}
	}
}

class LooperManger{
	private static MyLooper looper = null;
		
	public static MyLooper getLooper(){
		if(looper == null)
			looper = new MyLooper();
		return looper;
	}
}
