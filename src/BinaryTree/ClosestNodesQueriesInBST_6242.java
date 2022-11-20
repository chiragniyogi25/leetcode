package BinaryTree;

import java.util.*;
/**
 * Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * Output: [[2,2],[4,6],[15,-1]]
 * */
public class ClosestNodesQueriesInBST_6242 {
    private static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static Set<Integer> inOrderTraversal(TreeNode root,Set<Integer> set){
        if(root==null)return null;
        inOrderTraversal(root.left,set);
        set.add(root.val);
        inOrderTraversal(root.right,set);
        return set;
    }
    public static List<Integer> binarySearch(List<Integer> list,int num){
        int low=0,end=list.size()-1;
        while(low<=end){
            int mid=low+(end-low)/2;
            if(list.get(mid)>num){
                end=mid-1;
            }else if(list.get(mid)<num){
                low=mid+1;
            }else{
                return new ArrayList<>(Arrays.asList(list.get(mid),list.get(mid)));
            }
        }
        return new ArrayList<>(Arrays.asList(end==-1?-1:list.get(end),low==list.size()?-1:list.get(low)));
    }
    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        set=inOrderTraversal(root,set);
        //sorting all the nodes in the BST
        List<Integer> sortedList=new ArrayList<>(set);
        Collections.sort(sortedList);
        System.out.println(sortedList);
        for(int i=0;i<queries.size();i++){
            //binary search of the query
            list.add(binarySearch(sortedList,queries.get(i)));
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr={6,2,13,1,4,9,15,null,null,null,null,null,null,14};
        TreeNode root=new TreeNode(arr[0]);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(15);
        root.right.right.left=new TreeNode(14);
        List<Integer> queries=new ArrayList<>(Arrays.asList(2,5,16,0));
        System.out.println(closestNodes(root,queries));
    }
}
