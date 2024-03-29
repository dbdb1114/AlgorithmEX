import java.io.*;
import java.util.*;

public class Main {
    /**
     * Enter 단위로
     * set에 있는지 없는지 체크후
     *  없다면, 추가 및 카운팅
     *  있다면, 패스
     * */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Set set = new HashSet();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();

            if(s.equals("ENTER")){
                set.clear();
                continue;
            }

            if(!set.contains(s)){
                set.add(s);
                ans++;
            }
        }

        System.out.println(ans);
    }
}
