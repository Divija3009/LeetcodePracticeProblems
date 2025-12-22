class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        for (int j = 0; j < cols; j++) {          // column
            for (int i = 1; i < rows; i++) {      // row
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    count++;
                    break; // stop checking this column
                }
            }
        }
        return count;
    }
}