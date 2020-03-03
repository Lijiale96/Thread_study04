package com.sxt.others;

/*
 * ��������������������ʹ�� + ������
 */
public class LockTest03 {
	ReLock lock = new ReLock();
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
	  LockTest03 test = new LockTest03();
	  test.a();
	  Thread.sleep(1000);
	  System.out.println(test.lock.getHoldCount());//�����ͷŵ�û
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
		while(isLocked && lockedBy!= t) {  //�жϽ������߳��ǲ����������̣߳�������ǣ��ȴ�
		}
		isLocked = true;   //����ǣ����õȴ����ͼ�������1
		lockedBy=t;
		holdCount++;
	}
	//�ͷ���
	public synchronized void unlock() {
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
