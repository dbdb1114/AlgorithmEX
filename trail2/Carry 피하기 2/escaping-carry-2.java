import java.util.*;

public class Main {
    static int[] target = new int[3];
    static int[] arr;
    
    static int N;
    static int answer;
    static int countTarget = 0;
    public static void main(String[] args) {
        // Please write your code here.
        // N개의 수 => 그 중 서로 다른 3개의 수 
        // carry가 발생하지 않으면서 나올 수 있는 수의 합의 최대값

        // carry란? 수와 수를 더했을 때, 10의 자리를 넘기는 것 
        // carry가 없는 수 중 최대값 
        // carry가 아닌 수를 Math.max() 하면 될 듯 
        // carry를 걸러주면 되는데 3개를 골랐을 때 
        // 각 자리 수의 합이 10을 안 넘으면 되는 거니까 각 자리수 별로 분해해서 carry를 체크하면 될 듯 

        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        for(int i = 0; i < N; i++) {
            target[0] = arr[i];
            recursive(i,1);
        }
        
        if(answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void recursive(int now, int count) {
        if(count == 3) {
            countTarget++;
            if(!isCarry()) {
                int sum = target[0] + target[1] + target[2];
                // System.out.println(Arrays.toString(target) + " : " + sum);
                answer = Math.max(answer, sum);
            }
            return ;
        }

        for(int i = now+1; i < N; i++) {
            target[count] = arr[i];
            recursive(i, count+1);
        }

    }

    static boolean isCarry() {
        int[] temp = {target[0],target[1],target[2]};
        for(int i = 4; i >= 0; i--){
            int sum = 0;
            for(int j = 0; j < 3; j++) {
                int num = temp[j]/((int)Math.pow(10, i));
                sum += num;
                temp[j] -= num * ((int)Math.pow(10, i));
            }
            if(sum >= 10) {
                // System.out.println("탈락 : " + Arrays.toString(target));
                return true;
            }
        }

        return false;
    }
}