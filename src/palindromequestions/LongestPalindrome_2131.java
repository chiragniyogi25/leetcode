package palindromequestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Palindrome by Concatenating Two Letter Words**/
public class LongestPalindrome_2131 {
    //Time Complexity->O(n)+O(m)
    //space Complexity->O(m)->since hashmap is been used

    //Using HashMap
    public static int longestPalindrome(String[] words){
        int len=0;
        Map<String,Integer> map=new HashMap<>();
        //O(n)
        for(String str:words){
            String reverse=reverse(str);
            //checking if there are any reverse of current string present
            if(map.containsKey(reverse)) {
                //removing string count as soon as we get reverse of current string
                map.put(reverse, map.get(reverse) -1);
                if(map.get(reverse)==0)
                    map.remove(reverse);
                len+=4;//since the of strings are 2
                //adding both the string length
            }else{
                //if no reverse found
                //if already string exist update its value
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                }else{
                    //if new string and no reverse there just add it to map
                    map.put(str, 1);
                }
            }
        }
        //middle can contain only strings like gg
        //middle element cannot contain string like lc
        int mid=0;
//        O(m)
        for(Map.Entry<String,Integer> pairs:map.entrySet()){
            String str=pairs.getKey();
            int value=pairs.getValue();
            if(mid<2 && value==1  && str.charAt(0)==str.charAt(1)){
                mid+=2;
            }
            if(mid==2)
                break;
        }
        return len+mid;
    }
    //Finding Reverse of the String
    public static String reverse(String str){
        return ""+str.charAt(1)+str.charAt(0);
    }
    //Without HashMap
    //space-Complexity->O(26*26)
    public static int longestPalindromeWithoutHashMap(String[] words){
        int len=0;
        int[][] freq=new int[26][26];
        for(String str:words){
            int index1=str.charAt(0)-'a';
            int index2=str.charAt(1)-'a';
            //if reverse found for the current string
            if(freq[index2][index1]>0){
                --freq[index2][index1];
                len+=4;
            }else
                //if reverse not found
                ++freq[index1][index2];
        }
        //case for gg,aa->can have only 1 at middle if present
        for(int i=0;i<26;i++){
            if(freq[i][i]>0)return len+2;
        }
        return len;
    }

    public static void main(String[] args) {
//        String[] words={"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
//        String[] words={"ab","ty","yt","lc","cl","ab"};
        String[] words={"mm","mm","yb","by","bb","bm","ym","mb","yb","by","mb","mb","bb","yb","by","bb","yb","my","mb","ym"};
        System.out.println(longestPalindrome(words));
        System.out.println(longestPalindromeWithoutHashMap(words));
    }
    /**
     * dd->5=>4*2=8
     * aa->3=>2*2=4
     * bb->3=>2*2=4
     * cc->3=>2*2=4
     * ddddaabbccccbbaadddd
     * */
    /**
     * ab->2
     * ty->2
     * lc->2*/

}
