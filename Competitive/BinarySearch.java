import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] arr = {4, 6, 7, 9, 5, 12, 63, 64, 54};
		System.out.println(binarySearch(arr,15));
	}
	public static int binarySearch(Integer[] arr , int num){
		int start = 0;
		int end = arr.length -1;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid]==num){
				return mid;
			}
			if(num<arr[mid]){
				end = mid -1;
			}else{
				start = mid+1;
			}
		}
		return -1;
	}
}
