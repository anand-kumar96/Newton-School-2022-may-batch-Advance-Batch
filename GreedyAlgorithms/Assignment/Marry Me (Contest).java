// method 01
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args){
    Scanner sc=new Scanner(System.in);
    int tc=sc.nextInt();
    while(tc-->0){
        String R=sc.next();
        String S=sc.next();
        int l1=R.length();
        int l2=S.length();
         if(l1>l2){
             int i=0,j=0,count=0;
           while(i<l1 && j<l2){
               if(R.charAt(i)==S.charAt(j)){
                   i++;
                   j++;
                   count++;
               }else{
                  i++; 
               }
           }
        //    System.out.println(l2);
        
           if(count==l2){ 
            System.out.println("#SadLife");
        }else{
         System.out.println("#DieSingle");
           }
            }else{
         int i=0,j=0,count=0;
           while(i<l1 && j<l2){
               if(R.charAt(i)==S.charAt(j)){
                   i++;
                   j++;
                   count++;
               }else{
                  j++; 
               }
           }
            //    System.out.println(l1);
            //    System.out.println(count);
           if(count==l1){
            System.out.println("#SadLife");
        }else{
     System.out.println("#DieSingle");
           }
    }
    }
    }
}
//method 02
  import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    public static void main (String[] args){
    Scanner sc=new Scanner(System.in);
    int tc=sc.nextInt();
    while(tc-->0){
        String R=sc.next();
        String S=sc.next();
        String r;
        String s;
        int m=R.length();
        int n=S.length();
         if(m>n){
             r=R;
             s=S;
         }else{
             r=S;
             s=R;
         }
        int l1=r.length();
        int l2=s.length();
             int i=0,j=0;
           while(i<l1 && j<l2){
               if(r.charAt(i)==s.charAt(j)){
                   i++;
                   j++;
               }else{
                  i++; 
               }
           }
           if(j==l2){
            System.out.println("#SadLife");
        }else{
     System.out.println("#DieSingle");
           }
    }
    }
}
  // method 03
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
   private boolean isGettingMarried(String R, String G) {
        int lengthR = R.length();
        int lengthG = G.length();

        String smallerString;
        String largerString;

        if(lengthG < lengthR) {
            smallerString = G;
            largerString = R;
        }
        else {
            smallerString = R;
            largerString = G;
        }

        int i = 0;
        int j = 0;

        while(i < smallerString.length() && j < largerString.length()) {
            if(smallerString.charAt(i) == largerString.charAt(j)) {
                i++;
            }
            j++;
        }

        if(i == smallerString.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarryMe marryMe = new MarryMe();

        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i = 1; i <= T; i++) {
            String R = scanner.next();
            String G = scanner.next();

            boolean isGettingMarried = marryMe.isGettingMarried(R, G);

            if(isGettingMarried) {
                System.out.println("#SadLife");
            }
            else {
                System.out.println("#DieSingle");
            }
        }
    }
}
   /*
   Marry Me (Contest)
medium
Time Limit: 2 sec
Memory Limit: 128000 kB
Problem Statement
Ram is a single boy in his village, everyone in his family are searching a bride for him and recommending for Ram but Ram wants to Die Single, so for prevention of his marriage he came up a plan. He says that he will marry that girl only If recommending member's name is a subsequence of girl name or girl's name is a subsequence of recommending member. Don't worry Ram has a Huge Family. Your task is to determine wether Ram will Die Single or will be married.
Input
The first line of the input contains an integer T denoting number of test cases.
In each test case there contains two space separated strings R and G.

Constraint's
1 ≤ T ≤ 100
1 ≤ |R|, |G| ≤ 25000 (|X| denotes the length of the string X).
All names consist of english lower case letter's only.
Output
For each test case print "#DieSingle" if Ram's family can't find a perfect match, else print "#SadLife". (quotes are meant for clarity, please don't print them).
Example
Sample Input
2
nirali nirali
salie galie

Sample Output
#SadLife
#DieSingle

Explanation
Case 1: Any string is a subsequence of it self, as it is formed after removing "0" characters. Hence the answer is "#SadLife".

Case 2: "salie" can not be attained from "galie" as removing any character from "salie" would make the string length smaller than "galie", also there is no 'g' in "salie". Similar reasoning can be applied to see why "galie" can't be attained from "salie". Hence the answer is "#DieSingle".
   */
