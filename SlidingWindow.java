import java.util.*;
class BeingZero {

    /* =========SEGMENTS WITH SMALL SUM (Max Length)====================== */
    public int segmentWithSmallSum(int[] arr, int k) {
        long sum = 0;
        int s = 0, length = 0;

        for (int e = 0; e < arr.length; e++) {
            sum += arr[e];

            while (s < arr.length && sum > k) {
                sum -= arr[s++];
            }

            length = Math.max(length, e - s + 1);
        }
        return length;
    }

    /* ================ SEGMENTS WITH BIG SUM (Min Length)==================== */
    public int segmentWithBigSum(int[] arr, int k) {
        long sum = 0;
        int s = 0;
        int length = Integer.MAX_VALUE;

        for (int e = 0; e < arr.length; e++) {
            sum += arr[e];

            while (sum >= k) {
                length = Math.min(length, e - s + 1);
                sum -= arr[s++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    /* ==============NUMBER OF SEGMENTS WITH SMALL SUM=================== */
    public long countSegmentsWithSmallSum(int[] arr, int n, long k) {
        long sum = 0, count = 0;
        int s = 0;

        for (int e = 0; e < n; e++) {
            sum += arr[e];

            while (s < n && sum > k) {
                sum -= arr[s++];
            }

            count += (e - s + 1);
        }
        return count;
    }

    /* ===============NUMBER OF SEGMENTS WITH BIG SUM========================== */
    public long countSegmentsWithBigSum(List<Integer> a, long k) {
        long sum = 0, count = 0;
        int s = 0, n = a.size();

        for (int e = 0; e < n; e++) {
            sum += a.get(e);

            while (s < n && sum >= k) {
                count += (n - e);
                sum -= a.get(s++);
            }
        }
        return count;
    }

    /* ==============LONGEST SUBSTRING WITH AT MOST K DISTINCT CHARS========================== */
    public int longestSubstringAtMostKDistinct(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int s = 0, len = 0;

        for (int e = 0; e < str.length(); e++) {
            char c = str.charAt(e);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char out = str.charAt(s++);
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) map.remove(out);
            }
            len = Math.max(len, e - s + 1);
        }
        return len;
    }

    /* ==============COUNT SUBARRAYS WITH SUM == K===================== */
    private int countAtMost(int[] nums, int k) {
        if (k < 0) return 0;
        int sum = 0, left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }

    public int subarraySumEqualsK(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    /* ==============FIXED WINDOW PROBLEMS================== */

    // Sum of each window of size k
    public void windowSum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];

        System.out.print("Window Sum: " + sum + " ");
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    // Maximum of each window of size k
    public void windowMax(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        System.out.print("Window Max: ");

        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) dq.poll();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
            dq.add(i);

            if (i >= k - 1) System.out.print(arr[dq.peek()] + " ");
        }
        System.out.println();
    }

    // Minimum of each window of size k
    public void windowMin(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        System.out.print("Window Min: ");

        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peek() <= i - k) dq.poll();
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) dq.pollLast();
            dq.add(i);

            if (i >= k - 1) System.out.print(arr[dq.peek()] + " ");
        }
        System.out.println();
    }

    // Count of unique elements in each window of size k
    public void windowUniqueCount(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        System.out.print("Window Unique Count: ");

        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(freq.size() + " ");

        for (int i = k; i < arr.length; i++) {
            int out = arr[i - k];
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) freq.remove(out);

            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            System.out.print(freq.size() + " ");
        }
        System.out.println();
    }
}
