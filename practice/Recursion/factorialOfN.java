package practice.recursion;

public class factorialOfN {

/*
   // using function method
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}

*/

// using parametric way method
public static void factorial(int n,int ans){
    if(n==1){
        System.out.println(ans);
        return ;
    }
     factorial(n-1,ans*n);
}
public static void main(String[] args) {
       factorial(5,1);
    }
}