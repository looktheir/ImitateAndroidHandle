package com.example.hello;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class MyLooper extends Thread{
	//��Ϣ����
	private List<MyMessage> list = new ArrayList<MyMessage>();
	private static final boolean Stop = false;
	private MyMessage msg;
		
	//��ʼ������
	public void init(){
		list.clear();
	}
	
	//������Ϣ������
	public void insert(MyMessage msg){
		list.add(msg);
	}
	 
	public void run(){
		Log.v(" ", "Runnable run");
		//���activityû����������ôһֱִ��
		while(!Stop){
			//�������Ϊ��
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
