package arrays;

import java.util.*;

/**
 * 49. Group Anagrams
 *
 * Example 1
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * */
public class GroupAnagrams_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        /**Storing List of sorted characters of each strings
         * map will contain ate->eat,ate
         *                  bat->tab,bat
         *                  */
        /**
         * key is sorted while inserting it into map
         * so Time Complexity is O(n*k log k)
         * k is length of string*/
        HashMap<List<String>,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            List<String> list=new ArrayList<>();
            for(int j=0;j<str.length();j++){
                list.add(""+str.charAt(j));
            }
            Collections.sort(list);
            if(!map.containsKey(list)){
                List<String> ll=new ArrayList<>();
                ll.add(str);
                map.put(list,ll);
            }else{
                List<String> ll=map.get(list);
                ll.add(str);
                map.put(list,ll);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(Map.Entry<List<String>,List<String>> pairs:map.entrySet()){
            result.add(pairs.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str={"eat","tea","tan","ate","nat","bat"};
        str=new String[]{"","b"};
        str=new String[]{"rag","orr","err","bad","foe","ivy","tho","gem","len","cat","ron","ump","nev","cam","pen","dis","rob","tex","sin","col","buy","say","big","wed","eco","bet","fog","buy","san","kid","lox","sen","ani","mac","eta","wis","pot","sid","dot","ham","gay","oar","sid","had","paw","sod","sop"};
//        str=new String[]{"c","c"};

        List<List<String>> result=groupAnagrams(str);
        System.out.println(result);
//
//
//        List<String> list=new ArrayList<>(Arrays.asList("b","e","a","c"));
//        System.out.println(list);
//        Collections.sort(list);
//        list.add("d");
//        System.out.println(list);
    }
}
