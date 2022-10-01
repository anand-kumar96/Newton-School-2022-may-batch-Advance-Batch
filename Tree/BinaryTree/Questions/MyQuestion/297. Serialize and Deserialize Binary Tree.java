//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                res.append("n " );
                continue;
            }
            res.append(temp.val+" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode>q=new LinkedList<>();
        String str[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for(int i=1;i<str.length;i++){
            TreeNode temp=q.poll();
            if(!str[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                temp.left=left;
                q.add(left);
            }
            if(!str[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                temp.right=right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));



// method 02
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}


// method 03

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
   private final String delimiter = ",";
    private final String NULL_NODE = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if(currentNode == null) {
                stringBuilder.append(NULL_NODE).append(delimiter);
            }
            else {
                stringBuilder.append(currentNode.val).append(delimiter);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") {
            return null;
        }

        String dataArray[] = data.split(delimiter);
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i = 1; i < dataArray.length; i++) {
            TreeNode currentNode = queue.poll();

            if(!dataArray[i].equals(NULL_NODE)) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(dataArray[i]));
                currentNode.left = leftChild;

                queue.add(leftChild);
            }

            if(!dataArray[++i].equals(NULL_NODE)) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(dataArray[i]));
                currentNode.right = rightChild;

                queue.add(rightChild);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
