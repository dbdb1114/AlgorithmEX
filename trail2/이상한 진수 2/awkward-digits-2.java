import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int answer = 0;
        // System.out.println(n.indexOf("0"));
        if(n.indexOf("0") >= 0) {
            int index = n.indexOf("0");
            for(int i = 0; i < n.length(); i++){
                if(i == index || n.charAt(i) == '1'){
                    answer += Math.pow(2,n.length()-1-i);
                }
            }
        } else {
            int index = n.length()-1;
            for(int i = 0; i < n.length(); i++){
                if(i != index){
                    answer += Math.pow(2,n.length()-1-i);
                }
            }
        }
        System.out.println(answer);
    }
}