import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        for(int i = 0; i < N; i++){
            ar[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for(int i = N-2; i >= 0; i--){
            while(ar[i] >= ar[i+1]){
                ar[i]--;
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}