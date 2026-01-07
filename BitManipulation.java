
class BitManipulation {

    public static void main(String[] args) {

        System.out.println(decimalToBinary(13));
        System.out.println(reverseBits(3));
        System.out.println(isPowerOfTwo(16));
        System.out.println(checkKthBit(5, 0));
        System.out.println(toggleKthBit(5, 1));
    }

    // 1. Decimal to Binary
    static String decimalToBinary(long n) {
        if (n == 0) return "0";

        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append(n & 1);   // extract LSB
            n >>= 1;
        }
        return ans.reverse().toString();
    }

    // 2. Reverse Bits (32-bit)
    static long reverseBits(int n) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (n & 1);
            n >>= 1;
        }
        return ans;
    }

    // 3. Swap alternate bits
    static int swapBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i += 2) {
            int bit1 = (n >> i) & 1;
            int bit2 = (n >> (i + 1)) & 1;
            ans |= (bit1 << (i + 1));
            ans |= (bit2 << i);
        }
        return ans;
    }

    // 4. Count set bits
    static int countSetBits(long n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    // 5. Check power of 2
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 6. Check Kth bit
    static boolean checkKthBit(int N, int K) {
        return ((N >> K) & 1) != 0;
    }

    // 7. Set Kth bit
    static int setKthBit(int N, int K) {
        return N | (1 << K);
    }

    // 8. Clear Kth bit
    static int clearKthBit(int N, int K) {
        return N & ~(1 << K);
    }

    // 9. Toggle / Flip Kth bit
    static int toggleKthBit(int N, int K) {
        return N ^ (1 << K);
    }

    // 10. Generate all subsets
    static List<List<Integer>> generateAllSubsets(List<Integer> nums) {
        int n = nums.size();
        int total = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    subset.add(nums.get(i));
            }
            ans.add(subset);
        }
        return ans;
    }

    // 11. Binary Exponentiation
    static long modularExponentiation(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    // 12. Missing and Repeating Number
    static void findMissingAndRepeating(int[] arr, int n) {

        int xor = 0;
        for (int num : arr) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;

        int setBit = xor & (-xor);
        int x = 0, y = 0;

        for (int num : arr) {
            if ((num & setBit) != 0) x ^= num;
            else y ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) x ^= i;
            else y ^= i;
        }

        for (int num : arr) {
            if (num == x) {
                System.out.println("Repeating: " + x + ", Missing: " + y);
                return;
            }
        }
        System.out.println("Repeating: " + y + ", Missing: " + x);
    }

    // 13. Unique number when every number repeats 5 times
    static int uniqueInFive(int[] a) {
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : a) {
                if ((num & (1 << bit)) != 0)
                    count++;
            }
            if (count % 5 != 0)
                ans |= (1 << bit);
        }
        return ans;
    }

    // 14. Finding Akela (XOR method)
    static long findAkela(int[] A) {
        long x = 0;
        for (int ele : A)
            x ^= ele;
        return x;
    }

    // 15. Triplet Trouble (every number appears 3 times except one)
    static int findUniqueTriplet(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0)
                    sum++;
            }
            if (sum % 3 != 0)
                result |= (1 << i);
        }
        return result;
    }
}
