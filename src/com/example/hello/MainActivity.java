package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
	private final int NET_ERROR = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.v(" ", "Activity onCreate");
        setContentView(R.layout.activity_main);
    }
    public void Go(View view){
    	new Thread("xiaoxiao"){
		    public void run() {
		    	int i = 0;
		    	while(i < 10){
					Log.v(" ", "send message");
					MyMessage msg = new MyMessage();
		        	msg.what = NET_ERROR;
		        	msg.arg = i;
					handler.sendMessage(msg);
					i++;
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
    	}.start();
    }

    private MyHandler handler = new MyHandler(){
    	public void handlerMessage(MyMessage msg) {
    		if(msg.what == NET_ERROR){
    			Log.v(" " , "" + msg.arg);
    			//Toast.makeText(MainActivity.this, "ÍøÂç´íÎó", Toast.LENGTH_LONG).show();
    		}
    	}
    };
    
}
