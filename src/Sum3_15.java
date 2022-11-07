import java.util.*;
//3SUM-Question 15
public class Sum3_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
////         O(n^3logn)
//        /**n^3 since 3 loops
//         * log n time for inserting data into set since before that we sorting it*/
//         Set<List<Integer>> set=new HashSet<>();
//         for(int i=0;i<nums.length-2;i++){
//             for(int j=i+1;j<nums.length-1;j++){
//                 for(int k=j+1;k<nums.length;k++){
//                     List<Integer> l1=new ArrayList<>();
//                     l1.add(nums[i]);
//                     l1.add(nums[j]);
//                     l1.add(nums[k]);
//                     Collections.sort(l1);//log n
//                     if((nums[i]+nums[j]+nums[k])==0)
//                         set.add(l1);
//                 }
//             }
//         }
//         List<List<Integer>> list1=new ArrayList<>();
//         for(List<Integer> row:set)
//             list1.add(row);
//         return list1;

        // O(n^2)
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0||(i>0 && nums[i]!=nums[i-1])){//skipping the repeated element
                //getting last repeated
                //checking the previous element
                int sum = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if ((nums[start] + nums[end]) > sum)
                        end--;
                    else if ((nums[start] + nums[end]) < sum)
                        start++;
                    else {
                        list.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }


        return list;
    }
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
