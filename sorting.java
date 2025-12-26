class sorting {
    static int[] nums;
    public sorting() {
        nums = new int[]{3,6,4,1,8,4,9,4,6,9};
    }

    public static void main(String[] args) {
        new sorting();   
        int n = nums.length;
        selectionSort(n);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    // ===================== BUBBLE SORT =====================
    // Repeatedly compares adjacent elements and swaps them
    // Time: O(n^2), Space: O(1)
    public static void bubbleSort(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // ===================== INSERTION SORT =====================
    // Builds sorted array one element at a time
    // Time: O(n^2), Space: O(1)
    public static void insertionSort(int n) {
        for (int i = 1; i < n; i++) {
            int key = nums[i];   // current element
            int j = i - 1;
            // Shift elements greater than key to the right
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    // ===================== SELECTION SORT =====================
    // Selects minimum element and places it at correct position
    // Time: O(n^2), Space: O(1)
    public static void selectionSort(int n) {
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            // Find minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap minimum with current index
            swap(min_idx, i);
        }
    }

    // Utility method to swap elements in array
    public static void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // ===================== MERGE SORT =====================
    // Divide and conquer algorithm
    // Time: O(n log n), Space: O(n)
    public static void divide(int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        // Divide left and right halves
        divide(low, mid);
        divide(mid + 1, high);
        // Merge sorted halves
        merge(low, mid, high);
    }
    public static void merge(int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        // Merge two sorted halves
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        // Copy temp array back to nums
        k = 0;
        for (int idx = low; idx <= high; idx++) {
            nums[idx] = temp[k++];
        }
    }

    // ===================== QUICK SORT =====================
    // Divide and conquer using pivot
    // Average: O(n log n), Worst: O(n^2), Space: O(log n)
    static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            // Recursively sort partitions
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }
    static int partition(int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        // Rearrange elements around pivot
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // ===================== HEAP SORT =====================
    // Uses max heap to sort array
    // Time: O(n log n), Space: O(1)
    static void heapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1; // left child
        int r = 2 * i + 2; // right child
        if (l < n && nums[l] > nums[largest])
            largest = l;
        if (r < n && nums[r] > nums[largest])
            largest = r;
        // If root is not largest, swap and heapify
        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }
    static void heapSort(int n) {
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            swap(i, 0);
            heapify(i, 0);
        }
    }
}
