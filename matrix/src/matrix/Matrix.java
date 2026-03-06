package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van Matrix stelt een matrix van 'double'-waarden voor.
 * @immutable 
 */
public class Matrix {
	
	/**
	 * @creates | result, ...result
	 * @post | result != null
	 * @post | result.length > 0
	 * @post | IntStream.range(0, result.length).allMatch(i -> result[i] != null && result.length >=0)
	 */
	public double[][] getRows(){
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post result == getRows().length
	 */
	public int getRowCount(){
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @post result == getRows()[0].length
	 */
	public int getColCount(){
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> 
     * | 			IntStream.range(0, getColCount()).allMatch(j -> result[i*getColCount()+j] == getRows()[i][j]))
	 */
	public double[] getRowMajor() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> 
     * | 			IntStream.range(0, getColCount()).allMatch(j -> result[j*getColCount()+i] == getRows()[i][j]))
	 */
	public double[] getColMajor() {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @pre | row < getRowCount() && row >= 0
	 * @pre | col < getColCount() && col >= 0
	 * @post | result == getRows()[row][col]
	 */
	public double getElement(int row, int col) {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/** 
	 *  @pre | rowMajor != null
	 *  @pre | rowCount * colCount == rowMajor.length
	 *  @pre | rowCount >= 0 && colCount >=0
	 *	@inspects | rowMajor
	 *	@post | getRowCount() == rowCount
	 *	@post | getColCount() == colCount
	 *	@post | getRowMajor() == rowMajor
	 */
	Matrix(int rowCount, int colCount, double[] rowMajor){
		throw new IllegalArgumentException("not yet implemented");
	}
	
	
	/**
	 * @post | result != null
	 * @post | result.getRowCount() == getRowCount()
	 * @post | result.getColCount() == getColCount()
	 * @post | IntStream.range(0,getRowMajor().length).allMatch(i -> getRowMajor()[i]*scalar == result.getRowMajor()[i])
	 */
	Matrix scaled(double scalar) {
		throw new IllegalArgumentException("not yet implemented");
	}
	
	/**
	 * @pre | other != null
	 * @pre | other.getRowCount() == getRowCount()
	 * @pre | other.getColCount() == getColCount()
	 * @post | result != null
	 * @post | result.getRowCount() == getRowCount()
	 * @post | result.getColCount() == getColCount()
	 * @post | IntStream.range(0,getRowMajor().length).allMatch(i -> getRowMajor()[i]*+ other.getRowMajor()[i] == result.getRowMajor()[i])
	 */
	Matrix plus(Matrix other) {
		throw new IllegalArgumentException("not yet implemented");
	}
}
