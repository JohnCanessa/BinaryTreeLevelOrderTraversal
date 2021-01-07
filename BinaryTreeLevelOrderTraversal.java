import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * LeetCode 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {


    /**
     * Given a binary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level).
     * 
     * Runtime: 1 ms, faster than 55.20% of Java online submissions.
     * Memory Usage: 39.1 MB, less than 81.39% of Java online submissions.
     */
    static List<List<Integer>> levelOrder(TreeNode root) {

        // **** sanity checks ****
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        // **** initialization****
        List<List<Integer>> lst         = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> primaryQ   = new LinkedList<>();
        LinkedList<TreeNode> secondaryQ = new LinkedList<>();

        ArrayList<Integer> al            = new ArrayList<Integer>();
        lst.add(al);

        // **** prime the primary queue ****
        primaryQ.offer(root);

        // **** loop while the primary queue is not empty ****
        while (!primaryQ.isEmpty()) {

            // **** remove head node ****
            TreeNode node = primaryQ.remove();

            // **** add node value to the array list ****
            al.add(node.val);

            // **** offer left child ****
            if (node.left != null)
                secondaryQ.offer(node.left);

            // **** offer right child ****
            if (node.right != null)
                secondaryQ.offer(node.right);

            // **** swap queues (if needed) ****
            if (primaryQ.isEmpty() && !secondaryQ.isEmpty()) {

                // **** swap queues ****
                primaryQ = secondaryQ;

                // **** create new queue ****
                secondaryQ = new LinkedList<>();

                // **** create new array list ****
                al = new ArrayList<Integer>();
                lst.add(al);
            }
        }

        // **** return list of list ****
        return lst;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read and populate String array ****
        String[] strArr = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< strArr: " + Arrays.toString(strArr));

        // **** create and populate Integer array ****
        Integer[] arr = new Integer[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            if (strArr[i].equals("null"))
                arr[i] = null;
            else
                arr[i] = Integer.parseInt(strArr[i]);
        }

        // ???? ????
        System.out.println("main <<<    arr: " + Arrays.toString(arr));
        
        // **** create the root for the binary tree ****
        TreeNode root = new TreeNode();

        // **** populate the binary tree ****
        root = root.populate(arr);

        // ???? ????
        System.out.println("main <<<   root: " + root.levelOrderTraversal(root));

        // **** generate and display the binary tree in level order ****
        System.out.println("main <<<    ans: " + levelOrder(root));
    }
}