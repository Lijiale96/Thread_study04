package com.sxt.others;

/*
 * ����ģʽ;����ʽ��·�����ϼ��벢�����ƣ���֤�ڶ��̻߳����£��������һ������
 * 1��������˽�л�-->�����ⲿnew������
 * 2���ṩ˽�еľ�̬����-->�洢����ĵ�ַ
 * 3���ṩ�����ľ�̬����-->��ȡ����
 * 
 * 
 */
public class DoubleCheckedLocking {
	//2���ṩ˽�еľ�̬����
	//û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	private static volatile DoubleCheckedLocking instance;
	//1��������˽�л�
	private DoubleCheckedLocking() {
		
	}
	//3���ṩ�����ľ�̬����  �������� ��һ����Ҫ�ȴ�
	public static DoubleCheckedLocking getInstnce() {
		//�ٴμ��
		if (null!=instance) { //���ⲻ��Ҫ��ͬ�����Ѿ����ڶ����������
			return instance;
		}
		synchronized(DoubleCheckedLocking.class){  //��ʱ�����ĺ��
			if (null==instance) {
//				try {
//					Thread.sleep(time);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				instance = new DoubleCheckedLocking();//�ȽϺ�ʱ
				//1�����ٿռ�//2����ʼ��������Ϣ//3�����ض���ĵ�ַ������
				}
			}
		return instance;
		}
	
	
	public static DoubleCheckedLocking getInstnce1(long time) {
			if (null==instance) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
				//1�����ٿռ�//2����ʼ��������Ϣ//3�����ض���ĵ�ַ������
			}	
		return instance;
		}
	
	public static void main(String[] args) {
		Thread t =new Thread(()->{
			System.out.println(DoubleCheckedLocking.getInstnce());
		});
		t.start();
		System.out.println(DoubleCheckedLocking.getInstnce());
	}

}
