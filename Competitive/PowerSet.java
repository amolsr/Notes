package org.arpit.java2blog;
 
import java.util.ArrayList;
import java.util.List;
 
public class PowerSet {
 
	public static void main(String[] args) {
 
		int[] input= {1, 2, 1};
		List<List<Integer>> subsets = getSubsets(input);
 
		for (List<Integer> subset: subsets) {
			System.out.println(subset);
		}
	}
 
	public List<List<Integer>> getSubsets(int[] input) {
		List<List<Integer>> list = new ArrayList<>();
		subsetHelper(list, new ArrayList<>(), input, 0);
		return list;
	}
 
	private static void subsetHelper(List<List<Integer>> list , List<Integer> result, int [] input, int start){
		list.add(new ArrayList<>(result));
		for(int i = start; i < input.length; i++){
	        result.add(input[i]);
		subsetHelper(list, result, input, i + 1);
		result.remove(result.size() - 1);
		}
	}
 
}
