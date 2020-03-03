package com.sxt.others;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Timer timer = new Timer();
         //执行安排
         //timer.schedule(new MyTask(),1000);//执行任务一次
         timer.schedule(new MyTask(),1000,200);//执行多次，1s以后，每隔200ms再执行
        Calendar cal = new GregorianCalendar(2099,12,31,21,53,44);
         timer.schedule(new MyTask(),cal.getTime(), 200);//5秒开始
	}

}
//任务类
class MyTask extends TimerTask{

	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			System.out.println("放空大脑，休息一会");
		}
		System.out.println("--------end--------");
	}
     
	

}