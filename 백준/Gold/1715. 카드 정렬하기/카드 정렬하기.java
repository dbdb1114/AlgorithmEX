import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;
        Queue<Integer> card = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            card.offer(Integer.parseInt(bufferedReader.readLine()));
        }

        while (card.size() > 1){
            int num1 = card.poll();
            int num2 = card.poll();

            int sum = num1 + num2;
            card.offer(sum); // 정렬된 묶음 카드를 다른 카드와 다시 합치기 위한 과정 
            answer+=sum; // 묶음 카드를 정렬하는데 확인한 횟수를 합하는 과정 
        }

        System.out.println(answer);
    }

}
