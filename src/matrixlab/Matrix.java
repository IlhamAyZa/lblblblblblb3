package matrixlab;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Matrix {
	// TODO: Fields

	private int[][] matrix;
	private String name;

	public Matrix(String name, int x, int y) {
		// TODO: define 2D array
		this.name = name;
		matrix = new int[x][y];
		// TODO: initialize with random numbers
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = randElem();
			}
		}
	}

	public Matrix(String name, int x, int y, int c) {
		// TODO: define 2D array
		this.name = name;
		matrix = new int[x][y];
		// TODO: initialize with constant c
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = c;
			}
		}
	}

	private Matrix(String name, int[][] m) {
		this.matrix = new int[m.length][m[0].length];

		// Deep copy
		for (int i = 0; i < m.length; i++) {
			for (int ii = 0; ii < m[i].length; ii++) {
				this.matrix[i][ii] = m[i][ii];
			}
		}
	}

	public Matrix add(Matrix m) {
		// TODO: Check if same dimensions, show a warning otherwise
		
//		try {
//			if (this.matrix.length == m.getMatrix().length) {
//				for (int i = 0; i < this.matrix.length; i++) {
//					if (this.matrix[i].length != m.getMatrix()[i].length) {
//							
//					}
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		if (this.matrix.length == m.getMatrix().length) {
			for (int i = 0; i < this.matrix.length; i++) {
				if (this.matrix[i].length != m.getMatrix()[i].length) {
					System.out.println("Warning!");
				}
			}
		}

		var copy = new Matrix(this.name + " copy", this.matrix);

		// TODO: Perform addition on this.matrix and m, and save it to copy

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				copy.getMatrix()[i][j] = this.matrix[i][j] + m.getMatrix()[i][j];
			}
		}

		return copy;
	}

	public Matrix sub(Matrix m) {
		// TODO: Check if same dimensions, show a warning otherwise

		if (this.matrix.length == m.getMatrix().length) {
			for (int i = 0; i < this.matrix.length; i++) {
				if (this.matrix[i].length != m.getMatrix()[i].length) {
					System.out.println("Warning!");
				}
			}
		}

		Matrix copy = new Matrix(this.name + " copy", this.matrix);

		// TODO: Perform subtraction on this.matrix and m, and save it to copy

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				copy.getMatrix()[i][j] = this.matrix[i][j] - m.getMatrix()[i][j];
			}
		}

		return copy;
	}

	public Matrix multiply(int c) {
		Matrix copy = new Matrix(this.name + " copy", this.matrix);

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				copy.matrix[i][j] = this.matrix[i][j] * c;
			}
		}

		// TODO: Multiply this.matrix by constant c and save it to copy

		return copy;
	}

	public Matrix transpose() {
		// TODO: Uncomment and fill out missing parts
		Matrix copy = new Matrix(this.name + " copy", this.matrix[0].length, this.matrix.length);

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				copy.matrix[j][i] = this.matrix[i][j];
			}
		}

		// TODO: Transpose this.matrix and save it to copy

		return copy;
	}

	public boolean isSymmetrical() {
		// TODO: Find out if transpose of the matrix is equal to itself

		Matrix copy = new Matrix(this.name + " copy", transpose().matrix);
		int eq = 0;

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				if (copy.matrix[i][j] == this.matrix[i][j]) {
					eq++;
				}
			}
		}

		if (eq == (this.matrix.length * this.matrix.length)) {
			return true;
		}
		return false;
	}

	public boolean isZero() {
		// TODO: Find out if all elements are 0
		int eq = 0;

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				if (this.matrix[i][j] == 0) {
					eq++;
				}
			}
		}

		return eq == (this.matrix.length * this.matrix.length);
	}

	public boolean isMajority(int value) {
		// TODO: find out if the majority of the elements in the matrix are equal to
		// value

		int eq = 0;

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[i].length; j++) {
				if (this.matrix[i][j] == 0) {
					eq++;
				}
			}
		}

		if (eq > (int) (this.matrix.length * this.matrix.length / 2)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return Arrays.deepToString(this.matrix).replace("], ", "]\n");
	}

	private static final SecureRandom rand = new SecureRandom();

	private static int randElem() {
		return rand.nextInt(101);
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// IN-LAB
	public void equalTranspose() {

		int tempInt;

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix.length; j++) {
				tempInt = this.matrix[i][j];
				this.matrix[i][j] = this.matrix[j][i];
				this.matrix[j][i] = tempInt;
			}
		}
	}

	public int trace() {
		int trace = 0;

		for (int i = 0; i < this.matrix.length; i++) {
			trace += this.matrix[i][i];
		}

		return trace;
	}

	public ArrayList<Integer> flatten() {
		ArrayList<Integer> listOfInts = new ArrayList<>();

		for (int[] i : this.matrix) {
			for (int j : i) {
				listOfInts.add(j);
			}
		}
		return listOfInts;
	}

	public ArrayList<Integer> multiply(ArrayList<Integer> v) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		
		if (this.matrix.length != v.size()) {
			System.out.println("Warning");
		}

		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix.length; j++) {
				arrayList.add(matrix[i][j] * v.get(j));
			}
		}

		return arrayList;
	}
}