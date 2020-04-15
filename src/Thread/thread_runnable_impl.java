package Thread;


//class runnable_NewThread1 implements Runnable {
//	Thread t;
//
//	runnable_NewThread1() {
//		// ������һ�����߳�
//		t = new Thread(this, "Demo Thread1");
//		System.out.println("Child thread: " + t);
//		t.start(); // ��ʼ�߳�
//	}
//
//	// ��һ���߳����
//	public void run() {
//		synchronized (test_number.a) {
//			for (int i = 0; i < 100000; i++) {
//				test_number.a += 1;
//			}
//		}
//	}
//}
//
//class runnable_NewThread2 implements Runnable {
//	Thread t;
//
//	runnable_NewThread2() {
//		// �����ڶ������߳�
//		t = new Thread(this, "Demo Thread2");
//		System.out.println("Child thread: " + t);
//		t.start(); // ��ʼ�߳�
//	}
//
//	// �ڶ����߳����
//	public void run() {
//		synchronized (test_number.a) {
//			for (int i = 0; i < 100000; i++) {
//				test_number.a -= 1;
//			}
//		}
//	}
//}

public class thread_runnable_impl {

	public static void main(String args[]) {

		test_number xx = new test_number();

		Thread t1 = new Thread() {
			// ��һ���߳����
			public void run() {
				System.out.println("t1��ͼռ��xx");
				synchronized (xx) {
					System.out.println("t1ռ��xx");
					for (int i = 0; i < 100000; i++) {
						xx.plus();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t1�ͷ�xx");
					System.out.println("t1�߳̽���");
				}
			}
		};

		Thread t2 = new Thread() {
			// ��һ���߳����
			public void run() {
				System.out.println("t2��ͼռ��xx");
				synchronized (xx) {
					System.out.println("t2ռ��xx");
					for (int i = 0; i < 100000; i++) {
						xx.reduce();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2�ͷ�xx");
					System.out.println("t2�߳̽���");
				}
			}
		};

		t1.start();
		t2.start();

		Thread t3 = new Thread() {
			// ��һ���߳����
			public void run() {
				System.out.println("t3��ͼռ��xx");
				synchronized (xx) {
					System.out.println("t3ռ��xx");
					System.out.println(xx.a);
					System.out.println("t3�ͷ�xx");
					System.out.println("t3�߳̽���");
				}
			}
		};
		synchronized (t1) {
			synchronized (t2) {
				System.out.println("t3����");
				t3.start();
				
			}
		}

	}
}
