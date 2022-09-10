package practice.recursion;
// print first 10 number
public class printnumber {
    public static void print(int n) {
        if (n > 10) {
            return;
        }
        System.out.print(n + " ");
        print(n + 1);
    }

    public static void main(String[] args) {
        print(0);
    }
}

    // print 10 to 0
//public static void print(int n){
//    if(n<0){
//        return ;
//    }
//    System.out.print(n+" ");
//    print(n-1);
//}
//    public static void main(String[] args) {
//        print(10);
//    }
//}
