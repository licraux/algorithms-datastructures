import java.util.*;

public class HarmonyConflict {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //number of vertices
        int m = sc.nextInt(); //number of edges
        List<List<Edge>> adjacencyList = new ArrayList<>(); //adjacency list of vertices
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>()); //create a list of adjacent vertices for some vertex
        }
        for (int i = 0; i < m; i++) { // input to populate the adjacency list of vertices and also add the type of edge c that links them
            int u = sc.nextInt(); //vertex u
            int v = sc.nextInt(); //vertex v 
            int c = sc.nextInt(); //edge type
            adjacencyList.get(u).add(new Edge(v, c));
            adjacencyList.get(v).add(new Edge(u, c));
        }
        sc.close();
        boolean result = canBe2Colored(adjacencyList); 
        System.out.println(result ? "1" : "0");
    }

    public static boolean canBe2Colored(List<List<Edge>> adjacencyList) {
        int n = adjacencyList.size();
        int[] edgeTypes = new int[n];
        Arrays.fill(edgeTypes, -1); //-1 means that edges have no types at the beginning
        for (int i = 0; i < n; i++) {
            if (edgeTypes[i] == -1) {
                if (!dfs(adjacencyList, edgeTypes, i, 0)) { //set the edge type = 0 by default if -1 
                    return false; //can't be harmoniously 2-colored
                }
            }
        }
        return true; //can be harmoniously 2-colored if everything checks out
    }

    private static boolean dfs(List<List<Edge>> adjacencyList, int[] edgeTypes, int start, int edgeType) { //dfs algorithm to determine outcome
        Stack<Integer> stack = new Stack<>(); //new stack to recursively iterate over the tree of vertices
        stack.push(start);
        edgeTypes[start] = edgeType; //update edgeTypes array to default value 0 at index position of vertex = start = i
        while (!stack.isEmpty()) {
            int u = stack.pop(); //pop vertex at the top of the stack
            for (Edge edge : adjacencyList.get(u)) { //get all the edges and its adjacent vertices for vertex u
                int v = edge.to; //edge at the other end
                int c = edge.edgeType; //type of edge - either harmonious or conflicted edge - can also be thought with colors (blue and red e.g.)
                if (c == 1) { //if conflicted
                    if (edgeTypes[v] == -1) { //if the vertex at the other end hasn't been assigned a type of edge
                        edgeTypes[v] = 1 - edgeTypes[u]; //assignt it the opposite // blue and red for instance
                        stack.push(v);
                    } else if (edgeTypes[v] == edgeTypes[u]) { //if they have the same edge type and its a conflicted edge that links them, return false
                        return false;
                    }
                } else { //same logic but reversed for harmony edges
                    if (edgeTypes[v] == -1) { 
                        edgeTypes[v] = edgeTypes[u];
                        stack.push(v);
                    } else if (edgeTypes[v] != edgeTypes[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Edge { //class edge to account for the vertex that is at the other end and the edge type
        int to;
        int edgeType;

        public Edge(int to, int edgeType) {
            this.to = to;
            this.edgeType = edgeType;
        }
    }

}
