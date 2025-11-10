import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public int minOperations(int[] nums) 
    {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        int n = nums.length;
        int ops = 0;

        for (int target : unique) {
            if (target == 0) continue;

            boolean flow = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    if (!flow) {
                        flow = true;
                        ops++;
                    }
                } else if (nums[i] < target) {
                    flow = false;
                }
            }
        }

        return ops;
    }
}