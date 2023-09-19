class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for( int i = triangle.length - 1; i>=1; i-- ){
            for( int j = 0; j < triangle[i].length - 1; j++){
                if ( triangle[i][j] < triangle[i][j+1] ) triangle[i-1][j] += triangle[i][j+1];
                else triangle[i-1][j] += triangle[i][j];
            }
        }
        return triangle[0][0];
    }
}