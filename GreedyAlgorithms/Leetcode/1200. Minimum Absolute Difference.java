//https://leetcode.com/problems/minimum-absolute-difference/
// method 03
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<min){
                min=arr[i]-arr[i-1];
            }
            }
         for(int i=1;i<n;i++){
             if(arr[i]-arr[i-1]==min){
                 result.add(Arrays.asList(arr[i-1],arr[i]));
             }
        
        }
        
        return result;
    }
}
/*
to convert two number in array then list
*/


// by me
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(arr);
        int length=arr.length;
        int minimumdiff=Integer.MAX_VALUE;
        for(int i=1;i<length;i++){
            int currMin=arr[i]-arr[i-1];
            if( currMin>minimumdiff){
                continue;
            }
            if(currMin<minimumdiff){
                minimumdiff=currMin;
                result.clear();
            }
            result.add(Arrays.asList(arr[i-1],arr[i]));
        }
        return result;
    }
}

// or
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int minimumDifference = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++) {
            int currentDifference = arr[i] - arr[i - 1];

            if(currentDifference > minimumDifference) {
                continue;
            }

            if(currentDifference < minimumDifference) {
                minimumDifference = currentDifference;
                result.clear();
            }

            result.add(Arrays.asList(arr[i - 1], arr[i]));
        }

        return result;
    }
}
