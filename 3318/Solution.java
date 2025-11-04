import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int windows = n - k + 1;
        int[] answer = new int[windows];

        for (int i = 0; i < windows; ++i) {
            // Build frequency map for window [i .. i + k - 1]
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; ++j) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Sort entries by (count desc), then (value desc)
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freq.entrySet());
            Collections.sort(entries, (a, b) -> 
            {
                int cmp = Integer.compare(b.getValue(), a.getValue()); // sort by count desc
                if (cmp != 0) return cmp;
                return Integer.compare(b.getKey(), a.getKey());        // if tie, sort by key desc
            });

            // Take top x and compute sum(value * count)
            long sum = 0;
            int take = Math.min(x, entries.size());
            for (int t = 0; t < take; ++t) {
                Map.Entry<Integer, Integer> e = entries.get(t);
                sum += (long) e.getKey() * e.getValue();
            }
            answer[i] = (int) sum; // problem expects int
        }

        return answer;
    }
}
