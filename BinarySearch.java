class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12};
        int key = 8;
        int result = binarySearch(arr, key);
        System.out.println(result);
    }

    // ------------------ ITERATIVE BINARY SEARCH ------------------
    // Returns index of key if found, else -1
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // Search until the range is valid
        while (low <= high) {

            // To avoid overflow
            int mid = low + (high - low) / 2;

            // Key found
            if (arr[mid] == key)
                return mid;

            // Key lies in left half
            else if (key < arr[mid])
                high = mid - 1;

            // Key lies in right half
            else
                low = mid + 1;
        }

        // Key not found
        return -1;
    }

    // ------------------ RECURSIVE BINARY SEARCH ------------------
    static int binarySearchRecursion(int[] arr, int low, int high, int key) {

        // Base case: key not present
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        // Key found
        if (arr[mid] == key)
            return mid;

        // Search left half
        else if (key < arr[mid])
            return binarySearchRecursion(arr, low, mid - 1, key);

        // Search right half
        else
            return binarySearchRecursion(arr, mid + 1, high, key);
    }

    // ------------------ FIND FLOOR VALUE ------------------
    // Floor = greatest element <= key
    static int findFloor(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int floor = -1;   // stores last valid floor

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Possible floor found
            if (arr[mid] <= key) {
                floor = arr[mid];
                low = mid + 1; // try for a greater value
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    // ------------------ FIND CEIL VALUE ------------------
    // Ceil = smallest element >= key
    static int findCeil(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;    // stores last valid ceil

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Possible ceil found
            if (arr[mid] >= key) {
                ceil = arr[mid];
                high = mid - 1; // try for smaller value
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    // ------------------ COUNT NUMBER OF ZEROS ------------------
    // Assumption: all 0s are on the left, all 1s on the right
    static int countZeros(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ZeroIndex = -1; // last index of zero

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 0) {
                ZeroIndex = mid;  // update index
                low = mid + 1;   // search right for more zeros
            } else {
                high = mid - 1;
            }
        }

        // Number of zeros = last zero index + 1
        return ZeroIndex + 1;
    }

    // ------------------ PERFECT SQUARE CHECK USING BINARY SEARCH ------------------
    // Returns true if n is a perfect square
    static boolean sqrt(int n) {

        // 0 and 1 are perfect squares
        if (n == 0 || n == 1)
            return true;

        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid; // prevent overflow

            // Perfect square found
            if (square == n)
                return true;

            if (square < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    // ------------------ SEARCH IN ROTATED SORTED ARRAY ------------------
    static int searchRotatedArray(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Key found
            if (arr[mid] == key)
                return mid;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // Right half is sorted
            else {
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    // ------------------ KOKO EATING BANANAS ------------------
    // Binary Search on Answer
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If Koko can eat at speed mid
            if (canEat(piles, h, mid)) {
                ans = mid;        // store possible answer
                high = mid - 1;   // try slower speed
            } else {
                low = mid + 1;    // need faster speed
            }
        }
        return ans;
    }

    // Checks if Koko can finish eating within h hours at speed k
    public boolean canEat(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil division
        }
        return hours <= h;
    }

    // Finds maximum element in array
    public int getMax(int[] piles) {
        int max = 0;
        for (int p : piles)
            max = Math.max(max, p);
        return max;
    }

    // ------------------ SEARCH IN ROW-WISE SORTED MATRIX ------------------
    static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Apply binary search on each row
        for (int i = 0; i < rows; i++) {
            int low = 0, high = cols - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
