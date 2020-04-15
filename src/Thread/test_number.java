package Thread;

public class test_number {

	public int a;

	public synchronized void plus() {
		a += 1;
		//System.out.println(a);
	}

	public synchronized void reduce() {
		a -= 1;
		//System.out.println(a);
	}

}
