package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindNumberOfNodes {
    public static void addEdge(ArrayList<Integer>[] adj_list, int src, int dest){
        adj_list[src].add(dest);
        adj_list[dest].add(src);
    }
    public static void main(String[] args) {
        int v=5;
        int edges=4;
        ArrayList<Integer>[] adj_list=new ArrayList[v+1];
        for(int i=0;i<adj_list.length;i++){
            adj_list[i]=new ArrayList<>();
        }
        for(int i=1;i<=edges;i++){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Source");
            int src=sc.nextInt();
            System.out.println("Enter Destination");
            int dest=sc.nextInt();
            addEdge(adj_list,src,dest);
        }
        Arrays.stream(adj_list).toList().stream().forEach(e-> System.out.println(e));
    }
}
