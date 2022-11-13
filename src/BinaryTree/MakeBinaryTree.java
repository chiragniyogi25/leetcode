package BinaryTree;

import java.util.Scanner;

public class MakeBinaryTree {
    static Scanner sc;
    private static class Node{
        Node left,right;
        int val;
        Node(int val){
            this.val=val;
        }
    }
    //LNR
    private static void inOrderTraversal(Node root){
        if(root==null)return;

        inOrderTraversal(root.left);
        System.out.print(root.val+"->");
        inOrderTraversal(root.right);
    }
    //NLR
    private static void preOrderTraversal(Node root){
        if(root==null)return;
        System.out.print(root.val+"->");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //LRN
    private static void postOrderTraversal(Node root){
        if(root==null)return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+"->");
    }
    private static Node createTree(){
        Node root=null;
        System.out.println("Enter Data");
        int val=sc.nextInt();

        if(val==-1)return null;

        root=new Node(val);
        System.out.println("Enter left data for "+val);
        root.left=createTree();
        System.out.println("Enter right data for "+val);
        root.right=createTree();
        return root;
    }

    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node node=createTree();
//        preOrderTraversal(node);
        System.out.println();
        postOrderTraversal(node);
        System.out.println();
        inOrderTraversal(node);
        System.out.println();
        preOrderTraversal(node);
    }

}
