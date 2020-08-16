package org.arpit.java2blog;
 
import java.util.ArrayList;
import java.util.List;
 
public class PowerSet {
 
	public static void main(String[] args) {
 
		SubsetsOfSetJava soa= new SubsetsOfSetJava();
		int[] nums= {1, 2, 1};
		List<List<Integer>> subsets = soa.subsets(nums);
 
		for (List<Integer> subset: subsets) {
			System.out.println(subset);
		}
	}
 
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsetsHelper(list, new ArrayList<>(), nums, 0);
		return list;
	}
 
	private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
		list.add(new ArrayList<>(resultList));
		for(int i = start; i < nums.length; i++){
           // add element
			resultList.add(nums[i]);
           // Explore
			subsetsHelper(list, resultList, nums, i + 1);
           // remove
			resultList.remove(resultList.size() - 1);
		}
	}
 
}