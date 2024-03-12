class Solution {
    public boolean solution(String s) {
        return isFourOrSix(s) && isAllDigit(s);
    }
    
    public boolean isFourOrSix(String s){
        int len = s.length();
        return len == 4 || len == 6;
    }
    
    public boolean isAllDigit(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65){
                return false;
            }
        }
        return true;
    }
}