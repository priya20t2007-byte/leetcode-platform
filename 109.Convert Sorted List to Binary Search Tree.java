class Solution {

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);
        return buildTree(0, size - 1);
    }

    private int getSize(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = buildTree(left, mid - 1);

        TreeNode root = new TreeNode(head.val);
        root.left = leftChild;

        head = head.next;

        root.right = buildTree(mid + 1, right);

        return root;
    }
}
