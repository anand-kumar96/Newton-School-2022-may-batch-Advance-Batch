package practice.recursion;

// sum of first n number
//public class sumofFirstNnumber {
//    static int totalSum=0;
//    public static void sum(int i,int n){
//        if(i>n){
//            return;
//        }
//        totalSum+=i;
//        sum(i+1,n);
//    }
//    public static void main(String[] args) {
//        sum(1,5);
//        System.out.println(totalSum);
//    }
//}
/*
explanation:

                     f(1,5)     totalSum=15
                   f(2,5)    totalSum=14
                 f(3,5)   totalSum=12
               f(4,5)   totalSum=9
             f(5,5)   totalSum=5
          f(6,5)--> return

 */

//method 2-->parametric method

public class sumofFirstNnumber {
    public static void sum(int i,int  totalSum ){
        if(i<1){
            System.out.println( totalSum);
            return;
        }
        sum(i-1, totalSum+i);
    }
    public static void main(String[] args) {
        sum(5,0);
    }
}
/*
explanation:
           f(5,0)   return
         f(4,5)    return
       f(3,5+4)   return
     f(2,5+4+3)   return
   f(1,5+4+3+2)   return
 f(0,5+4+3+2+1)-->since 0<1 so-->  print totalSum=5+4+3+2+1=15
                   then return

        */




//method 2-->functional method--> very very important --> this i want learn

//public class sumofFirstNnumber{
//    public static int sum(int n){
//        if(n==0){
//            return 0;
//        }
//       return n+sum(n-1);
//    }
//    public static void main(String[] args) {
//        System.out.println(sum(3));
//    }
//}
/*
explanation:
           main(3)-->call // return 6 // print 6

           (1)
     int sum(3){
        if(n==0){
            return 0;
        }
       return 3 +sum(n-1);----------------------------> // return 3+3=6
       // here 3 waiting for sum function sum(3-1)
    }
                                                                (2)
                                                             int sum(2){
                                                               if(n==0){
                                                                return 0;
                                                                   }
                                          <-----------------  return 2 +sum(2-1); // return 2+1=3
                                                        // here 2 waiting for sum function sum(2-1)
                                                           }
     (3)
     int sum(1){
       if(n==0){
        return 0;
        }
       return 1 +sum(1-1);----------------------------> // return 1+0=1
       // here 1 waiting for sum function sum(1-1)
    }

                                                              (4)
                                                             int sum(0){
                                                               if(n==0){    -->// execute return 0
                                                                return 0;
                                                                   }
                                                            return 2 +sum(2-1);

                                                           }

        */