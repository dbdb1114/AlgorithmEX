class Solution {
    public String solution(String s, int n) {
        
        SizerPassword sizPW = new SizerPassword(s);
        sizPW.updatePW(n);
        
        String answer = sizPW.getPassword();
        return answer;
    }
}

class SizerPassword {

    static final int lowwerCaseSt = 'a';
    static final int lowwerCaseEd = 'z';

    static final int upperCaseSt = 'A';
    static final int upperCaseEd = 'Z';
    
    private String password;
    
    public SizerPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void updatePW(int num){
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.password.length(); i++){
            
            char ch = this.password.charAt(i);
            
            if(!isDash(ch)){
                sb.append(push(ch,num));
            } else {
                sb.append(ch);
            }
        }
        this.password = sb.toString();
    }
    
    public char push(char ch ,int num){
        
        int stLimit = lowwerCaseSt;
        int edLimit = lowwerCaseEd;
        
        if(isUpperCase(ch)){
            stLimit = upperCaseSt;
            edLimit = upperCaseEd;
        }
        
        if(ch + num <= edLimit){
            return (char) (ch + num);
        } else {
            return (char) (stLimit + num - (edLimit - ch) - 1);
        }
        
    }
    
    public boolean isUpperCase(char ch){
        return upperCaseSt <= ch && ch <= upperCaseEd;
    }

    public boolean isDash(char ch){
        return ch == ' ';
    }
}