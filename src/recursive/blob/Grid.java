package recursive.blob;

import java.util.Random;

public class Grid {
	
	private int rows;
	private int cols;
	private boolean[][] grid;
	private boolean[][] visited;
	
	/*
	 * ���� ����: rows && cols > 0
	 * 0 <= percentage <= 100
	 * rows, cols ũ���� ���ڸ� ����. ��ġ�� ����� Ȯ���� ����� ��� ���ڷ� ������
	 */
	public Grid(int rows, int cols, int percentage) {
		this.rows = rows;
		this.cols = cols;
		grid = new boolean [rows][cols];
		
		// ������ ���ڸ� ������.
		int randomNumber;
		Random random = new Random();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				randomNumber = random.nextInt(100);	// ������ ���� 0 ~ 99
				
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
			gridString = gridString + "\n";	// ���� ��
		}
		
		return gridString;
	}
	
	// ���ڿ��� ����� ������ ����
	public int blobCount() {
		int count = 0;
		
		visited = new boolean [rows][cols];
		
		// visited�� �ʱ�ȭ
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}
		
		// blob�� ���
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
	 * �湮�ϸ鼭 row, col ��ġ�� ��ũ
	 * Ȯ���ϰ� �����ϸ� �� ��ġ�� ��, �Ʒ�, ����, ������ ��ġ�� ��ũ
	 */
	private void markBlob(int row, int col) {
		
		visited[row][col] = true;
		
		// �� Ȯ��
		if ((row - 1) >=  0) {					// ���ڿ� �ְ�
			if (grid[row - 1][col]) {			// ��� ���ڸ� ������
				if (!visited[row - 1][col]) {	// �׸��� �湮���� �ʾ�����
					markBlob(row - 1, col);		// ��ũ��
				}
			}
		}
		
		// �Ʒ� Ȯ��
		if ((row + 1) <  rows) {
			if (grid[row + 1][col]) {
				if (!visited[row + 1][col]) {
					markBlob(row + 1, col);
				}
			}
		}
		
		// ���� Ȯ��
		if ((col - 1) >=  0) {
			if (grid[row][col - 1]) {
				if (!visited[row][col - 1]) {
					markBlob(row, col - 1);
				}
			}
		}
		
		// ������ Ȯ��
		if ((col + 1) < cols) {
			if (grid[row][col + 1]) {
				if (!visited[row][col + 1]) {
					markBlob(row, col + 1);
				}
			}
		}
	}
}
