//Approach (Binary search on answer)
//T.C : O(n * log(range)), range = max (y+side) value - min y value
//S.C : O(1)
class Solution {

    private boolean check(int[][] squares, double midY, double total) {
        double bottomArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if (midY >= topY) {
                // full square below
                bottomArea += l * l;
            } else if (midY > bottomY) {
                // partial square below
                bottomArea += (midY - bottomY) * l;
            }
        }

        return bottomArea >= total / 2.0; //Is bottom area more than above ?
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;
        //calculate low, high of binary search and also total area
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];

            total += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double resultY = 0.0;
        //high and low is acceptable 10 to the power -5
        while (high - low > 1e-5) {
            double midY = low + (high - low) / 2.0;
            resultY = midY;

            if (check(squares, midY, total)) {
                // bottom area is more than half, move down
                //its not high= mid-1 beacuse for 1 the precision will change drastically so direct assign to midy
                high = midY;
            } else {
                low = midY;
            }
        }

        return resultY;
    }
}