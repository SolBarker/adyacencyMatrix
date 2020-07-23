package cr.ac.ulead.grafos;

import java.util.*;

public class Profundidad {

	private final int vertices;
	private int[][] adjacency_matrix;

	Profundidad(int v) {
		vertices = v;
		adjacency_matrix = new int[vertices][vertices];
	}

	void DFSUtil(int n2, boolean[][] visited) {
		visited[n2][0] = true;
		visited[0][n2] = true;
		System.out.print(n2 + " ");
		
		int cont = 0;
		ListIterator<int[]> i = Arrays.asList(adjacency_matrix).listIterator(adjacency_matrix.length);
		while (i.hasNext()) {
			boolean bool = true;
			bool = i.hasNext();
			int val = (bool) ? 1 : 0;

			if (!visited[val][cont] && !visited[cont][val]) {
				DFSUtil(val, visited);
				adjacency_matrix[val][cont] = 1;
				adjacency_matrix[cont][val] = 1;
			}
		}
		cont++;

	}

	void DFS(int v, int[][] graph) {
		boolean[][] visited = new boolean[vertices][vertices];
		DFSUtil(v, visited);
	}

	public static void main(String args[]) {
		int[][] graph = new int[][] { { 1, 3 }, { 0, 3, 2, 4 }, { 1, 4 }, { 0, 1, 4, 5 }, { 1, 2, 3, 5, 6 },
				{ 3, 4, 6 }, { 5, 6 } };
		Profundidad g = new Profundidad(7);
		System.out.println("Recorriendo en profunidad desde el vertice 2");
		g.DFS(2, graph);

		System.out.println("\n--------------------------");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(g.adjacency_matrix[i][j] + "  ");
			}
			System.out.println();
		}

	}

}
