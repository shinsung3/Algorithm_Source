import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int n = 6;
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(Arrays.toString(memo));
		fibo(n);

		System.out.println(memo[n]);
	}

	static int[] memo;

	static void fibo(int x) {
		if (x > 1) {
			for (int i = 2; i <= x; i++) {
				memo[i] = memo[i-2]+memo[i-1];
			}
		}

	}

	private static String src = "3 3\r\n" + "1 2 1\r\n" + "2 3 2\r\n" + "1 3 3";
}