class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int center = s.length()/2-1;
        if(s.length() % 2 == 0){
            sb.append(s.charAt(center));
        }
        sb.append(s.charAt(center+1));
        return new String(sb);
    }
}