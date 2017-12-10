import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AStarBonus
{
	private static List<Cell> foundPath = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] source = new int[2];
		System.out.print("Source XY coordinates: ");
		source[0] = sc.nextInt();
		source[1] = sc.nextInt();
		System.out.println("-------------------------------------------------------");

		int[] dest = new int[2];
		System.out.print("Destination XY coordinates: ");
		dest[0] = sc.nextInt();
		dest[1] = sc.nextInt();
		System.out.println("-------------------------------------------------------");

		int[][] matrix = {
				{0, 2, 0, 2, 0},
				{0, 2, 0, 0, 0},
				{0, 0, 2, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
		};

		boolean found = DFS(source[1], source[0], matrix, 4, 5, dest[1], dest[0]);
		if( !found )
			System.out.println("Destination is not accessible.");
		else {
			System.out.println("\n\n[PATH]");
			printPath();
		}
	}

	public static boolean DFS(int y, int x, int[][] matrix, int n, int m, int dy, int dx) {
		if(y > m || x > n) {
			return false;
		}
		if(y < 0 || x < 0) {
			return false;
		}
		if( y == dy && x == dx ) {
			foundPath.add(new Cell(y, x, dy, dx));
			for(int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == dy && j == dx)
						System.out.print("E\t");
					else if (matrix[i][j] == 1)
						System.out.print("P\t");
					else if (matrix[i][j] == 2)
						System.out.print("*\t");
					else if (matrix[i][j] == 0)
						System.out.print(".\t");
				}
				System.out.println();
			}
			return true;
		}
		if( matrix[y][x] == 2 || matrix[y][x] == 1 ) {
			return false;
		}

		if( matrix[y][x] == 0 ) {
			matrix[y][x] = 1;

			/* PRINT current state */
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == dy && j == dx)
						System.out.print("E\t");
					else if (matrix[i][j] == 1)
						System.out.print("P\t");
					else if (matrix[i][j] == 2)
						System.out.print("*\t");
					else if (matrix[i][j] == 0)
						System.out.print(".\t");
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------------------");

			Cell[] pathQueue = new Cell[4];
			pathQueue[0] = new Cell(y - 1, x, dy, dx);
			pathQueue[1] = new Cell(y, x - 1, dy, dx);
			pathQueue[2] = new Cell(y, x + 1, dy, dx);
			pathQueue[3] = new Cell(y + 1, x, dy, dx);
			sortByDistance(pathQueue);

			boolean found = false;
			for (Cell nextPath : pathQueue) {
				found = DFS(nextPath.getY(), nextPath.getX(), matrix, n, m, dy, dx);
				if( found ) {
					foundPath.add(new Cell(y, x, dy, dx));
					return true;
				}
			}
			if( !found ) {
				matrix[y][x] = 0;
				return false;
			}
		}
		return false;
	}

	static void sortByDistance(Cell[] arr) {
		int n = arr.length;
		Cell temp = null;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1].getDistance() > arr[j].getDistance()) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}

	static void printPath() {
		for(int i = foundPath.size()-1; i >= 0; i--) {
			System.out.println("(" +foundPath.get(i).getX()+ ", " +foundPath.get(i).getY()+ ")");
		}
	}
}
