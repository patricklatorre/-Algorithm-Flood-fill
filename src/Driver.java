public class Driver
{
	public static void main(String[] args) {
		int[][] matrix = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
		};

		boolean[][] visited = {
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
		};

		DFS(0, 0, visited, matrix, 4, 5);
	}

	public static void DFS(int x, int y, boolean[][] visited, int[][] matrix, int n, int m) {
		if(x >= n || y >= m)
			return;
		if(x < 0 || y < 0)
			return;
		if(visited[x][y] == true)
			return;
		else {
			visited[x][y] = true;
			matrix[x][y] = 2;
		}

		for(int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++)
				System.out.print("[" +matrix[j][i]+ "]\t\t");
			System.out.println();
		}
		System.out.println("-------------------------------------------------------");
		DFS(x-1, y, visited, matrix, n, m);
		DFS(x, y-1, visited, matrix, n, m);
		DFS(x, y+1, visited, matrix, n, m);
		DFS(x+1, y, visited, matrix, n, m);
	}

}
