package com.sxt.others;

import java.util.concurrent.locks.ReentrantLock;

/*
 * ��������������������ʹ�� + ������
 */
public class LockTest04 {
	ReentrantLock lock = new ReentrantLock();
	
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	//��������
    public void doSomething() throws InterruptedException {
    	lock.lock();
    	System.out.println(lock.getHoldCount());
    	//.....
    	lock.unlock();
    	System.out.println(lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
	  LockTest04 test = new LockTest04();
	  test.a();
	  Thread.sleep(1000);
	  System.out.println(test.lock.getHoldCount());
	}
//��������
class ReLock{
	//�Ƿ�ռ��
	private boolean isLocked =false;
	private Thread lockedBy =null;//�洢�߳�
	private int holdCount =0;
	
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(isLocked && lockedBy!= t) {
		wait();
		}
		isLocked = true;
		lockedBy=t;
		holdCount++;
	}
	//�ͷ���
	public void unlock() {
		if (Thread.currentThread()==lockedBy) {
			holdCount--;
			if (holdCount==0) {
				isLocked = false;
				notify();
				lockedBy=null;
			}
		}
	}
	public int getHoldCount() {
		return holdCount;
	}
}
}
