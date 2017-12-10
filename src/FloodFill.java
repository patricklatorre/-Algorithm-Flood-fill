import java.util.Scanner;

public class FloodFill
{
	static int filledCells = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] source = new int[2];
		System.out.print("Source XY coordinates: ");
		source[0] = sc.nextInt();
		source[1] = sc.nextInt();
		System.out.println("-------------------------------------------------------");

		int[][] matrix = {
				{0, 0, 0, 2, 0},
				{0, 0, 0, 2, 0},
				{0, 0, 0, 2, 0},
				{0, 2, 2, 2, 0},
				{2, 0, 0, 0, 0},
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
		DFS(source[1], source[0], visited, matrix, 4, 5);

		System.out.println("Filled cells: " + filledCells);
	}

	public static void DFS(int y, int x, boolean[][] visited, int[][] matrix, int n, int m) {
		if(y > m || x > n) {
			System.out.println("[ GREATER than margin ]");
			return;
		}
		if(y < 0 || x < 0) {
			System.out.println("[ LESSER than margin ]");
			return;
		}
		if( matrix[y][x] == 2 ) {
			return;
		}
		if(visited[y][x]) {
			System.out.println("[ already visited ]");
			return;
		}
		else {
			visited[y][x] = true;
			matrix[y][x] = 1;
			filledCells++;
		}

		for(int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++)
				if( matrix[i][j] == 1 )
					System.out.print("X\t\t");
				else if( matrix[i][j] == 2)
					System.out.print("*\t\t");
				else if( matrix[i][j] == 0 )
					System.out.print(".\t\t");

			System.out.println();
		}
		System.out.println("-------------------------------------------------------");
		DFS(y-1, x, visited, matrix, n, m);
		DFS(y, x-1, visited, matrix, n, m);
		DFS(y, x+1, visited, matrix, n, m);
		DFS(y+1, x, visited, matrix, n, m);
	}

}
