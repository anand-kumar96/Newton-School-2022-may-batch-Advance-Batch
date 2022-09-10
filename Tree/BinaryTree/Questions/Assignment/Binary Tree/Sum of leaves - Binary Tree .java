//method 1


/*
 class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
public static boolean isleaf(Node rootNode){
    if(rootNode==null){
        return false;
    }
    if(rootNode.left==null && rootNode.right==null){
        return true;
    }
    return false;
}
public static int sumOfLeaf(Node root){
       int sum=0;
    if(root!=null){
    if(isleaf(root)){
      sum+=root.data;
    }
    else{
        sum+=sumOfLeaf(root.left);
        sum+=sumOfLeaf(root.right);
    }
    }
    return sum;
 }


// method 02
/*
 class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
public static int sumOfLeaf(Node root){
       int sum=0;
    if(root!=null){
    if(root.left==null && root.right==null){
      sum+=root.data;
    }else{
        sum+=sumOfLeaf(root.left);
        sum+=sumOfLeaf(root.right);
    }
    }
    return sum;
 }
