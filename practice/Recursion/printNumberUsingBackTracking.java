package practice.recursion;
// print 1 to 3 with using + i.e. using back tracking

public class printNumberUsingBackTracking {
    public static void print(int n){
        if(n<1){
            return;
        }
        print(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        print(3); // return by (1) function completed
    }
}
/*
explanation:
main call--> print(3)
 (1)
 void print(3){
        if(n<1){
            return;
        }
        print(3-1); ------------------------------>    now return by(2)
        System.out.print(n+" "); // print 3
    }                                                         (2)
                                                        void print(2){
                                                        if(n<1){
                                                          return;
                                                             }
                                     <---------------   print(2-1);  <-----return by(3)
                                                      System.out.print(n+" "); // print:2
                                                             }
       (3)
    void print(1){
        if(n<1){
            return;
        }
        print(1-1); ------------------------------> return by (4)<-----
        System.out.print(n+" ");  // print n i.e 1
    }
                                                        (4)
                                                        void print(0){
                                                         if(n<1){
                                                           return; ---> condition true return
                                                             }
                                                         print(n-1); ------------------------------>
                                                      System.out.print(n+" ");
                                                           }

                        output-->1 2 3


 //          f(3)-->return , print 3
          f(2)-->return , print 2
       f(1)-->return , print 1
    f(0)-->return




 */

// print 3 to 1 using backtracking

//public class printNumberUsingBackTracking {
//    public static void print(int i,int n){
//        if(i>n){
//            return;
//        }
//        print(i+1,n);
//        System.out.print(i+" ");
//    }
//    public static void main(String[] args) {
//        print(1,3); // return by (1) function completed
//    }
//
//}
// same explanation