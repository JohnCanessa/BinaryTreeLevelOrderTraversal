import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Enhanced TreeNode class typically used
 * to solve LeetCode binary tree problems.
 */
public class TreeNode {
    
    // **** class members ****
    int         val;
    TreeNode    left;
    TreeNode    right;

    /**
     * Constructor.
     */
    public TreeNode() {
    }

    /**
     * Constructor.
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor.
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val    = val;
        this.left   = left;
        this.right  = right;
    }

    /**
     * Return a string representation of this node.
     */
    @Override
    public String toString() {
        return "(" + val + ") ";
    }

    /**
     * Populate the binary tree per level.
     */
    public TreeNode populate(Integer[] arr) {

        // **** sanity checks ****
        if (arr == null || arr.length == 0) {
            return null;
        }

        if (arr[0] == null)
            return null;

        // **** initialization ****
        Queue<TreeNode> treeNodeQ   = new LinkedList<>();
        Queue<Integer> integerQ     = new LinkedList<>();

        // **** populate integer queue ****
        for (int i = 1; i < arr.length; i++) {
            integerQ.offer(arr[i]);
        }

        // **** prime the tree node queue ****
        TreeNode root = new TreeNode(arr[0]);
        treeNodeQ.offer(root);

        // **** ****
        while (!integerQ.isEmpty()) {

            // **** ****
            Integer leftVal     = integerQ.isEmpty() ? null : integerQ.poll();
            Integer rightVal    = integerQ.isEmpty() ? null : integerQ.poll();
            TreeNode current    = treeNodeQ.poll();

            // **** ****
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                current.left = left;
                treeNodeQ.offer(left);
            }

            // **** ****
            if (rightVal != null) {
                TreeNode right = new TreeNode(rightVal);
                current.right = right;
                treeNodeQ.offer(right);
            }
        }

        // **** return root of binary tree ****
        return root;
    }


    // **** list of level node values ****
    private List<List<Integer>> levelOrderList = null;


    /**
     * Traverse binary tree in level order.
     * Recursive call entry point.
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {

        // **** initialization ****
        levelOrderList = new ArrayList<>();

        // **** recursion entry point ****
        levelOrderTraversal(root, 0);

        // **** return list of lists ****
        return levelOrderList;
    }


    /**
     * Traverse binary tree in level order.
     * Recursive call.
     */
    private void levelOrderTraversal(TreeNode root, int level) {
        if (root != null) {

            // **** initialize new array list ****
            if (level + 1 > levelOrderList.size())
                levelOrderList.add(new ArrayList<Integer>());

            // **** add node value to the list ****
            levelOrderList.get(level).add(root.val);

            // **** recurse left ****
            levelOrderTraversal(root.left, level + 1);

            // **** recurse right ****
            levelOrderTraversal(root.right, level + 1);
        }
    }

}
