package Thread;


//class runnable_NewThread1 implements Runnable {
//	Thread t;
//
//	runnable_NewThread1() {
//		// 创建第一个新线程
//		t = new Thread(this, "Demo Thread1");
//		System.out.println("Child thread: " + t);
//		t.start(); // 开始线程
//	}
//
//	// 第一个线程入口
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
//		// 创建第二个新线程
//		t = new Thread(this, "Demo Thread2");
//		System.out.println("Child thread: " + t);
//		t.start(); // 开始线程
//	}
//
//	// 第二个线程入口
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
			// 第一个线程入口
			public void run() {
				System.out.println("t1试图占用xx");
				synchronized (xx) {
					System.out.println("t1占用xx");
					for (int i = 0; i < 100000; i++) {
						xx.plus();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t1释放xx");
					System.out.println("t1线程结束");
				}
			}
		};

		Thread t2 = new Thread() {
			// 第一个线程入口
			public void run() {
				System.out.println("t2试图占用xx");
				synchronized (xx) {
					System.out.println("t2占用xx");
					for (int i = 0; i < 100000; i++) {
						xx.reduce();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2释放xx");
					System.out.println("t2线程结束");
				}
			}
		};

		t1.start();
		t2.start();

		Thread t3 = new Thread() {
			// 第一个线程入口
			public void run() {
				System.out.println("t3试图占用xx");
				synchronized (xx) {
					System.out.println("t3占用xx");
					System.out.println(xx.a);
					System.out.println("t3释放xx");
					System.out.println("t3线程结束");
				}
			}
		};
		synchronized (t1) {
			synchronized (t2) {
				System.out.println("t3启动");
				t3.start();
				
			}
		}

	}
}
