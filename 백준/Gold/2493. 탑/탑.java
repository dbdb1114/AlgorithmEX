import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] answer = new int[N];
        int[] nArr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer,Integer> indexStore = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            nArr[i] = key;
            indexStore.put(key, i);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nArr.length; i++) {
            int tower = nArr[i];
            while (!stack.isEmpty() && stack.peek() < tower){
                Integer pop = stack.pop();
                if(!stack.isEmpty()){
                    answer[indexStore.get(pop)] = indexStore.get(stack.peek()) + 1;
                } else {
                    answer[indexStore.get(pop)] = 0;
                }
            }
            stack.push(nArr[i]);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if(!stack.isEmpty()){
                answer[indexStore.get(pop)] = indexStore.get(stack.peek())+1;
            } else {
                answer[indexStore.get(pop)] = 0;
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}
