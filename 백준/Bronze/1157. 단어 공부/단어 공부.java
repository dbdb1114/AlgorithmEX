import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        char[] charAr = bf.readLine().toUpperCase().toCharArray();
        Arrays.sort(charAr);

        char maxChar = charAr[0];
        int maxNum = 0;

        char opChar = charAr[0];
        int opNum = 0;

        for (char c : charAr) {

            if(opChar == c){
                opNum++;
                continue;
            }


            if(maxNum < opNum){
                maxNum = opNum;
                maxChar = opChar;
            } else if (maxNum == opNum) {
                maxChar = '?';
            }

            opChar = c;
            opNum = 1;
        }

        if(maxNum < opNum){
            maxChar = opChar;
        }
        if (maxNum == opNum) {
            maxChar = '?';
        }

        System.out.println(maxChar);
    }
}
