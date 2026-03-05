package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void testConstructor() {
		Matrix matrix = new Matrix(3,3, new double[] {1,2,3,4,5,6,7,8,9});
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertEquals(matrix.getColumnMajor(), new double[][] {{1,4,7},{2,5,8},{3,6,9}});
		assertEquals(3, matrix.getElement(0, 2));
	}
	

	@Test
	void testScaled() {
	}
	
	@Test
	void testPlus() {
		fail("Not yet implemented");
	}
	
	@Test
	void testRepresentationExposure() {
		fail("Not yet implemented");
	}
	

}
