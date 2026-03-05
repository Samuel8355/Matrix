package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van Matrix stelt een matrix van getallen voor.
 * @immutable 
 */
public class Matrix {
	
	/**
	 * @pre | elements != null
	 * @pre | rowCount >= 0 && columnCount >=0
	 * @pre | rowCount*columnCount == elements.length
	 * @post | getRowCount() == rowCount
	 * @post | getColumnCount() == columnCount
	 * @post | Arrays.equals(getRowMajor(), elements)
	 */
	Matrix(int rowCount, int columnCount, double[] elements){
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post | result == getRows().length
	 */
	public int getRowCount() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post | result == 0 || result == getRows()[0].length
	 */
	public int getColumnCount() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @pre | getRowCount() > 0
	 * @pre | rowIndex >= 0 && rowIndex < getRowCount()
	 * @pre | columnIndex >= 0 && columnIndex < getColumnCount()
	 * @post | result == getRows()[rowIndex][columnIndex]
	 */
	public double getElement(int rowIndex, int columnIndex) {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	
	public double[] getRowMajor() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post
	 * | IntStream.range(0, getRowCount()).allMatch(i -> IntStream.range(0,getColumnCount()).allMatch(j -> getRows()[i][j]==result[(j)*getRowCount()+i]))
	 */
	public double[] getColumnMajor() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> IntStream.range(0,getColumnCount()).allMatch(j -> result[i][j]==getRowMajor()[(i)*getColumnCount()+j]))
	 * @post | result.length == getRowCount() && result[0].length == getColumnCount()
	 */
	public double[][] getRows() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	
	
	public Matrix scaled() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	public Matrix plus() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
}
