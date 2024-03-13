class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int i = 0; i < sizes.length; i++){
            
            int longLen = Math.max(sizes[i][0],sizes[i][1]);
            int shortLen = Math.min(sizes[i][0],sizes[i][1]);
            
            if(longLen > width){
                width = longLen;
            }
            
            if(shortLen > height){
                height = shortLen;
            }
        }
        
        return width * height;
    }
}