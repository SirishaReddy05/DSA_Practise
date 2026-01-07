import java.util.*;

class Map {

    // Find indices of two numbers whose sum equals target
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need))
                return new int[]{map.get(need), i};

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Count frequency of elements in an array
    static HashMap<Integer, Integer> frequencyOfElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        return map;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));

        int[] freqArr = {1, 2, 2, 3, 3, 3};
        System.out.println(frequencyOfElements(freqArr));
    }
}
