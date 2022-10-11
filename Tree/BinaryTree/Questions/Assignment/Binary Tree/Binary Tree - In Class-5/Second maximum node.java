//method 01
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
   static long arr[];
   static int i;
   public static void findsecondmax(TreeNode root){
    if(root==null){
        return;
    }
      arr[i++]=root.val;
      findsecondmax(root.left);
      findsecondmax(root.right);
   }
    public int SecondMaxNode(TreeNode root){
        i=0;
        arr=new long [1000001];
        if(root==null){
        return -1;
    }
     if(root.left==null && root.right==null){
        return root.val;
    }
    findsecondmax(root);
    int j=i;
    int k=0;
    long arr1[]=new long [j];
    for(int i=0;i<j;i++){
        arr1[k++]=arr[i];
    }
    Arrays.sort(arr1);
       return (int)arr1[j-2];
    }
}

//method 02
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
   static long result1;
   static long result2;
   public static void findsecondmax(TreeNode root){
    if(root==null){
        return;
    }
   // System.out.println(root.val);
    if(root.val>result1){
        result2=result1;
        result1=root.val;
    }else if(root.val>result2){
         result2=root.val;
     }
      findsecondmax(root.left);
      findsecondmax(root.right);
   }
    public int SecondMaxNode(TreeNode root){
         result1=-1;
         result2=-1;
        if(root==null){
        return -1;
    }
     if(root.left==null && root.right==null){
        return root.val;
     }
    findsecondmax(root);
       return (int)result2;
    }
}

// method 03
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    class Result {
        int highest;
        int secondHighest;
        Result() {
            highest = -1;
            secondHighest = -1;
        }
    }
    private void preorderTraversal(TreeNode currentNode, Result result) {
        if(currentNode == null) {
            return;
        }
        if(currentNode.val > result.highest) {
            result.secondHighest = result.highest;
            result.highest = currentNode.val;
        }
        else if(currentNode.val > result.secondHighest) {
            result.secondHighest = currentNode.val;
        }
        preorderTraversal(currentNode.left, result);
        preorderTraversal(currentNode.right, result);
    }
    public int SecondMaxNode(TreeNode root){
         Result result = new Result();
        preorderTraversal(root, result);
        return (
    (result.secondHighest != -1) ? (result.secondHighest) : (result.highest)
        );
    }
   
}
