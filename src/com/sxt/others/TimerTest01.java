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
         //ִ�а���
         //timer.schedule(new MyTask(),1000);//ִ������һ��
         timer.schedule(new MyTask(),1000,200);//ִ�ж�Σ�1s�Ժ�ÿ��200ms��ִ��
        Calendar cal = new GregorianCalendar(2099,12,31,21,53,44);
         timer.schedule(new MyTask(),cal.getTime(), 200);//5�뿪ʼ
	}

}
//������
class MyTask extends TimerTask{

	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			System.out.println("�ſմ��ԣ���Ϣһ��");
		}
		System.out.println("--------end--------");
	}
     
	

}