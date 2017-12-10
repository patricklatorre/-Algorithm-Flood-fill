public class FloodFill
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
		DFS(4, 4, visited, matrix, 5, 4);
	}

	public static void DFS(int x, int y, boolean[][] visited, int[][] matrix, int n, int m) {
		if(x > n || y > m) {
			System.out.println("GREATER than margin");
			return;
		}
		if(x < 0 || y < 0) {
			System.out.println("LESSER than margin");
			return;
		}
		if(visited[x][y] == true) {
			System.out.println("already visited");
			return;
		}
		else {
			visited[x][y] = true;
			matrix[x][y] = 1;
		}

		for(int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++)
				if( matrix[i][j] == 1 )
					System.out.print("X\t\t");
				else if( matrix[i][j] == 0 )
					System.out.print(".\t\t");

			System.out.println();
		}
		System.out.println("-------------------------------------------------------");
		DFS(x-1, y, visited, matrix, n, m);
		DFS(x, y-1, visited, matrix, n, m);
		DFS(x, y+1, visited, matrix, n, m);
		DFS(x+1, y, visited, matrix, n, m);
	}

}
