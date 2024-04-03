import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     *
     * 첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
     *
     * 테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과,
     * 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)
     *
     * 프린트 과정
     * 1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
     * 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
     * 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
     *
     *  => 만약에, 문서의 중요도가 가장 높지 않다면, poll 해서 add 한다.
     *
     *
     *  접근 방식
     *  1. 우선순위 큐를 만들어서, 해당 큐에 넣어준다.
     *  2. 현재 큐와 우선순위 큐가 같아질 때까지
     *      빼고 뒤로 넣기를 반복한다.
     *
     * */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<String> probQueue = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split(" ");

            int len = Integer.parseInt(s[0]);
            int find = Integer.parseInt(s[1]);

            /**
             * 원래 String 정렬을 쓰면 100이 2앞에 있는
             * 일반적인 정렬이 안 되지만, 현재 문제는
             * 0~9만 주어지므로 상관x
             * */
            String[] queueStr = bf.readLine().split(" ");

            priorityQueue.addAll(List.of(queueStr));
            queueStr[find] = queueStr[find] + "F"; // 색인 남기기
            probQueue.addAll(List.of(queueStr));

            int order = 0;
            int answer = 0;
            
            while(true){
                if(priorityQueue.peek().charAt(0) == probQueue.peek().charAt(0)){
                    priorityQueue.poll();
                    String poll = probQueue.poll();
                    order++;
                    if(poll.charAt(poll.length()-1) == 'F'){
                        answer = order;
                        break;
                    }
                } else {
                    String poll = probQueue.poll();
                    probQueue.add(poll);
                }
            }

            sb.append(answer + "\n");
            probQueue.clear();
            priorityQueue.clear();

        }
        System.out.println(sb);
    }
    
}
