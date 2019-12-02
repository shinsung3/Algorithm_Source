import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int unionfind[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int n = sc.nextInt(); // 정점의 수
		int m = sc.nextInt(); // 간선의 수

		unionfind = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			unionfind[i] = i;
		}

		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < m; i++)
			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		Collections.sort(list);

		int ans = 0;

		
		for (int i = 0; i < m; i++) {
			int x = list.get(i).start;
			int y = list.get(i).end;

			if (findRoot(y) != findRoot(x)) {
				unionfind[findRoot(y)] = unionfind[x];
				ans += list.get(i).weight;
			}
		}
		System.out.println(ans);
	}

	static int findRoot(int x) {
		if (x != unionfind[x]) {
			return unionfind[x] = findRoot(unionfind[x]);
		}else
			return x;
	}

	static class Node implements Comparable<Node> {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	private static String src = "6  8\r\n" + "1  2  7\r\n" + "1  3  3\r\n" + "2  4  10\r\n" + "3  4  1\r\n"
			+ "3  5  6\r\n" + "3  6  10\r\n" + "4  5  13\r\n" + "5  6  4";
}