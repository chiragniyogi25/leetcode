package linkedlist;

import java.util.*;

public class Sum4_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
//    Time Complexity-O(n^3)+)(log n)->O(n^3)
        //Space Complexity-O(m)//avoiding duplicates
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        Set<List<Integer>> set=new HashSet<>();
//        for (int i = 0; i < nums.length - 3; i++) {
//            for (int j = i+1; j < nums.length - 2; j++) {
//                // if (j == i+1 || (j > (i+1) && nums[j] != nums[j - 1])) {
//                long sum = (long) target - (long) (nums[i] + nums[j]);
//                int start = j + 1;
//                int end = nums.length - 1;
//                while (start < end) {
//
//                    if ((nums[start] + nums[end]) > sum)
//                        end--;
//                    else if ((nums[start] + nums[end]) < sum)
//                        start++;
//                    else {
//                        set.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
//                        while (start < end && nums[start] == nums[start + 1]) start++;
//                        while (start < end && nums[end] == nums[end - 1]) end--;
//                        start++;
//                        end--;
//                    }
//                }
//                // }
//            }
//        }
//        for(List<Integer> e:set)
//            list.add(e);
//        return list;

        //Optimal(Lower space complexity)
        //Time Complexity-O(n^3)+O(log n)->O(n^3)
        //space complexity-O(1)
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        // Set<List<Integer>> set=new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i+1; j < nums.length - 2; j++) {
                    if (j == i+1 || (j > (i+1) && nums[j] != nums[j - 1])) {
                        long sum = (long) target - (long) (nums[i] + nums[j]);
                        int start = j + 1;
                        int end = nums.length - 1;
                        while (start < end) {

                            if ((nums[start] + nums[end]) > sum)
                                end--;
                            else if ((nums[start] + nums[end]) < sum)
                                start++;
                            else {
                                list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            }
                        }
                    }
                }
            }
        }

        return list;
    }
    public static void main(String[] args) {
         int[] arr={1,0,-1,0,-2,2};
         System.out.println((fourSum(arr,0)));
    }
}
