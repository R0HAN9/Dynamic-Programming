// Binary Tree Cameras

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int camera = 0; // Variable to count the number of cameras used

    public int minCameraCover(TreeNode root) {
        camera = 0; // Reset the camera count for each function call
        int ans = solve(root); // Recursively determine the camera placement
        
        // If the root itself is not covered, increment the camera count
        return (ans == 0) ? ++camera : camera;
    }

    private int solve(TreeNode root) {
        if (root == null) return 1; // Null nodes are considered covered
        
        // Recursive calls to process the left and right subtrees
        int left = solve(root.left);
        int right = solve(root.right);

        // If any child is not covered, place a camera at the current node
        if (left == 0 || right == 0) {
            camera++; // Increment the camera count
            return 2; // Indicate that this node has a camera
        }

        // If both children are covered but do not have cameras, this node is not covered
        if (left == 1 && right == 1) {
            return 0; // Indicate that this node is not covered
        }

        // If either child has a camera, this node is covered
        if (left == 2 || right == 2) {
            return 1; // Indicate that this node is covered
        }

        return -1; // This case will not be reached based on the logic
    }
}

