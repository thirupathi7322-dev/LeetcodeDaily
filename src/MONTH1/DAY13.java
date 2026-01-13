class Solution {
    public double separateSquares(int[][] squares) {
        // since we have to draw horizontal line we have to play with y axis;
        double low = 0.0;
        double high = 0.0;

        for(int i = 0; i < squares.length; i++){
            low = Math.min(low,squares[i][1]);
            high = Math.max(high,squares[i][1] + squares[i][2]);
        }

        while(high-low > (1e-5)){
            double mid = (low + high) / 2;

            // divide the area on the basis of mid line and check the diff
            double diffInArea = divideArea(mid,squares);

            // if diff in areas is greater than 0 then we have to search for line above mid
            if(diffInArea > 0.0){
                low = mid;
            }else{
                high = mid;
            }
        }

        return high;
    }

    double divideArea(double midLine, int[][] matrix){
        double lowerArea = 0.0;
        double upperArea = 0.0;

        for(int i = 0; i < matrix.length; i++){
            int y = matrix[i][1];
            int sides = matrix[i][2];
            double area = (double) sides * sides;
            
            // lets determine where this area will lie basis of mid line
            if(midLine <= y){
                upperArea += area;
            }else if(midLine >= y+sides){
                lowerArea += area;
            }else{
                double upperLength = (y + sides) - midLine;
                double lowerLength = midLine - y;

                upperArea += upperLength * sides;
                lowerArea += lowerLength * sides;
            }
        }

        return (double) (upperArea - lowerArea);
    }
}