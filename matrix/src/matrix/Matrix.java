package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van Matrix stelt een matrix van 'double'-waarden voor.
 * @immutable 
 */
public class Matrix {
	
	/**
	 * @invar | rowCount * colCount == rowMajor.length
	 * @invar | rowCount >= 1
	 * @invar | colCount >= 1
	 * @invar | rowMajor != null
	 */
	private int rowCount;
	private int colCount;
	/**
	 * @respresentationObject
	 */
	private double[] rowMajor;
	
	/**
	 * @creates | result, ...result
	 * @post | result != null
	 * @post | result.length > 0
	 * @post | IntStream.range(0, result.length).allMatch(i -> result[i] != null && result.length >=0)
	 */
	public double[][] getRows(){
		double[][] result = new double[rowCount][colCount];
		for (int i=0; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				result[i][j] = rowMajor[i*rowCount+j];
			}
		}
		return result;
	}
	
	/**
	 * @post result == getRows().length
	 */
	public int getRowCount(){
		return rowCount;
	}
	
	/**
	 * @post result == getRows()[0].length
	 */
	public int getColCount(){
		return colCount;
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> 
     * | 			IntStream.range(0, getColCount()).allMatch(j -> result[i*getColCount()+j] == getRows()[i][j]))
	 */
	public double[] getRowMajor() {
		return rowMajor.clone();
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | IntStream.range(0, getRowCount()).allMatch(i -> 
     * | 			IntStream.range(0, getColCount()).allMatch(j -> result[j*getColCount()+i] == getRows()[i][j]))
	 */
	public double[] getColMajor() {
		double[] result = new double[rowMajor.length];
		for (int i=0;i<rowCount;i++) {
			for (int j=0;j<colCount;j++) {
				result[j*rowCount+i] = rowMajor[i*colCount+j];
			}
		}
		return result;
	}
	
	/**
	 * @pre | row < getRowCount() && row >= 0
	 * @pre | col < getColCount() && col >= 0
	 * @post | result == getRows()[row][col]
	 */
	public double getElement(int row, int col) {
		return rowMajor[row*colCount+col];
	}
	
	/** 
	 *  @pre | rowMajor != null
	 *  @pre | rowCount * colCount == rowMajor.length
	 *  @pre | rowCount >= 0 && colCount >=0
	 *	@inspects | rowMajor
	 *	@post | getRowCount() == rowCount
	 *	@post | getColCount() == colCount
	 *	@post | Arrays.equals(getRowMajor(),rowMajor)
	 */
	Matrix(int rowCount, int colCount, double[] rowMajor){
		this.rowCount = rowCount;
		this.colCount = colCount;
		this.rowMajor = rowMajor.clone();
	}
	
	
	/**
	 * @post | result != null
	 * @post | result.getRowCount() == getRowCount()
	 * @post | result.getColCount() == getColCount()
	 * @post | IntStream.range(0,getRowMajor().length).allMatch(i -> getRowMajor()[i]*scalar == result.getRowMajor()[i])
	 */
	Matrix scaled(double scalar) {
		double[] newRowMajor = new double[rowMajor.length];
		for (int i=0;i<rowMajor.length;i++) {
			newRowMajor[i] = rowMajor[i]*scalar;
		}
		return new Matrix(rowCount, colCount, newRowMajor);
	}
	
	/**
	 * @pre | other != null
	 * @pre | other.getRowCount() == getRowCount()
	 * @pre | other.getColCount() == getColCount()
	 * @post | result != null
	 * @post | result.getRowCount() == getRowCount()
	 * @post | result.getColCount() == getColCount()
	 * @post | IntStream.range(0,getRowMajor().length).allMatch(i -> getRowMajor()[i] + other.getRowMajor()[i] == result.getRowMajor()[i])
	 */
	Matrix plus(Matrix other) {
		double[] newRowMajor = new double[rowMajor.length];
		for (int i=0;i<rowMajor.length;i++) {
			newRowMajor[i] = rowMajor[i]+ other.getRowMajor()[i];
		}
		return new Matrix(rowCount, colCount, newRowMajor);
	}
}
