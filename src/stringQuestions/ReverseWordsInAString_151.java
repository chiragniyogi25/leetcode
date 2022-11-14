package stringQuestions;

public class ReverseWordsInAString_151 {
    public static String reverseWords(String str) {
        /**using O(n) space*/
        //     String[] arrOfStrings=s.trim().split("\\s+");
        //     int len=arrOfStrings.length;
        //     for(int i=0;i<len/2;i++){
        //         String temp=arrOfStrings[i].trim();
        //         arrOfStrings[i]=arrOfStrings[len-1-i].trim();
        //         arrOfStrings[len-1-i]=temp;
        //     }
        //     StringBuilder result=new StringBuilder();
        //     for(String str:arrOfStrings){
        //         result.append(str);
        //         result.append(" ");
        //     }
        //     return result.toString().trim();

        /***Without using Space */
        int p1=0,p2=str.length();
        String str2_2="",str1_1="";
        while(p1<p2){
            String str1="", str2="";
            //skipping the extra spaces
            while(p1<p2 && str.charAt(p1)==' '){
                p1++;
            }
            //making second half of string
            while(p1<p2 && str.charAt(p1)!=' '){
                str2=str2+str.charAt(p1);
                p1++;
            }
            p2--;
            while(p1<p2 && str.charAt(p2)==' '){
                p2--;
            }

            //making first half of string
            while(p1<p2 && str.charAt(p2)!=' '){
                str1=""+str.charAt(p2)+str1;
                p2--;
            }
            //second half
            str2_2 = str2 +" "+ str2_2;
            //first half
            str1_1 = str1_1 +" "+ str1;

        }
        return (str1_1.trim()+" "+str2_2.trim()).trim();
    }

    public static void main(String[] args) {
//        String str="a good   example";
        String str="EPY2giL";
        System.out.println(reverseWords(str));
    }
}
