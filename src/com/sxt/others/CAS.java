package com.sxt.others;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * CAS���Ƚϲ�����
 * 
 */
public class CAS {
	//���
	
    private static AtomicInteger stock = new AtomicInteger(5);	//ʵ����CAS
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				//ģ��������ʱ
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//stock.addAndGet(delta);
				Integer left = stock.decrementAndGet();
				if (left<1) {
					System.out.println("������");
					return;							
				}
				System.out.println(Thread.currentThread().getName()+"����һ����Ʒ");
				System.out.println("-->��ʣ"+left);
			}).start();
		}
	}

}
