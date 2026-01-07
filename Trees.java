import java.util.*;

class BeingZero {

    /* ================= BST NODE ================= */
    class BTNode {
        int val;
        BTNode left, right;

        int level;
        int depth;
        int subtreeSizeIncludingSelf;

        BTNode(int v) {
            val = v;
            left = right = null;
        }
    }

    /* ================= BASIC BST OPS ================= */

    int sizeOfTree(BTNode r) {
        if (r == null) return 0;
        return 1 + sizeOfTree(r.left) + sizeOfTree(r.right);
    }

    int countNodes(BTNode r) {
        return sizeOfTree(r);
    }

    int sumOfTreeNodes(BTNode r) {
        if (r == null) return 0;
        return r.val + sumOfTreeNodes(r.left) + sumOfTreeNodes(r.right);
    }

    int heightOfTree(BTNode r) {
        if (r == null) return -1;
        return 1 + Math.max(heightOfTree(r.left), heightOfTree(r.right));
    }

    int countLeafNodes(BTNode r) {
        if (r == null) return 0;
        if (r.left == null && r.right == null) return 1;
        return countLeafNodes(r.left) + countLeafNodes(r.right);
    }

    /* ================= BST INSERT ================= */

    BTNode insertIntoBST(BTNode root, int val) {
        if (root == null) return new BTNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /* ================= BST SEARCH ================= */

    boolean search(BTNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        if (key < root.val) return search(root.left, key);
        return search(root.right, key);
    }

    /* ================= BST MIN / MAX ================= */

    BTNode min(BTNode r) {
        while (r.left != null) r = r.left;
        return r;
    }

    BTNode max(BTNode r) {
        while (r.right != null) r = r.right;
        return r;
    }

    /* ================= BST DELETE ================= */

    BTNode deleteNode(BTNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            BTNode m = max(root.left);
            root.val = m.val;
            root.left = deleteNode(root.left, m.val);
        }
        return root;
    }
    /*================Diameter==================*/
     int max = 0;

    int height(TreeNode r) {
        if (r == null) return 0;

        int leftHeight = height(r.left);
        int rightHeight = height(r.right);

        // diameter passing through this node
        max = Math.max(max, leftHeight + rightHeight + 1);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int diameterOfTree(TreeNode r) {
        max = 0;          // IMPORTANT: reset for each call
        height(r);
        return max;
    }
    /* ================= BST LCA (OPTIMIZED) ================= */

    BTNode lowestCommonAncestor(BTNode root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p > root.val && q > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    /* ================= SUBTREE SUM ================= */

    void replaceWithSubtreeSum(BTNode r) {
        subtreeSum(r);
    }

    int subtreeSum(BTNode r) {
        if (r == null) return 0;
        int l = subtreeSum(r.left);
        int rt = subtreeSum(r.right);
        r.val += l + rt;
        return r.val;
    }

    /* ================= LEVEL ORDER ================= */

    List<List<Integer>> levelOrder(BTNode r) {
        List<List<Integer>> ans = new ArrayList<>();
        if (r == null) return ans;

        Queue<BTNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                BTNode c = q.poll();
                lvl.add(c.val);

                if (c.left != null) q.add(c.left);
                if (c.right != null) q.add(c.right);
            }
            ans.add(lvl);
        }
        return ans;
    }
/* ================= LEFT VIEW ================= */

    List<Integer> leftView(BTNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BTNode curr = q.poll();
                if (i == 0) ans.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return ans;
    }

    /* ================= RIGHT VIEW ================= */

    List<Integer> rightView(BTNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BTNode curr = q.poll();
                if (i == size - 1) ans.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return ans;
    }

    /* ================= TOP VIEW ================= */

    class Pair {
        BTNode node;
        int hd;

        Pair(BTNode n, int h) {
            node = n;
            hd = h;
        }
    }

    List<Integer> topView(BTNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.putIfAbsent(p.hd, p.node.val);

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    /* ================= BOTTOM VIEW ================= */

    List<Integer> bottomView(BTNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.put(p.hd, p.node.val); // overwrite for bottom view

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}

    /* ================= ZIG ZAG ================= */

    List<Integer> zigZag(BTNode r) {
        List<Integer> ans = new ArrayList<>();
        if (r == null) return ans;

        Queue<BTNode> q = new LinkedList<>();
        boolean rev = false;
        q.add(r);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                BTNode c = q.poll();
                lvl.add(c.val);

                if (c.left != null) q.add(c.left);
                if (c.right != null) q.add(c.right);
            }
            if (rev) Collections.reverse(lvl);
            rev = !rev;
            ans.addAll(lvl);
        }
        return ans;
    }
/*=============Vertical order===================*/
class BeingZero{
    public List< List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)return ans;
        Queue<pair> q=new LinkedList<>();
        Map<Integer,List<Integer>> mp=new TreeMap<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            pair curr=q.remove();
            TreeNode r=curr.root;
            int lvl=curr.lvl;
            mp.putIfAbsent(lvl,new ArrayList<>());
            mp.get(lvl).add(r.val);
            if(r.left!=null){
                q.add(new pair(r.left,lvl-1));
            }
            if(r.right!=null){
               q.add(new pair(r.right,lvl+1));
}

/*================fph================*/
 void fbh(BTNode r, int s, List<BTNode> path) {
        if (r == null) return;

        if (r.val == s) {
            path.add(r);
            return;
        }

        fbh(r.left, s, path);
        if (!path.isEmpty()) {
            path.add(r);
            return;
        }

        fbh(r.right, s, path);
        if (!path.isEmpty()) {
            path.add(r);
        }
    }

 /* ================= LEVEL ORDER (COUNT NODES AT K) ================= */
    int levelorder(BTNode r, int k) {
        if (r == null) return 0;

        Queue<BTNode> q = new LinkedList<>();
        q.add(r);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) return size;

            for (int i = 0; i < size; i++) {
                BTNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            level++;
        }
        return 0;
    }
    /* ================= COVERED / UNCOVERED ================= */

    long coveredUncoveredNodes(BTNode root) {
        if (root == null) return 0;

        long cover = 0, uncover = 0;
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BTNode c = q.poll();
                if (i == 0 || i == size - 1) uncover += c.val;
                else cover += c.val;

                if (c.left != null) q.add(c.left);
                if (c.right != null) q.add(c.right);
            }
        }
        return Math.abs(cover - uncover);
    }
}
