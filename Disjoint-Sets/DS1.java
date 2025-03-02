import java.util.Scanner;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DS1 {

    List<Set<Integer>> L;

    DS1(int n) {

        L = new LinkedList<Set<Integer>>();
        for (int i = 0; i < n; i++){
            Set<Integer> S = new HashSet<>();
            S.add(i);
            L.add(S);
        }
    }

    public boolean connected(int s, int t) { //isSameSet? isConnected? sameNumber?
        for (Set<Integer> C: L) {
            if (C.contains(s) && C.contains(t)){
                return true;
            }
        }
        return false;
    }

    public void union(int s, int t){
        Set<Integer> S = null, T = null;
        for (Set<Integer> C : L) {
            if (C.contains(s)){
                S = C;
            }
            if (C.contains(t)){
                T = C;
            }
        }
        if (S != T) {
            S.addAll(T);
            L.remove(T);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        DS1 uf = new DS1(n);

        
        for (int i = 0; i < m; i++) {
            String [] line = sc.nextLine().split(" ");
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