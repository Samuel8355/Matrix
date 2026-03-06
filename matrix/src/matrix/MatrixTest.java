package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {

	@Test
	void testConstructor() {
		Matrix matrix = new Matrix(3,3, new double[] {1,2,3,4,5,6,7,8,9});
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
	}
	

	@Test
	void testScaled() {
		Matrix matrix1 = new Matrix(2,2, new double[] {1,2,3,4});
		assertEquals(matrix1.getRowCount(), 2);
		assertEquals(matrix1.getColumnCount(), 2);
		assertArrayEquals(matrix1.getRows(), new double[][] {{1,2}, {3,4}});
		assertArrayEquals(matrix1.getRowMajor(), new double[] {1,2,3,4});
		assertArrayEquals(matrix1.getColumnMajor(), new double[] {1,3,2,4});
		assertEquals(4, matrix1.getElement(1, 1));
		
		double scalar = 2;
		
		Matrix result = matrix1.scaled(scalar);
		assertEquals(result.getRowCount(), 2);
		assertEquals(result.getColumnCount(), 2);
		assertArrayEquals(result.getRows(), new double[][] {{2,4},{6,8}});
		assertArrayEquals(result.getRowMajor(), new double[] {2,4,6,8});
		assertArrayEquals(result.getColumnMajor(), new double[] {2,6,4,8});
	}
	
	@Test
	void testPlus() {
		Matrix matrix1 = new Matrix(2,2, new double[] {1,2,3,4});
		assertEquals(matrix1.getRowCount(), 2);
		assertEquals(matrix1.getColumnCount(), 2);
		assertArrayEquals(matrix1.getRows(), new double[][] {{1,2}, {3,4}});
		assertArrayEquals(matrix1.getRowMajor(), new double[] {1,2,3,4});
		assertArrayEquals(matrix1.getColumnMajor(), new double[] {1,3,2,4});
		assertEquals(4, matrix1.getElement(1, 1));
		
		Matrix matrix2 = new Matrix(2,2, new double[] {2,3,4,5});
		assertEquals(matrix2.getRowCount(), 2);
		assertEquals(matrix2.getColumnCount(), 2);
		assertArrayEquals(matrix2.getRows(), new double[][] {{2,3},{4,5}});
		assertArrayEquals(matrix2.getRowMajor(), new double[] {2,3,4,5});
		assertArrayEquals(matrix2.getColumnMajor(), new double[] {2,4,3,5});
		assertEquals(2, matrix2.getElement(0, 0));
		
		Matrix result = matrix1.plus(matrix2);
		assertEquals(result.getRowCount(), 2);
		assertEquals(result.getColumnCount(), 2);
		assertArrayEquals(result.getRows(), new double[][] {{3,5},{7,9}});
		assertArrayEquals(result.getRowMajor(), new double[] {3,5,7,9});
		assertArrayEquals(result.getColumnMajor(), new double[] {3,7,5,9});
	}
	
	@Test
	void testRepresentationExposure() {
		
		double[] list1 = new double[] {1,2,3,4,5,6,7,8,9};
		Matrix matrix = new Matrix(3,3, list1);
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
		
		list1[0]= 0;
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
		
		double[][] list2 = matrix.getRows();
		list2[0][0] = 100;
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
		
		double[] list3 = matrix.getColumnMajor();
		list3[0] = 100;
		assertEquals(matrix.getRowCount(), 3);
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
		
		double[] list4 = matrix.getColumnMajor();
		list4[0] = 100;
		assertEquals(matrix.getRowCount(), 3); 
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
		
		double[] list5 = matrix.getRowMajor();
		list4[2] = 100;
		assertEquals(matrix.getRowCount(), 3); 
		assertEquals(matrix.getColumnCount(), 3);
		assertArrayEquals(matrix.getRows(), new double[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		assertArrayEquals(matrix.getRowMajor(), new double[] {1,2,3,4,5,6,7,8,9});
		assertArrayEquals(matrix.getColumnMajor(), new double[] {1,4,7,2,5,8,3,6,9});
		assertEquals(3, matrix.getElement(0, 2));
				
	}

}
