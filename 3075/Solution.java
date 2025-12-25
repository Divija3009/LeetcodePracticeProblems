import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Integer[] arr = Arrays.stream(happiness)
                              .boxed()
                              .toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int val = arr[i] - i;
            if (val > 0) 
            {
                ans += val;
            }
        }
        return ans;
    }
}