import java.util.*;

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
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> list=new ArrayList<>();

        if(nums.length<3)
            return new ArrayList<>();
        int p1=0,p3=2;


        return list;
    }
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        threeSum(arr);
    }
}
