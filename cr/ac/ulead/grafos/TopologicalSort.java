package cr.ac.ulead.grafos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	private int V;
	private LinkedList<Integer> adj[][];

	TopologicalSort(int v) {
		V = v;
		adj = new LinkedList[v][v];
		for (int i = 0; i < v; ++i)
			adj[i][i] = new LinkedList();
	}

	void topologicalSortUtil(int v, boolean visited[][], Stack stack) {
		visited[v][0] = true;
		visited[0][v] = true;
		Integer i;

		Iterator<Integer> it = adj[v][v].iterator();
		int s = 0;
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i][s] && !visited[i][s])
				topologicalSortUtil(i, visited, stack);
			// if (!stack.contains(i) && v != i) {
			// LinkedList ll = new LinkedList(Arrays.asList(adj));
			// adj[i][s] = 1;
			// adj[s][i] = 1;
			// }
		}

		stack.push(new Integer(v));
	}

	void topologicalSort() {
		Stack stack = new Stack();
		int cont = 0;

		boolean visited[][] = new boolean[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (visited[i][j] == false)
					topologicalSortUtil(i, visited, stack);

				while (stack.empty() == false) {
					System.out.print(stack.pop() + " ");
					for (int i1 = 0; i1 < adj.length; i1++) {
						for (int j1 = 0; j1 < adj.length; j1++) {
							System.out.print(adj[i1][j1] + " ");
						}
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		int[][] graph = new int[][] { { 1, 3 }, { 0, 3, 2, 4 }, { 1, 4 }, { 0, 1, 4, 5 }, { 1, 2, 3, 5, 6 },
				{ 3, 4, 6 }, { 5, 6 } };
		TopologicalSort g = new TopologicalSort(7);
		System.out.println("Ordenamiento topologico del grafo: ");
		g.topologicalSort();
	}

}
