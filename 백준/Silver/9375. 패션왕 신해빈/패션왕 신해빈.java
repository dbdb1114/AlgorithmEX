import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 문제
 * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
 * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면,
 * 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
 * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
 *
 * 입력
 * 첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.
 *
 * 각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
 * 다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
 * 모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.
 *
 * 출력
 * 각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int clothCase = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < clothCase; j++) {
                String[] cloth = br.readLine().split(" ");
                map.putIfAbsent(cloth[1], 0);
                map.put(cloth[1], map.get(cloth[1]) + 1);
            }

            if(map.isEmpty()){
                System.out.println(0);
                continue;
            }
            
            int answer = 0;

            if(map.keySet().size()>1){
                int multiply = 1;
                for(String key : map.keySet()){
                    Integer ea = map.get(key) + 1;
                    multiply *= ea;
                }
                answer = multiply - 1;
            } else {
                for(String key : map.keySet()){
                    answer += map.get(key);
                }
            }
            System.out.println(answer);
        }
    }
}
