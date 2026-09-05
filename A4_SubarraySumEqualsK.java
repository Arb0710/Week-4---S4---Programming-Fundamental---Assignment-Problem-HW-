import java.util.HashMap;
import java.util.Map;

public class A4_SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: prefix sum of 0 appears once before processing any elements
        prefixSumCounts.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in the map, add its frequency to count
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println(subarraySum(new int[] { 1, -1, 0 }, 0));
    }
}
