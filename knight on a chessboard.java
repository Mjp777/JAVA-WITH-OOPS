import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	static int chessboardSide;
	static int[][] results;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		chessboardSide = scanner.nextInt();
		scanner.close();

		getAllPaths_minimumNumberOfMoves();
	}

	/**
	 * The method gets each path with minimum moves, for each possible size of 
	 * the L-shaped move, from chess board position (1,1) to position (n, n),
	 * n=chessboardSide.
	 * 
	 * In order to avoid a second breadth first search for L-shapes with
	 * interchanged length of the vertical and horizontal legs (for instance,
	 * L-shape (2, 3) and L-shape (3, 2)), the outcomes of the search are stored in
	 * matrix "results".
	 * 
	 * Thus, whenever the current row is greater than the current column,
	 * results[row][column] = results[column][row]. Otherwise, breadth first search
	 * is initiated.
	 * 
	 * The search results are printed as the iteration goes through every possible
	 * size of the L-shape.
	 */
	private static void getAllPaths_minimumNumberOfMoves() {

		results = new int[chessboardSide][chessboardSide];

		for (int row = 1; row < chessboardSide; row++) {
			for (int column = 1; column < chessboardSide; column++) {

				if (row > column) {
					results[row][column] = results[column][row];
				} else {
					results[row][column] = searchPath_minimumNumberOfMoves(row, column);
				}
				System.out.print(results[row][column] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * The method applies Breadth First Search in order to find the path with
	 * minimum number of moves from chess board position (1,1) to position (n, n),
	 * n=chessboardSide. Each move has to be L-shaped, in accordance to the current
	 * vertical and horizontal legs.
	 * 
	 * @return An integer, representing the minimum number of moves. If the position
	 *         can not be reached with the current L-shaped moves, it returns "-1".
	 */
	private static int searchPath_minimumNumberOfMoves(int legOne, int legTwo) {
		LinkedList<Position> chessboardPositions = new LinkedList<Position>();
		Position current = new Position(0, 0);
		chessboardPositions.add(current);

		boolean[][] visited = new boolean[chessboardSide][chessboardSide];
		visited[0][0] = true;
		int row;
		int column;

		while (!chessboardPositions.isEmpty()) {
			current = chessboardPositions.removeFirst();

			if (current.row == chessboardSide - 1 && current.column == chessboardSide - 1) {
				return current.movesFromStart;
			}

			/**
			 * Move: legOne to the right, legTwo down.
			 */
			row = current.row + legOne;
			column = current.column + legTwo;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legOne to the left, legTwo up.
			 */
			row = current.row - legOne;
			column = current.column - legTwo;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legOne to the right, legTwo up.
			 */
			row = current.row + legOne;
			column = current.column - legTwo;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legOne to the left, legTwo down.
			 */
			row = current.row - legOne;
			column = current.column + legTwo;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * If legOne = legTwo, it does not matter whether legOne or legTwo is moved
			 * first. Thus, the following four moves arrive at the same positions as 
			 * the preceding four.
			 * 
			 * However, implementing one more if-statement for legOne = legTwo in order to
			 * avoid the following four if-statements will not streamline the code.
			 * 
			 * This is because the diagonal grows linearly and is equal to chessboardSide.
			 * On the other hand, the cases when legOne != legTwo (and for which breadth
			 * first search is initiated) grow exponentially and are equal to total
			 * positions on the chess board minus the length of the diagonal. And the result
			 * of this, is in turn divided by 2, since breadth first search is not initiated
			 * when current row is greater than the current column. Thus:
			 * (chessboardSide*chessboardSide-chessboardSide)/2.
			 */

			/**
			 * Move: legTwo to the right, legOne down.
			 */
			row = current.row + legTwo;
			column = current.column + legOne;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legTwo to the left, legOne up.
			 */
			row = current.row - legTwo;
			column = current.column - legOne;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legTwo to the right, legOne up.
			 */
			row = current.row + legTwo;
			column = current.column - legOne;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}

			/**
			 * Move: legTwo to the left, legOne down.
			 */
			row = current.row - legTwo;
			column = current.column + legOne;
			if (isOnChessboard(row, column) && !visited[row][column]) {
				Position next = new Position(row, column);
				chessboardPositions.add(next);
				next.movesFromStart = current.movesFromStart + 1;
				visited[row][column] = true;
			}
		}
		return -1;
	}

	/**
	 * The method checks whether the neighboring row and column are within the
	 * boundaries of the chess board.
	 * 
	 * @return true, if they are within the boundaries. Otherwise, returns false.
	 */
	private static boolean isOnChessboard(int row, int column) {
		if (row < 0 || row >= chessboardSide || column < 0 || column >= chessboardSide) {
			return false;
		}
		return true;
	}
}

/**
 * Class "Position" stores the coordinates of a point on the chess board and 
 * the number of moves from the start to reach this point.
 */
class Position {
	int row;
	int column;
	int movesFromStart;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
