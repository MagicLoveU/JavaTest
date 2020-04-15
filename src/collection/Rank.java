package collection;

public class Rank {

	// 初始化数组，40000个随机数
	public int[] Init() {

		int randoms[] = new int[40000];

		for (int i = 0; i < 40000; i++) {
			randoms[i] = (int) (Math.random() * 100 * 1000);
		}

		return randoms;
	}

	// 冒泡排序
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

	// 选择排序
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

	// 二叉排序树
	public long Binary_sort_tree(int[] randoms) {

		long a = System.currentTimeMillis();
		Node roots = new Node();

		for (int number : randoms) {
			roots.add(number);
		}

		long b = System.currentTimeMillis();
		return b - a;
	}

	// 快速排序
	public static void Quick_sort_recursive(int[] randoms, int low, int high) {
		int i, j, temp, t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		// temp就是基准位
		temp = randoms[low];

		while (i < j) {
			// 先看右边，依次往左递减
			while (temp <= randoms[j] && i < j) {
				j--;
			}
			// 再看左边，依次往右递增
			while (temp >= randoms[i] && i < j) {
				i++;
			}
			// 如果满足条件则交换
			if (i < j) {
				t = randoms[j];
				randoms[j] = randoms[i];
				randoms[i] = t;
			}

		}
		// 最后将基准为与i和j相等位置的数字交换
		randoms[low] = randoms[i];
		randoms[i] = temp;

		// 递归调用左半数组
		Quick_sort_recursive(randoms, low, j - 1);
		// 递归调用右半数组
		Quick_sort_recursive(randoms, j + 1, high);
	}

	// 快速排序时间
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

//		 System.out.println("冒泡排序时间： " + a.Bubble_sort(randoms));// 冒泡
//		 System.out.println("选择排序时间： " + a.Selection_sort(randoms));// 选择
//		 System.out.println("二叉排序时间： " + a.Binary_sort_tree(randoms));// 二叉
		 System.out.println("快速排序时间： " +
		 a.Quick_sort(randoms,0,randoms.length-1));// 快排

	}
}
