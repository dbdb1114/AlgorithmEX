class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int wordPointer = 1;
        int totPointer = 0;
        
        while(totPointer < s.length()){
            
            char target = s.charAt(totPointer);
            
            if(isSpace(target)){
                totPointer++; 
                wordPointer = 1;
                sb.append(' ');
                continue;
            }
            
            if(isOdd(wordPointer)){
                sb.append(Character.toUpperCase(target));
            } else {
                sb.append(Character.toLowerCase(target));
            }
            
            totPointer++; 
            wordPointer++;
        }
        
        return sb.toString();
    }
    
    public boolean isSpace(char ch){
        return ch == ' ';
    }
    
    public boolean isOdd(int num){
        return num % 2 == 1;
    }
}