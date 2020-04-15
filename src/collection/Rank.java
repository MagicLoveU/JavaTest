package collection;

public class Rank {

	// ��ʼ�����飬40000�������
	public int[] Init() {

		int randoms[] = new int[40000];

		for (int i = 0; i < 40000; i++) {
			randoms[i] = (int) (Math.random() * 100 * 1000);
		}

		return randoms;
	}

	// ð������
	public long Bubble_sort(int[] randoms) {

		long a = System.currentTimeMillis();
		int p;

		for (int i = 0; i < randoms.length; i++) {
			for (int j = 0; j < randoms.length - 1; j++) {
				if (randoms[j] > randoms[j + 1]) {
					p = randoms[j];
					randoms[j] = randoms[j + 1];
					randoms[j + 1] = p;

				}
			}
		}

		long b = System.currentTimeMillis();
		return b - a;
	}

	// ѡ������
	public long Selection_sort(int[] randoms) {

		long a = System.currentTimeMillis();
		int p;

		for (int i = 0; i < randoms.length - 1; i++) {
			for (int j = i + 1; j < randoms.length; j++) {

				if (randoms[i] > randoms[j]) {
					p = randoms[j];
					randoms[j] = randoms[i];
					randoms[i] = p;

				}
			}
		}

		long b = System.currentTimeMillis();
		return b - a;
	}

	// ����������
	public long Binary_sort_tree(int[] randoms) {

		long a = System.currentTimeMillis();
		Node roots = new Node();

		for (int number : randoms) {
			roots.add(number);
		}

		long b = System.currentTimeMillis();
		return b - a;
	}

	// ��������
	public static void Quick_sort_recursive(int[] randoms, int low, int high) {
		int i, j, temp, t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		// temp���ǻ�׼λ
		temp = randoms[low];

		while (i < j) {
			// �ȿ��ұߣ���������ݼ�
			while (temp <= randoms[j] && i < j) {
				j--;
			}
			// �ٿ���ߣ��������ҵ���
			while (temp >= randoms[i] && i < j) {
				i++;
			}
			// ������������򽻻�
			if (i < j) {
				t = randoms[j];
				randoms[j] = randoms[i];
				randoms[i] = t;
			}

		}
		// ��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
		randoms[low] = randoms[i];
		randoms[i] = temp;

		// �ݹ�����������
		Quick_sort_recursive(randoms, low, j - 1);
		// �ݹ�����Ұ�����
		Quick_sort_recursive(randoms, j + 1, high);
	}

	// ��������ʱ��
	public long Quick_sort(int randoms1[], int low1, int high1) {

		long a = System.currentTimeMillis();
		Quick_sort_recursive(randoms1, low1, high1);
		long b = System.currentTimeMillis();
		return b - a;
	}

	public static void main(String[] args) {

		Rank a = new Rank();
		 int randoms[] = { 2, 3, 1, 5, 7, 9, 6, 4, 0, 8 };
//		int randoms[] = a.Init();

//		 System.out.println("ð������ʱ�䣺 " + a.Bubble_sort(randoms));// ð��
//		 System.out.println("ѡ������ʱ�䣺 " + a.Selection_sort(randoms));// ѡ��
//		 System.out.println("��������ʱ�䣺 " + a.Binary_sort_tree(randoms));// ����
		 System.out.println("��������ʱ�䣺 " +
		 a.Quick_sort(randoms,0,randoms.length-1));// ����

	}
}
