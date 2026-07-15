import java.util.*;


public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] x1 = new int[1000];
        int[] x2 = new int[1000];
        int[] x3 = new int[1000];
        int[] check = new int[100_001];

        int cur = 50_001;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken());
            String di = st.nextToken();
            
            if(di.equals("L")) {
                for(int j = 0; j < x; j++){
                    check[cur--] = 1;
                }
                cur++;
            } else {
                for(int j = 0; j < x; j++){
                    check[cur++] = 2;
                }
                cur--;
            }
        }

        int white = 0;
        int black = 0;
        for(int i = 0; i < check.length; i++){
            if(check[i] == 1){
                white++;
            } else if (check[i] == 2) {
                black++;
            }
        }
        System.out.println(white + " " + black);
    }
}