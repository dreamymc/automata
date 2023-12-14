import java.util.*;

public class TravelingSalesmanProblem {
    int[][] graph;
    int V;
    int shortestPath;
    int longestPath;
    List<String> allPaths = new ArrayList<>();

    public void tsp(int[] vertices, int n, int idx, int currentPath) {
        if (idx == n) {
            shortestPath = Math.min(shortestPath, currentPath + graph[vertices[n - 1]][0]);
            longestPath = Math.max(longestPath, currentPath + graph[vertices[n - 1]][0]);
            allPaths.add(Arrays.toString(vertices));
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(vertices, i, idx);
            tsp(vertices, n, idx + 1, currentPath + graph[vertices[idx - 1]][vertices[idx]]);
            swap(vertices, i, idx);
        }
    }

    public void swap(int[] vertices, int i, int j) {
        int temp = vertices[i];
        vertices[i] = vertices[j];
        vertices[j] = temp;
    }

    public String checkPath(String path) {
        if (allPaths.contains(path)) {
            if (path.equals(allPaths.get(0))) {
                return "Shortest Path";
            } else if (path.equals(allPaths.get(allPaths.size() - 1))) {
                return "Longest Path";
            } else {
                return "Average Path";
            }
        } else {
            return "Path not found";
        }
    }

    public void run() {
        // Initialize graph
        V = 4;
        graph = new int[][]{{0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0}};
        shortestPath = Integer.MAX_VALUE;
        longestPath = Integer.MIN_VALUE;

        int[] vertices = new int[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = i;
        }

        tsp(vertices, V, 1, 0);
        System.out.println("All possible paths:");
        for (String s : allPaths) {
            System.out.println(s);
        }
        Scanner jean = new Scanner(System.in);
        System.out.print("Enter a path:");
        String inputPath = jean.next();
        System.out.println(checkPath(inputPath));
        jean.close();
    }
}
