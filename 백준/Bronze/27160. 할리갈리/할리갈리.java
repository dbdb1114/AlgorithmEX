import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    /**
     * 과일을 ENUM으로 선언하여,
     * 과일과 갯수가 나왔을 때마다 증가시켜주는 함수와
     * 다섯개인지 확인해주는 함수를 작성
     * */
    enum Fruit {
        STRAWBERRY, BANANA, LIME, PLUM;

        int cnt = 0;
        void addCnt(int cnt){
            this.cnt += cnt;
        }

        boolean isFive(){
            return this.cnt == 5;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = valueOf(bf.readLine()); // 카드 제시 횟수
        
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(bf.readLine());
            
            // 입력받은 과일과 갯수를 tokenizer로 분리 
            String fruit = tk.nextToken();
            int num = valueOf(tk.nextToken());

            // 해당 열거형 타입에 addCnt함수를 통해 갯수 최신화
            Fruit.valueOf(fruit).addCnt(num);
        }

        // 다섯개인 열거형이 있는지 확인
        boolean isClap = Arrays.stream(Fruit.values()).anyMatch(fruit -> fruit.isFive());
        System.out.println(isClap ? "YES" : "NO");
    }
}
