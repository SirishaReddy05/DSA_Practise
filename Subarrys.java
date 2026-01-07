
class Subarrys {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    // Find maximum subarray sum (Kadane’s Algorithm)
    static long maxSubArray(int[] nums) {
        long sum = 0;
        long max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    // Count number of subarrays with sum exactly equal to K
    static int countSubarraysWithSumK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0, count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k))
                count += map.get(prefixSum - k);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    // Find length of longest subarray with sum ≤ K (non-negative elements)
    static int longestSubarray(int[] arr, int k) {
        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left++];
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Static range sum query using prefix sum
    static int rangeSum(int[] arr, int L, int R) {
        int n = arr.length;
        int[] prefix = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        if (L == 0) return prefix[R];
        return prefix[R] - prefix[L - 1];
    }
}
