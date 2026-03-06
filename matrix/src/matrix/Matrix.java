package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van Matrix stelt een matrix van getallen voor.
 * @immutable 
 */
public class Matrix {
	
	/**
	 * @representationObject
	 * @invar
	 * | columnCount * rowCount == rowMajor.length
	 */
	double[] rowMajor;
	int columnCount;
	int rowCount;
	
	/**
	 * @pre | elements != null
	 * @pre | rowCount >= 0 && columnCount >=0
	 * @pre | rowCount*columnCount == elements.length
	 * @post | getRowCount() == rowCount
	 * @post | getColumnCount() == columnCount
	 * @post | Arrays.equals(getRowMajor(), elements)
	 */
	Matrix(int rowCount, int columnCount, double[] elements){
		rowMajor = elements.clone();
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}
	

	public int getRowCount() {
		return rowCount;
	}
	
	public int getColumnCount() {
		return columnCount;
	}
	
	/**
	 * @pre | rowIndex >= 0 && rowIndex < getRowCount()
	 * @pre | columnIndex >= 0 && columnIndex < getColumnCount()
	 * @creates | result
	 * @post | result == getRows()[rowIndex][columnIndex]
	 */
	public double getElement(int rowIndex, int columnIndex) {
		return getRows()[rowIndex][columnIndex];
	}
	
	/**
	 * @creates | result
	 */
	public double[] getRowMajor() {
		return rowMajor.clone();
	}
	
	/**
	 * @creates | result
	 * @post
	 * | IntStream.range(0, getRowCount()).allMatch(i -> IntStream.range(0,getColumnCount()).allMatch(j -> getRows()[i][j]==result[(j)*getRowCount()+i]))
	 */
	public double[] getColumnMajor() {
		double[] result = new double[rowMajor.length];
		for (int i=0; i<rowCount; i++) {
			for (int j=0;j<columnCount;j++) {
				result[j*rowCount+i] = rowMajor[i*columnCount+j];
			}
		}
		return result;
	}
	
	/**
	 * @creates | result
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> IntStream.range(0,getColumnCount()).allMatch(j -> result[i][j]==getRowMajor()[(i)*getColumnCount()+j]))
	 * @post | result.length == getRowCount() && result[0].length == getColumnCount()
	 */
	public double[][] getRows() {
		double[][] result = new double [rowCount][columnCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0;j<columnCount;j++) {
				result[i][j] = rowMajor[i*columnCount+j];
			}
		}
		return result;
	}
	
	
	/**
	 * @creates | result
	 * @inspects | this
	 * @post | Arrays.equals(getRowMajor(), old(getRowMajor()))
	 * @post | getRowCount() == old(getRowCount()) && getColumnCount() == old(getColumnCount())
	 * @post | result.getRowMajor().length == getRowMajor().length
	 * @post | IntStream.range(0, getRowMajor().length).allMatch(i -> result.getRowMajor()[i] == scalar*getRowMajor()[i])
	 */
	
	public Matrix scaled(double scalar) {
		double[] newRowMajor = rowMajor.clone();
		for (int i=0;i<rowMajor.length;i++) {
			newRowMajor[i] = newRowMajor[i]*scalar;
		}
		Matrix result = new Matrix(rowCount, columnCount, newRowMajor);
		return result;
	}
	
	/**
	 * @creates | result
	 * @inspects | this, matrix
	 * @post | Arrays.equals(getRowMajor(), old(getRowMajor()))
	 * @post | getRowCount() == old(getRowCount()) && getColumnCount() == old(getColumnCount())
	 * @post | result.getRowMajor().length == getRowMajor().length
	 * @post | IntStream.range(0, getRowMajor().length).allMatch(i -> result.getRowMajor()[i] == matrix.getRowMajor()[i]+ getRowMajor()[i])
	 */
	public Matrix plus(Matrix matrix) {
		double[] newRowMajor = new double[rowMajor.length];
		for (int i = 0;i<rowMajor.length;i++) {
			newRowMajor[i] = rowMajor[i] + matrix.getRowMajor()[i];
		}
		return new Matrix(rowCount, columnCount, newRowMajor);
}
	
}
