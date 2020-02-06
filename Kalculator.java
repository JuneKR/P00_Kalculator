//Name: Aekkaluk Panyacharoensri
//ID: 6288031
//Section: 1

import java.util.ArrayList;

// import jdk.javadoc.internal.doclets.toolkit.resources.doclets;
public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	private ArrayList<Double> setNumber = new ArrayList<Double>();
	private int arrLength; //check length of set number!
	private double sum;
	private double avg;
	private double std;
	private double max;
	private double min;
	private double[] maxArr;
	private double[] minArr;
 	
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		this.arrLength = 0;
		this.sum = 0;
		this.avg = 0;
		this.std = 0;
		this.max = 0;
		this.min = 0;
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		setNumber.add(number);
		arrLength++;
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(setNumber.isEmpty() == false){
			setNumber.remove(0);
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(setNumber.isEmpty() == false){
			setNumber.remove(setNumber.size()-1);
		}
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		if(setNumber.isEmpty() == false){
			for(double i : setNumber){
				this.sum += i;
			}
			return this.sum;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(setNumber.isEmpty() == false){
			for(double i : setNumber){
				this.avg += i;
			}
			this.avg /= arrLength;
			return this.avg;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		if(arrLength >= 2){
			for(double i : setNumber){
				this.std += Math.pow((i-this.avg), 2);
			}
			this.std = Math.sqrt(this.std/(this.arrLength-1));
			return this.std;
		}
		return 0;	
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		//
		if(setNumber.isEmpty() == false){
			this.max = setNumber.get(0);
			for(double i : setNumber){
				if(i > this.max){
					this.max = i;
				}
			}
			return this.max;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		if(setNumber.isEmpty() == false){
			this.min = setNumber.get(0);
			for(double i : setNumber){
				if(i < this.min){
					this.min = i;
				}
			}
			return this.min;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(arrLength >= k){
			maxArr = new double[k];
			double first = setNumber.get(0);
			double sec = setNumber.get(0);
			double third = setNumber.get(0);
			for(double i : setNumber){
				if (i > first) {
					third = sec;
					sec = first;
					first = i;
				}
				else if(i > sec){
					third = sec;
					sec = i;
				}
				else if(i > third){
					third = i;
				}
			}
			this.maxArr[0] = first;
			this.maxArr[1] = sec;
			this.maxArr[2] = third;
			return maxArr;
		}
		return null;
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		//Creating an array of k elements  
		if(arrLength >= k){
			minArr = new double[k];
			double temp = 0;
			int count = 0;
			double[] arr = new double[arrLength];
			for(double i : setNumber){
				arr[count] = i;
				count++;
			}
			for(int i = 0; i < arrLength; i++){
				for(int j = 0; j < arrLength-1; j++){
					if(arr[j] > arr[j+1]){
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			for(int i = 0; i < k; i++){
				minArr[i] = arr[i];
			}
			return minArr;
		}
		return null;
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.println("DATA["+setNumber.size()+"]:"+setNumber);
		//**************************************
	}
}
