import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        char[] charAr = bf.readLine().toUpperCase().toCharArray();
        Arrays.sort(charAr);

        // 가장 많은 문자애 대한 저장
        char maxChar = charAr[0];
        int maxNum = 0;

        // 탐색하며 비교할 문자를 저장
        char opChar = charAr[0];
        int opNum = 0;

        // 풀이 의도
        // 정렬시켜 같은 문자는 연속으로 나오는 것을 이용하여
        // 선형탐색하며 연속되는 문자의 갯수를 파악하고,
        // 가장 많은 문자의 수와 비교하고 초기화한다.
        for (char c : charAr) {

            // 같은 문자가 나오는 동안
            // 비교대상 문자의 갯수를 기록하고,
            // 다른 문자가 나올 때까지 다음 반복으로 넘어간다.
            if(opChar == c){
                opNum++;
                continue;
            }


            if(maxNum < opNum){
                // 탐색하며 저장한
                // 최대 문자의 수가
                // 현재까지 탐색한 문자의 수보다 작을 때
                maxNum = opNum;
                maxChar = opChar;
            } else if (maxNum == opNum) {
                // 최대 문자의 수와
                // 현재까지 탐색한 문자의 수가 같을 때
                maxChar = '?';
            }

            // 이미 탐색이 끝난 뒤 새로운
            // 문자가 나왔으므로 다음 탐색을 위해 초기화한다.
            opChar = c;
            opNum = 1;
        }

        // 반복문 내의 내용과 같은데
        // 마지막 문자까지 연속된 문자가 나왔을 경우
        // maxNum과 비교후 초기화할 수 없으므로,
        // 반복이 끝난뒤 한 번 더 비교하고 초기화한다.
        if(maxNum < opNum){
            maxChar = opChar;
        }
        if (maxNum == opNum) {
            maxChar = '?';
        }

        System.out.println(maxChar);
    }
}
