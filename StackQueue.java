    public static class MinStackProblem {
        class MinStack {

            java.util.Stack<Integer> s;
            java.util.Stack<Integer> m;

            public MinStack() {
                s = new java.util.Stack<>();
                m = new java.util.Stack<>();
            }

            public void push(int val) {
                s.push(val);
                if (m.isEmpty()) {
                    m.push(val);
                } else {
                    m.push(Math.min(val, m.peek()));
                }
            }

            public void pop() {
                s.pop();
                m.pop();
            }

            public int top() {
                return s.peek();
            }

            public int getMin() {
                return m.peek();
            }
        }
    }

    public static class ImplementStackUsingQueues {
        class MyStack {
            java.util.Queue<Integer> q1;
            java.util.Queue<Integer> q2;
            public MyStack() {
              q1=new java.util.LinkedList<>();
              q2=new java.util.LinkedList<>();
            }
            
            public void push(int x) {
                q1.add(x);
            }
            
            public int pop() {
                if(q1.isEmpty())return -1;
                else {
                    while(q1.size()>1) {
                        q2.add(q1.remove());
                    }
                    int ele=q1.remove();
                    java.util.Queue<Integer> temp=q1;
                    q1=q2;
                    q2=temp;
                    return ele;
                }
            }
            
            public int top() {
                if(q1.isEmpty())return -1;
               while(q1.size()>1) {
                q2.add(q1.remove());
               }
                int ans=q1.peek();
                q2.add(q1.remove());
                java.util.Queue<Integer> temp=q1;
                q1=q2;
                q2=temp;
                return ans;
            }
            
            public boolean empty() {
                return q1.isEmpty();
            }
        }
    }

    public static class NextGreaterElementI {
        class Solution {
            public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
                java.util.Stack<Integer> stack = new java.util.Stack<>();
                for (int num : nums2) {
                    while (!stack.isEmpty() && stack.peek() < num) {
                        map.put(stack.pop(), num);
                    }
                    stack.push(num);
                }
                while (!stack.isEmpty()) {
                    map.put(stack.pop(), -1);
                }
                int[] res = new int[nums1.length];
                for (int i = 0; i < nums1.length; i++) {
                    res[i] = map.get(nums1[i]);
                }
                return res;
            }
        }
    }

    public static class NextGreaterElementII {
        class Solution {
            public int[] nextGreaterElements(int[] nums) {
                int n = nums.length;
                int[] res = new int[n];
                java.util.Stack<Integer> stack = new java.util.Stack<>();
                java.util.Arrays.fill(res, -1);
                for (int i = 0; i < 2 * n; i++) {
                    int num = nums[i % n];
                    while (!stack.isEmpty() && nums[stack.peek()] < num) {
                        res[stack.pop()] = num;
                    }
                    if (i < n) {
                        stack.push(i);
                    }
                }
                return res;
            }
        }
    }

    public static class LargestRectangleInHistogram {
        class Solution {
            public int largestRectangleArea(int[] heights) {
                int n=heights.length;
                int a[]=nse(heights,n);
                int b[]=pse(heights,n);
                int m=0;
                for(int i=0;i<n;i++) {
                    int area=(a[i]-b[i]-1)*heights[i];
                    m=Math.max(area,m);
                }
                return m;
            }
            public int[] nse(int []heights,int n) {
                int ns[]=new int[n];
                java.util.Arrays.fill(ns,n);
                java.util.Stack<Integer> wa=new java.util.Stack<>();
                for(int i=0;i<n;i++) {
                    while(!wa.isEmpty() && heights[i]<heights[wa.peek()]) {
                        ns[wa.pop()]=i;
                    }
                    wa.push(i);
                }
                return ns;
            }
            public int[] pse(int[]heights,int n) {
                int ps[]=new int[n];
                java.util.Arrays.fill(ps,-1);
                java.util.Stack<Integer> wa=new java.util.Stack<>();
                for(int i=n-1;i>=0;i--) {
                    while(!wa.isEmpty() && heights[i]<heights[wa.peek()]) {
                        ps[wa.pop()]=i;
                    }
                    wa.push(i);
                }
                return ps;
            }
        }
    }

    public static class CollectingMangoes {
        class BeingZero {
            java.util.Stack<Integer> stk=new java.util.Stack<>();
            java.util.Stack<Integer> mx=new java.util.Stack<>();
            BeingZero(){
                mx.add(0);
            }
            public void add(int ele) {
                stk.push(ele);
                mx.push(Math.max(mx.peek(), ele));
            }
            public int query() {
                return mx.peek();
            }
            public void remove(){
                if(!stk.isEmpty()){
                    stk.pop();
                    mx.pop();
                }
            }
        }
    }

    public static class ImplementQueueUsingStack {
        class MyQueue {
           java.util.Stack<Integer> s1;
           java.util.Stack<Integer> s2;
            public MyQueue() {
                s1=new java.util.Stack<>();
                s2=new java.util.Stack<>();
            }
            
            public void push(int x) {
                s1.push(x);
            }
            
            public int pop() {
                if(s2.isEmpty()) {
                    while(!s1.isEmpty())
                    s2.add(s1.pop());
                }
                if(s2.isEmpty())return -1;
                int p=s2.pop();
                return p;
            }
            
            public int peek() {
                if(s2.isEmpty()) {
                    while(!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                return s2.peek();
            }
            
            public boolean empty() {
                return s1.isEmpty() && s2.isEmpty();
            }
        }
    }

    public static class BinaryTreeLevelOrderTraversal {
        class Solution {
            public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
                java.util.List<java.util.List<Integer>> outer=new java.util.ArrayList<>();
                if(root==null)return outer;
                java.util.Queue<TreeNode>  q=new java.util.LinkedList<>();
                q.add(root);
                while(!q.isEmpty()) {
                    java.util.List<Integer> inner=new java.util.LinkedList<>();
                    int s=q.size();
                    for(int i=0;i<s;i++) {
                       TreeNode curr=q.remove();
                       inner.add(curr.val);
                       if(curr.left!=null)q.add(curr.left);
                       if(curr.right!=null)q.add(curr.right);
                    }
                    outer.add(inner);
                }
                return outer;
            }
        }
    }

    public static class BurnATree {
        class BeingZero{
            public int solve(TreeNode R, int L) {
                if(R == null)return 0;
                java.util.Map<TreeNode, TreeNode> m=new java.util.HashMap<>();
                java.util.Queue<TreeNode> q=new java.util.LinkedList<>();
                q.add(R);
                while(!q.isEmpty()){
                    TreeNode curr=q.remove();
                    if(curr.left != null){
                        m.put(curr.left, curr);
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        m.put(curr.right, curr);
                        q.add(curr.right);
                    }
                }
                TreeNode st=find(R,L);
                java.util.Set<TreeNode> s=new java.util.HashSet<>();
                s.add(st);
                q.add(st);
                int ans=0;
                while(!q.isEmpty()){
                    int size=q.size();
                    boolean flag=false;
                    for(int i=0;i<size;i++){
                        TreeNode n=q.remove();
                        if(m.containsKey(n) && !s.contains(m.get(n))){
                            s.add(m.get(n));
                            q.add(m.get(n));
                            flag=true;
                        }
                        if(n.left != null && !s.contains(n.left)){
                            s.add(n.left);
                            q.add(n.left);
                            flag=true;
                        }
                        if(n.right != null && !s.contains(n.right)){
                            s.add(n.right);
                            q.add(n.right);
                            flag=true;
                        }
                    }
                    if(flag)ans++;
                }
                return ans;
            }
            public TreeNode find(TreeNode r,int l){
                if(r == null)return null;
                if(r.val == l)return r;
                TreeNode left=find(r.left,l);
                TreeNode right=find(r.right,l);
                if(left == null)return right;
                if(right == null)return left;
                return null;
            }
        }
    }

    public static class MinimumCostToMakeLongestChain {
           class Beingzero {
               public int minCostLongChain(java.util.List<Integer> arr) {
                   java.util.PriorityQueue<Integer> pq=new java.util.PriorityQueue<>();
                   for(int ele:arr)
                       pq.add(ele);
                  int ans=0;
                 while(pq.size()>1){
                       int x=pq. remove();
                       int y=pq. remove();
                       int cost=x+y;
                       ans=ans+cost;
                       pq.add(cost);
                  }
               return ans;
               }
           }
    }

    public static class MedianOfStreamOfNumbers {
        class Beingzero {
            public float[] solve(int A[],int n) {
                float ans[]=new float[n];
                java.util.PriorityQueue<Float> left=new java.util.PriorityQueue<>((a,b)->Float.compare(b,a));
                java.util.PriorityQueue<Float> right=new java.util.PriorityQueue<>();
                for(int i=0;i<n;i++){
                    float val=A[i];
                    if(left.isEmpty()) left.add(val);
                    else if(val>left.peek()) right.add(val);
                    else left.add(val);
                    if(right.size()-left.size()>1)
                    left.add(right.poll());
                    if(left.size()-right.size()>1)
                    right.add(left.poll());
                    if(left.size() == right.size())
                    ans[i]=(left.peek()+right.peek())/2;
                    else if(left.size()>right.size())
                    ans[i]=left.peek();
                    else ans[i]=right.peek();
                }
                return ans;
            }
        }
    }

    public static class MeetingRooms {
        class BeingZero {
            public int meetingRooms(java.util.ArrayList<java.util.ArrayList<Integer>> list) {
                java.util.Collections.sort(list, (a,b)-> a.get(0)-b.get(0));
                java.util.PriorityQueue<Integer> pq=new java.util.PriorityQueue<>();
                for(java.util.ArrayList<Integer> x:list) {
                    int u=x.get(0);
                    int v=x.get(1);
                    if(!pq.isEmpty() && pq.peek() <= u)
                       pq.remove();
                   pq.add(v);
                }
                return pq.size();
            }
        }
    }
