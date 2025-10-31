class ApproachOne {
    public int[] getSneakyNumbers(int[] nums) 
    {
         int n = nums.length - 2;

        long sum = 0, squaredSum = 0;
        for (int x : nums) {
            sum += x;
            squaredSum += (long) x * x;
        }

        long expectedSum = (long) n * (n - 1) / 2;
        long expectedSquaredSum = (long) n * (n - 1) * (2L * n - 1) / 6;

        long sumDiff = sum - expectedSum;            // x1 + x2
        long squaredDiff = squaredSum - expectedSquaredSum; // x1² + x2²

        long product = (sumDiff * sumDiff - squaredDiff) / 2; // x1 * x2

        double discriminant = Math.sqrt(sumDiff * sumDiff - 4.0 * product);

        int x1 = (int) ((sumDiff + discriminant) / 2);
        int x2 = (int) ((sumDiff - discriminant) / 2);

        return new int[]{x1, x2};
    }
}