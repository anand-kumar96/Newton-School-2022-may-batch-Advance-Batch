package practice.recursion;

public class ReverseArray {
    /*
    public static void main(String[] args) {
        // using for loop
        int arr[]={1,2,3,4,5,6,7};
        int n=arr.length;
        int j=n-1;
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
              j--;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

    }

     */
// using two variable

//    public static void swap(int arr[],int n,int i,int j){
//        //swap
//        if(i>j){ // or i>n/2  --> we can neglect n
//            return;
//        }
//        int temp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=temp;
//        swap(arr,n,i+1,j-1);
//    }
//
//    public static void main(String[] args) {
//        int arr[]={1,2,3,4,5,6,7};
//        int n=arr.length;
//        swap(arr,n,0,n-1);
//        for(int i=0;i<n;i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
//}


    // using one  variable
    public static void swap(int arr[], int n, int i) {
        //swap
        if (i > n) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;
        swap(arr, n - 1, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        swap(arr, n - 1, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}