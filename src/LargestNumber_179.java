//public class LargestNumber_179 {
//    public static void merge(int[] nums,int left,int right,int mid){
//
//    }
//    public static void mergeSort(int[] nums,int left,int right){
//        if(left>=right)
//            return;
//        int mid=left+(right-left)/2;
//        mergeSort(nums,left,mid);//left half
//        mergeSort(nums,mid+1,right);//right half
//        merge(nums,left,right,mid);
//    }
//    public static String largestNumber(int[] nums){
//        mergeSort(nums,0,nums.length-1);
//
//    }
//    public static void main(String[] args) {
//        int[] arr={3,3004,34,5,9,99999000};
//        largestNumber(arr);
//    }
//}
