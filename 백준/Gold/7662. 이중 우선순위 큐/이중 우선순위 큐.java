import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 이중 우선순위 큐(dual priority queue)는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조이다.
 Q에 저장된 각 정수의 값 자체를 우선순위라고 간주하자.

 'I n’은 정수 n을 Q에 삽입하는 연산을 의미
 ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며,
 ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미한다.

 최댓값(최솟값)을 삭제하는 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제됨을 유념하기 바란다.

 만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다.


 각 테스트 데이터에 대해, 모든 연산을 처리한 후 Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라.
 두 값은 한 줄에 출력하되 하나의 공백으로 구분하라. 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.
 * */
public class Main {
    public static class MyNum{
        public MyNum(long num) {
            this.num = num;
        }

        private Long num;

        @Override
        public String toString() {
            return "num = " + num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num) + (int)(Math.random()*1234);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<MyNum> treeSet = new TreeSet<>((a, b)-> {
            int compare = Long.compare(a.num, b.num);
            if(compare != 0){
                return compare * -1;
            } else {
                return 1;
            }
        });
        TreeMap<MyNum,Integer> treeMap = new TreeMap<>();

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bf.readLine());

            for (int j = 0; j < K; j++) {
                StringTokenizer tk = new StringTokenizer(bf.readLine());
                char cal = tk.nextToken().charAt(0);
                long num = Long.parseLong(tk.nextToken());

                if(cal == 'I'){
                    treeSet.add(new MyNum(num));
                } else if(!treeSet.isEmpty() && num == -1) {
                    treeSet.pollLast();
                } else if(!treeSet.isEmpty() && num == 1){
                    treeSet.pollFirst();
                }
            }


            if (treeSet.size() > 1){
                sb.append(treeSet.pollFirst().num + " " + treeSet.pollLast().num);
            } else if (!treeSet.isEmpty()){
                Long poll = treeSet.pollFirst().num;
                sb.append(poll + " " + poll);
            } else {
                sb.append("EMPTY");
            }

            sb.append("\n");
            treeSet.clear();
        }

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
