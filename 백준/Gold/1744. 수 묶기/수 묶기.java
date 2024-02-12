import static java.util.stream.Collectors.partitioningBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        PriorityQueue<Integer> plusNumber = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusNumber = new PriorityQueue<>();

        for (int i = 0; i < number; i++) {
            int readNumber =Integer.parseInt(bufferedReader.readLine());
            if( readNumber == 1 ){
                answer += readNumber;
            } else if ( readNumber > 1 ) {
                plusNumber.add(readNumber);
            } else {
                minusNumber.add(readNumber);
            }
        }

        answer += bindNumber(plusNumber);
        answer += bindNumber(minusNumber);

        System.out.println(answer);
    }

    public static int bindNumber(PriorityQueue<Integer> queue){
        int answer = 0;
        while (queue.size()>1){
            answer += queue.poll() * queue.poll();
        }

        if(queue.size() == 1){
            answer += queue.poll();
        }
        return answer;
    }
}
