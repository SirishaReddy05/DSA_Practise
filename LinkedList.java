public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class SLLNode {
        int data;
        SLLNode next;
        SLLNode(int d) {
            data = d;
            next = null;
        }
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static class Add2Numbers {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummy = new ListNode(-99);
                ListNode tail = dummy;
                int carry = 0,d1 = 0,d2 = 0,sum = 0;
                while(l1 != null || l2 != null || carry!=0){
                    if(l1 != null){
                        d1 = l1.val;
                    }
                    else{
                        d1 = 0;
                    }
                    if(l2 != null){
                        d2 = l2.val;
                    }
                    else{
                        d2 = 0;
                    }
                    sum = d1+d2+carry;
                    carry = sum/10;
                    ListNode nn = new ListNode(sum%10);
                    tail.next = nn;
                    tail = nn;
                    if(l1 != null){
                        l1 = l1.next;
                    }
                    else{
                        l1 = null;
                    }
                    if(l2 != null){
                        l2 = l2.next;
                    }
                    else{
                        l2 = null;
                    }
                }
                return dummy.next;
            }
        }
    }

    public static class CloneOfDoublyTroublyLinkedList {
        /*
        // Definition for a Node.
        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }
        */

        class Solution {
            public Node copyRandomList(Node head) {
                Node temp = head;
                Node dummy = new Node(-99);
                Node tail = dummy;
                while(temp != null){
                    Node nn = new Node(temp.val);
                    nn.next = temp.next;
                    temp.next = nn;
                    temp = temp.next.next;
                }
                temp = head;
                while(temp != null){
                    if(temp.random != null){
                        temp.next.random = temp.random.next;
                    }
                    else{
                        temp.next.random = null;
                    }
                    temp = temp.next.next;
                }
                temp = head;
                while(temp != null){
                    tail.next = temp.next;
                    temp.next = temp.next.next;
                    temp = temp.next;
                    tail = tail.next;
                }
                return dummy.next;
            }
        }
    }

    public static class CycleDetection {
        /**
         * Definition for singly-linked list.
         * class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        public class Solution {
            public boolean hasCycle(ListNode head) {
                ListNode s = head,f =head;
                while(f != null && f.next !=null){
                    f = f.next.next;
                    s = s.next;
                    if(s==f){
                        return true;
                    }
                }
                return false;
            }
        }
    }

    public static class CycleStart {
        /**
         * Definition for singly-linked list.
         * class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        public class Solution {
            public ListNode detectCycle(ListNode head) {
                ListNode s = head,f = head;
                while(f != null && f.next != null){
                    f = f.next.next;
                    s = s.next;
                    if(f==s){
                        f = head;
                        while(f != s){
                            f = f.next;
                            s = s.next;
                        }
                        return f;
                    }
                }
                return null;
            }
        }
    }

    public static class DeleteNodeInLL {
        import java.util.*;

        class ListNode {
            int val;
            ListNode next;
            
            ListNode(int x) {
                val = x;
            }
        }

        class BeingZero {
            void removeElements(ListNode node) {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }
    }

    public static class EvenReverse {
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        class SLLNode{
            int data;
            SLLNode next;
            SLLNode(int d){
                data = d;
                next = null;
            }
        };

        class BeingZero{
            public SLLNode evenReverse(SLLNode A) {
                SLLNode de = new SLLNode(9);
                SLLNode te = de;
                int pos = 1;
                SLLNode temp = A;
                while(temp != null){
                    if(pos%2 == 0){
                        te.next = new SLLNode(temp.data);
                        te = te.next;
                    }
                    temp = temp.next;
                    pos++;
                }
                de = reverse(de.next);
                temp = A;
                SLLNode curr = de;
                pos = 1;
                while(temp != null){
                    if(pos%2 == 0){
                        temp.data = curr.data;
                        curr = curr.next;
                    }
                    temp = temp.next;
                    pos++;
                }
                return A;
            }
            public SLLNode reverse(SLLNode h){
                SLLNode curr = h,prev = null,next = null;
                while(curr != null){
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                return prev;
            }
        }
    }

    public static class IntersectionOfTwoLinkedListsLC {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                if(headA == null || headB == null){
                    return null;
                }
                ListNode temp = headA;
                int l1 = 0;
                while(temp != null){
                    l1++;
                    temp = temp.next;
                }
                //System.out.println(l1);
                ListNode po = headB;
                int l2 = 0;
                while(po != null){
                    l2++;
                    po = po.next;
                }
                int diff = Math.abs(l1-l2);
                if(l1>l2){
                    for(int i=0;i<diff;i++){
                        headA = headA.next;
                    }
                }
                else{
                    for(int i=0;i<diff;i++){
                        headB = headB.next;
                    }
                }
                while(headA != null && headB != null){
                    if(headA == headB){
                        return headA;
                    }
                    headA = headA.next;
                    headB = headB.next;
                }
                return null;
            }
        }
    }

    public static class KeepAkelasOnly {
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        class SLLNode{
            int data;
            SLLNode next;
            SLLNode(int d){
                data = d;
                next = null;
            }
        };

        class BeingZero{
            public SLLNode removeDuplicates(SLLNode A) {
                if(A == null || A.next == null){
                    return null;
                }
                SLLNode temp = A;
                SLLNode dummy = new SLLNode(-99);
                SLLNode tail = dummy;
                int x = Integer.MIN_VALUE;
                while(temp != null && temp.next != null){
                    if(temp.data != temp.next.data){
                        tail.next = new SLLNode(temp.data);
                        tail = tail.next;
                        temp = temp.next;
                    }
                    else{
                        x= temp.data;
                        while(temp !=null && temp.data == x){
                            temp = temp.next;
                        }
                    }
                }
                if(temp != null && temp.data !=x){
                    tail.next = new SLLNode(temp.data);
                }
                return dummy.next;
            }
        }
    }

    public static class Merge2SortedLists {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode mergeTwoLists(ListNode A, ListNode B) {
                if(A == null){
                    return B;
                }
                if(B == null){
                    return A;
                } 
                ListNode temp = null;
                if(A.val < B.val){
                    temp = A;
                    A= A.next;
                }
                else{
                    temp = B;
                    B = B.next;
                }
                ListNode result = temp;
                while(A != null && B != null){
                    if(A.val < B.val){
                        result.next = A;
                        A= A.next;
                    }
                    else{
                        result.next = B;
                        B = B.next;
                    }
                    result = result.next;
                }
                if(A == null){
                    result.next = B;
                }
                if(B == null){
                    result.next = A;
                }
                return temp;
            }
        }
    }

    public static class MiddleOfLL {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode middleNode(ListNode head) {
                if(head == null || head.next == null){
                    return head;
                }
                ListNode slow = head,fast = head;
                while(fast != null && fast.next != null && fast.next.next!=  null){
                    fast = fast.next.next;
                    slow = slow.next;
                }
                if(fast.next == null){
                   // ListNode temp = slow.next;
                    //while(temp.next != null){
                        //temp = temp.next;
                    //}
                    return slow;
               }
                return slow.next;
            }
        }
    }

    public static class Palindrome {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public boolean isPalindrome(ListNode head) {
                if(head == null)return true;
                ListNode m = midNode(head);
                ListNode h1 = m.next;
                m.next = null;
                h1 = reverse(h1);
                while(h1 != null){
                    if(head.val != h1.val){
                        return false;
                    }
                    head = head.next;
                    h1 = h1.next;
                }
                return true;
            }
            public ListNode midNode(ListNode head){
                ListNode f = head,s = head;
                while(f!=null && f.next != null && f.next.next != null){
                    f = f.next.next;
                    s = s.next;
                }
                return s;
            }
            public ListNode reverse(ListNode head){
                ListNode curr = head,prev = null,nn = null;
                while(curr != null){
                    nn = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nn;
                }
                return prev;
            }
        }
    }

    public static class PartitionList {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode partition(ListNode head, int x) {
                ListNode dummy1 = new ListNode(0);
                ListNode dummy2 = new ListNode(0);
                ListNode dummy1t = dummy1;
                ListNode dummy2t = dummy2;
                ListNode temp = head;
                while(temp != null){
                    if(temp.val < x){
                        dummy1t.next = new ListNode(temp.val);
                        dummy1t = dummy1t.next;
                    }
                    else{
                        dummy2t.next = new ListNode(temp.val);
                        dummy2t = dummy2t.next;
                    }
                    temp = temp.next;
                }
                dummy1t.next = dummy2.next;
                dummy2t.next = null;
                return dummy1.next;
            }
        }
    }

    public static class RemoveCycle {
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        class SLLNode{
            int data;
            SLLNode next;
            SLLNode(int d){
                data = d;
                next = null;
            }
        };

        class BeingZero{
            public void removeCycle(SLLNode A) {
                SLLNode f = A, s = A;
                if(A == null || A.next == null){
                    return;
                }
                while(f != null && f.next != null){
                    f = f.next.next;
                    s = s.next;
                    if(f==s){
                        f = A;
                        while(f != s){
                            f = f.next;
                            s = s.next;
                        }
                        while(f.next != s){
                            f = f.next;
                        }
                        f.next = null;
                    }
                }
            }
        }
    }

    public static class RemoveDuplicatesFromSortedList {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode deleteDuplicates(ListNode head) {
                if(head == null){
                    return head;
                }
                ListNode temp = head.next,prev = head;
                while(temp != null){
                    if(temp.val == prev.val){
                        prev.next = temp.next;
                    }
                    else{
                        prev = prev.next;
                    }
                    temp = temp.next;
                }
                return head;
            }
        }
    }

    public static class RemoveLinkedListElements {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode removeElements(ListNode head, int val) {
                if(head == null){
                    return head;
                }
                if(head.next == null && head.val == val){
                    return null;
                }
                ListNode dummy = new ListNode(-99);
                ListNode dummyt = dummy;
                ListNode temp = head;
                while(temp != null){
                    if(temp.val != val){
                        dummyt.next = new ListNode(temp.val);
                        dummyt = dummyt.next;
                    }
                    temp = temp.next;
                }
                dummyt.next = null;
                return dummy.next;
            }
        }
    }

    public static class RemoveNthNodeFromEnd {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode removeNthFromEnd(ListNode head, int n) {
                if(head == null){
                    return head;
                }
                ListNode temp = head; int count = 0;
                while(temp != null){
                    count++;
                    temp = temp.next;
                }
                ListNode curr = head;
                if(head.next == null && n==1){
                    return null;
                }
                if(count-n <= 0 ){
                    return head.next;
                }
                for(int i=1;i<count-n;i++){
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                return head;
            }
        }
    }

    public static class RotateListRight {
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        class SLLNode{
            int data;
            SLLNode next;
            SLLNode(int d){
                data = d;
                next = null;
            }
        };

        class BeingZero{
            public SLLNode rotateRight(SLLNode head, int k) {
                if(head == null){
                    return head;
                }
                SLLNode temp = head,curr=head;int size=1;
                while(temp.next != null){
                    size++;
                    temp = temp.next;
                }
                k = k%size;
                for(int i=1;i<size-k;i++){
                    curr = curr.next;
                }
                SLLNode x = curr.next;
                curr.next = null;
                temp.next = head;
                return x;
            }
        }
    }

    public static class SortBinaryLL {
        import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

        class SLLNode{
            int data;
            SLLNode next;
            SLLNode(int d){
                data = d;
                next = null;
            }
        };

        class BeingZero{
            public SLLNode solve(SLLNode h) {
                if(h == null){
                    return h;
                }
                SLLNode oneh = new SLLNode(-99);
                SLLNode zeroh = new SLLNode(-99);
                SLLNode  temp = h;
                SLLNode onet = oneh;
                SLLNode zerot = zeroh;
                while(temp != null){
                    if(temp.data != 0){
                        onet.next = temp;
                        onet = onet.next;
                    }
                    else{
                        zerot.next = temp;
                        zerot = zerot.next;
                    }
                    temp = temp.next;
                }
                onet.next = null;
                zerot.next = oneh.next;
                return zeroh.next;
            }
        }
    }

    public static class SwapNodesInPairs {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */
        class Solution {
            public ListNode swapPairs(ListNode head) {
                ListNode dummy = new ListNode(-9);
                dummy.next = head;
                ListNode temp = dummy;
                while(temp.next != null && temp.next.next != null){
                    ListNode prev = temp.next;
                    ListNode curr = temp.next.next;
                    temp.next = curr;
                    prev.next = curr.next;
                    curr.next = prev;
                    temp = temp.next.next;
                }
                return dummy.next;
            }
        }
    }

    public static class SwappingNodesInLL {
        /*
        class ListNode{
            int val = 0;
            ListNode next = null;
        }
        */

        class BeingZero{
            
            ListNode swapNodes(ListNode head , int k){
                // Given head and k. perform swap and return the head node
                ListNode temp = head;
                int size = 0;
                while(temp != null){
                    size++;
                    temp = temp.next;
                }
                temp = head;
                int i = 0;
                int first = 0;
                int last = 0;
                while(temp != null){
                    if(i==k-1){
                        first = temp.val;
                    }
                    if(i == (size-k)){
                        last = temp.val;
                       // break;
                    }
                    temp = temp.next;
                    i++;
                }
                //System.out.println(last);
                //System.out.println(first);
                temp = head;
                i = 0;
                while(temp != null){
                    if(i == k-1){
                        temp.val = last;
                    }
                    if(i == (size-k)){
                        temp.val = first;
                        //break;
                    }
                    temp = temp.next;
                    i++;
                }
                return head;
            }
            
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }
