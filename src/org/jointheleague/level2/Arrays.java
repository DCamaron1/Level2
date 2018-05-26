package org.jointheleague.level2;

public class Arrays {
	public static void main(String[] args) {
		/*
		 * String[] names = new String[3]; names[2] = "David"; names[0] = "Esme";
		 * names[1] = "Isis"; for (int i = 0; i < names.length; i++) { //
		 * System.out.println(names[i]); }
		 * 
		 * int[] numbers = new int[3]; numbers[2]= 3; numbers[1] = 2; numbers[0] = 1;
		 * for (int i = numbers.length-1; i >= 0; i=i-1) {
		 * System.out.println(numbers[i]); }
		 */

		int[] row1 = new int[3];
		row1[0] = 42;
		row1[1] = 21;
		row1[2] = 7;

		int[] row2 = new int[4];
		row2[0] = 1;
		row2[1] = 2;
		row2[2] = 3;
		row2[3] = 4;

		int[] row3 = new int[3];
		row3[0] = 2;
		row3[1] = 4;
		row3[2] = 20;

		int[][] grid = new int[3][];
		grid[0] = row1;
		grid[1] = row2;
		grid[2] = row3;

		System.out.println(grid[0][2]);
		System.out.println(grid[1][1]);
		System.out.println(grid[2][0]);

		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				System.out.println(grid[row][column]);
			}
		}
	}
}
