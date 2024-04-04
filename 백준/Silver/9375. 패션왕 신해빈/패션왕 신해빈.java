import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.

 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다.
 같은 종류의 의상은 하나만 입을 수 있다.

 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.


 Map으로 받아서 카테고리별 갯수를 파악한다.
 key를 재귀함수를 통해 1개일때, 2개일때, 3개일때 -- 모두 곱하여 구한다.
 재귀 함수를 이용한다. DFS

 경우의 수
 ex
 hat headgear
 sunglasses eyewear
 turban headgear
 skirt down

 header - 2
 eyewear - 1
 down - 1

 1 + 1 + 2
 2 * 1 / 2 * 1
 2 * 1 * 1

 {1,1,2}
 DFS ( 1, 0, new int[i], 0, ar );
 DFS(int limit, int depth, int[] case, int st, int[] ar){
    if(depth == limit){
        sum += case;
        break;
    }
    for(i = st ~ ar.length - 1){
        case[depth] = ar[i];
        DFS(limit, depth+1, case, st, ar);
    }
 }


 * */
public class Main {

    static int pactorial(int n){
        // n 개중엔 m개 고르는 것
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    static int nCm(int n, int m){
        return pactorial(n)/(pactorial(m) * pactorial(n-m));
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());

            for (int j = 0; j < N; j++) {
                StringTokenizer s = new StringTokenizer(bf.readLine());
                s.nextToken();
                String key = s.nextToken();
                map.put(key, map.getOrDefault(key,0)+1);   // N
            }
            int sum = map.values().stream().reduce(1,(a, b) -> a * (b + 1)) - 1;
            sb.append(sum + "\n");
            map.clear();
        }
        
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
