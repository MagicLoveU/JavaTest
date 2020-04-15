package Thread;
// ͨ���̳� Thread �����߳�
class NewThread2 extends Thread {
   NewThread2() {
      // �����ڶ������߳�
      super("Demo Thread");
      System.out.println("Child thread: " + this);
      start(); // ��ʼ�߳�
   }
 
   // �ڶ����߳����
   public void run() {
      try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Child Thread: " + i);
                            // ���߳�����һ��
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Child interrupted.");
      }
      System.out.println("Exiting child thread.");
   }
}
 
public class thread_extend {
   public static void main(String args[]) {
      new NewThread2(); // ����һ�����߳�
      try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Main Thread: " + i);
            Thread.sleep(100);
         }
      } catch (InterruptedException e) {
         System.out.println("Main thread interrupted.");
      }
      System.out.println("Main thread exiting.");
   }
}