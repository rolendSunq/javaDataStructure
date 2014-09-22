package recursive.blob;

import java.util.Random;

public class Grid {
	
	private int rows;
	private int cols;
	private boolean[][] grid;
	private boolean[][] visited;
	
	/*
	 * 사전 조건: rows && cols > 0
	 * 0 <= percentage <= 100
	 * rows, cols 크기의 격자를 생성. 위치는 백분율 확률에 기반한 블롭 문자로 지정됨
	 */
	public Grid(int rows, int cols, int percentage) {
		this.rows = rows;
		this.cols = cols;
		grid = new boolean [rows][cols];
		
		// 임의의 숫자를 생성함.
		int randomNumber;
		Random random = new Random();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				randomNumber = random.nextInt(100);	// 임의의 숫자 0 ~ 99
				
				if (randomNumber < percentage) {
					grid[i][j] = true;
				} else {
					grid[i][j] = false;
				}
			}
		}
	}
	
	public String toString() {
		String gridString = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j]) {
					gridString = gridString + "X";
				} else {
					gridString = gridString+ "-";
				}
			}
			gridString = gridString + "\n";	// 행의 끝
		}
		
		return gridString;
	}
	
	// 격자에서 블롭의 개수를 리턴
	public int blobCount() {
		int count = 0;
		
		visited = new boolean [rows][cols];
		
		// visited를 초기화
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}
		
		// blob을 계산
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] && !visited[i][j]) {
					count++;
					markBlob(i, j);
				}
			}
		}
		return count;
	}

	/*
	 * 방문하면서 row, col 위치를 마크
	 * 확인하고 적절하면 그 위치의 위, 아래, 왼쪽, 오른쪽 위치를 마크
	 */
	private void markBlob(int row, int col) {
		
		visited[row][col] = true;
		
		// 위 확인
		if ((row - 1) >=  0) {					// 격자에 있고
			if (grid[row - 1][col]) {			// 블롭 문자를 가지면
				if (!visited[row - 1][col]) {	// 그리고 방문되지 않았으면
					markBlob(row - 1, col);		// 마크함
				}
			}
		}
		
		// 아래 확인
		if ((row + 1) <  rows) {
			if (grid[row + 1][col]) {
				if (!visited[row + 1][col]) {
					markBlob(row + 1, col);
				}
			}
		}
		
		// 왼쪽 확인
		if ((col - 1) >=  0) {
			if (grid[row][col - 1]) {
				if (!visited[row][col - 1]) {
					markBlob(row, col - 1);
				}
			}
		}
		
		// 오른쪽 확인
		if ((col + 1) < cols) {
			if (grid[row][col + 1]) {
				if (!visited[row][col + 1]) {
					markBlob(row, col + 1);
				}
			}
		}
	}
}
