import java.util.Scanner;
import edu.princeton.cs.algs4.Stack;

public class DS2 {

    private int[] parent;
    private int[] rank;

    DS2(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connected(int s, int t) {
        return find(s) == find(t);
    }

    public void union(int s, int t) {
        int root1 = find(s);
        int root2 = find(t);
        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } 
            else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } 
            else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        DS2 uf = new DS2(n);

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            String q = line[0];
            int s = Integer.parseInt(line[1]);
            int t = Integer.parseInt(line[2]);

            if ("1".equals(q)) {
                uf.union(s, t);
            } 
            else {
                System.out.println(uf.connected(s, t) ? "1" : "0");
            }
        }
    }
}