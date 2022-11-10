package linkedlist;

public class MergeTwoSortedList_21 {
    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode(){}
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode result=new ListNode();
        ListNode temp=result;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                temp.next=new ListNode(p1.val,null);
                temp=temp.next;
                p1=p1.next;
            }else{
                temp.next=new ListNode(p2.val,null);
                temp=temp.next;
                p2=p2.next;
            }
        }
        while(p1!=null){
            temp.next=new ListNode(p1.val,null);
            p1=p1.next;
            temp=temp.next;
        }
        while(p2!=null){
            temp.next=new ListNode(p2.val,null);
            p2=p2.next;
            temp=temp.next;
        }
        return result.next;
    }
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={2,4,6,8,10};
        ListNode node1 =new ListNode(arr1[0],null);
        ListNode temp=node1;
        for(int i=1;i<arr1.length;i++){
            temp.next=new ListNode(arr1[i],null);
            temp=temp.next;
        }
        ListNode node2 =new ListNode(arr2[0],null);
        temp=node2;
        for(int i=1;i<arr2.length;i++){
            temp.next=new ListNode(arr2[i],null);
            temp=temp.next;
        }
        ListNode result=mergeTwoLists(node1,node2);
        while(result!=null){
            if(result.next==null)
                System.out.println(result.val);
            else
                System.out.print(result.val+"->");
            result=result.next;
        }
    }
}
