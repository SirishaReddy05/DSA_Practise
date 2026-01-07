import java.util.*;
class BeingZero {

    /* ===============TWO SUM============== */
    public int[] twoSum(int[] a, int n, int k) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rem = k - a[i];
            if (map.containsKey(rem)) {
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }
            map.put(a[i], i);
        }
        return ans;
    }
       /* ===============SQUARES OF A SORTED ARRAY============== */
       
    public long[] sortedSquares(int[] a, int n) {
        long[] ans = new long[n];
        int i = 0, j = n - 1, k = n - 1;

        while (i <= j) {
            long left = (long) a[i] * a[i];
            long right = (long) a[j] * a[j];

            if (left >= right) {
                ans[k--] = left;
                i++;
            } else {
                ans[k--] = right;
                j--;
            }
        }
        return ans;
    }

    /* =============INTERSECTION OF TWO SORTED ARRAYS===================== */
    public List<Integer> intersectionOfTwoArrays(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).equals(b.get(j))) {
                // Avoid duplicates
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(a.get(i))) {
                    ans.add(a.get(i));
                }
                i++;
                j++;
            } else if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    /* ==============UNION OF TWO SORTED ARRAYS==================== */
    public List<Integer> unionOfTwoArrays(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(a.get(i))) {
                    ans.add(a.get(i));
                }
                i++;
            } else {
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(b.get(j))) {
                    ans.add(b.get(j));
                }
                j++;
            }
        }

        // Remaining elements
        while (i < a.size()) {
            if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(a.get(i))) {
                ans.add(a.get(i));
            }
            i++;
        }

        while (j < b.size()) {
            if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(b.get(j))) {
                ans.add(b.get(j));
            }
            j++;
        }

        return ans;
    }

    /* ============== DIFFERENCE OF TWO SORTED ARRAYS (A - B)========================= */
    public int[] differenceOfTwoArrays(int m, int[] a, int n, int[] b) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) {
                list.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
                j++;
            }
        }

        // Remaining elements of A
        while (i < m) {
            list.add(a[i]);
            i++;
        }

        // Convert List to array
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}
