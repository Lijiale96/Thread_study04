package com.sxt.others;

/*
 * ThreadLocal:ÿ���߳�����Ĵ洢���ء��ֲ�����
 * get/set/initialValue
 * 
 */
public class ThreadLocalTest01 {
	
   //private static ThreadLocal<Integer>threadLocal = new ThreadLocal<>();
   //���ĳ�ʼֵ
	/* private static ThreadLocal<Integer>threadLocal = new ThreadLocal<>(){
	protected Integer initialValue() {
		return 200;
	};
	 };*/
	
	private static ThreadLocal<Integer>threadLocal = ThreadLocal.withInitial(()->200);
   
   public static void main(String[] args) {
	//��ȡֵ
	System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
	
	//����ֵ
	threadLocal.set(99);
	System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
	new Thread(new MyRun()).start();
	new Thread(new MyRun()).start();
	new Thread(new MyRun()).start();
}
   
   public static class MyRun implements Runnable{
	   @Override
	public void run() {
		   threadLocal.set((int)(Math.random()*99));
		   System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
	}
   }
}
