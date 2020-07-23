package cr.ac.ulead.grafos;
import java.util.*;

public class Amplitud {

	private final int vertices;
	private int[][] adjacency_matrix;

	Amplitud(int v) {

		vertices = v;
		adjacency_matrix = new int[vertices][vertices];
	}

	void BFS(int s, int[][] grid) {

		boolean visited[][] = new boolean[vertices][vertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s][0] = true;
		queue.add(s);

		while (queue.size() != 0) {

			s = queue.remove();

			System.out.print(s + " ");
			int cont = 0;

			while (cont <= grid[s].length - 1) {
				int n = grid[s][cont];
				if (!visited[s][n] && !visited[n][s]) {
					visited[s][n] = true;
					visited[n][s] = true;
					if (!queue.contains(n) && s != n) {
						adjacency_matrix[s][n] = 1;
						adjacency_matrix[n][s] = 1;
						queue.add(n);
					}

				}
				cont++;
			}

		}

	}

	public static void main(String args[]) {
		int[][] graph = new int[][] { { 1, 3 }, { 0, 3, 2, 4 }, { 1, 4 }, { 0, 1, 4, 5 }, { 1, 2, 3, 5, 6 },
				{ 3, 4, 6 }, { 5, 6 } };
		Amplitud g = new Amplitud(7);

		System.out.println("Recorriendo longitudinalmente desde vertice 2)");
		g.BFS(2, graph);
		System.out.println("\n--------------------------");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(g.adjacency_matrix[i][j]+"  ");
			}
			System.out.println();
		}

	}

}
