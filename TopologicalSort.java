import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nv = sc.nextInt();
        int ne = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(nv);

        for (int i = 0; i < nv; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 0; i < ne; i++) {
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            adj.get(firstVertex).add(secondVertex);
            // adj.get(secondVertex).add(firstVertex);
        }
        sc.close();

        int[] tsort = topologicalSort(nv, adj);
        for (int i : tsort) {
            System.out.print(i + " ");
        }
    }

    private static int[] topologicalSort(int nv, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[nv];
        for (ArrayList<Integer> list : adj) {
            for (Integer i : list) {
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nv; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for (int neighbour : adj.get(cur)) {
                inDegree[neighbour]--;

                if (inDegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        int[] topoSort = new int[ans.size()];
        int i = 0;
        for (int e : ans) {
            topoSort[i++] = e;
        }

        return topoSort;
    }
}
