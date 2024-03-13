class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] spl = s.split(" ",-1);
        int cnt = 0;

       for(String str : spl){
           for(int i=0; i < str.length(); i++) {

               answer.append( 
                   i % 2 != 0 ?
                       Character.toLowerCase(str.charAt(i)) : 
                   Character.toUpperCase(str.charAt(i)));
           }
           answer.append(" ");
       }
       answer.deleteCharAt(answer.length()-1);
       return answer.toString();
    }
}