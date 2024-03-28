import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(bf.readLine());

        // 입력받은 두 수를 StringTokenizer로 분리
        int no1 = Integer.parseInt(swap(tk.nextToken()));
        int no2 = Integer.parseInt(swap(tk.nextToken()));

        if(no1 > no2) {
            System.out.println(no1);
        } else {
            System.out.println(no2);
        }
    }


    // 양 끝 두 글자를 바꾸주는 메소드
    // 결국 세자리수기 때문에 양 끝만 교체해주면 됨.
    public static String swap(String s){
        char[] chars = s.toCharArray();
        char temp = chars[0];
        chars[0] = chars[2];
        chars[2] = temp;
        return new String(chars);
    }
}
