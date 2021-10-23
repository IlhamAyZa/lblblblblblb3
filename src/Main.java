import matrixlab.Matrix;

/* *********** Pledge of Honor ************************************************

*

* I hereby certify that I have completed this lab assignment on my own

* without any help from anyone else. I understand that the only sources of authorized

* information in this lab assignment are (1) the course textbook, (2) the

* materials  posted at the course website and (3) any study notes handwritten by myself.

*

* I have not used, accessed or received any information from any other unauthorized

* source in taking this lab assignment. The effort in the assignment thus belongs

* completely to me.

*

*  READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID

*  SIGNATURE:   <Ilham Aydazada, 0074562>

* 

********************************************************************************/

public class Main {

	// Constants
	private static final int DIM_X = 8;
	private static final int DIM_Y = 8;
	private static final int CONST = 5;

	public static void main(String[] args) {
		var m1 = new Matrix("Matrix 1", DIM_X, DIM_Y);            // Random matrix
		var m2 = new Matrix("Matrix 2", DIM_X, DIM_Y, CONST);    // Matrix filled with CONST
		var m3 = new Matrix("Matrix 3", DIM_X, DIM_Y, 0);    // Matrix filled with 0

		System.out.println(m1.getName() + "\n" + m1 + "\n");
		System.out.println(m2.getName() + "\n" + m2 + "\n");
		System.out.println(m3.getName() + "\n" + m3 + "\n");

		System.out.println("Matrix 1 is " + (m1.isSymmetrical() ? "" : "not ") + "symmetrical");
		System.out.println("Matrix 2 is " + (m2.isSymmetrical() ? "" : "not ") + "symmetrical");
		System.out.println("Matrix 3 is " + (m3.isSymmetrical() ? "" : "not ") + "symmetrical");
		System.out.println("Matrix 3 isZero: " + m3.isZero());

		System.out.println();

		System.out.println("m1 + m2 = \n"              + m1.add(m2)                           + "\n");
		System.out.println("(m1 + m2)T = \n"           + m1.add(m2).transpose()               + "\n");
		System.out.println("(m1 * 10 - m2 * 10)T = \n" + m1.multiply(10).sub(m2.multiply(10)) + "\n");

		System.out.println();
		System.out.println(m3.getName() + " isMajority 0: " + m3.isMajority(0));
	}
}
