import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nArr[] = new int[2001];
        sc.nextLine();

        int pos = 1000;
        int start = 2000;
        int end = 0;

        int[] x1 = new int[N];
        int[] x2 = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken());
            String di = st.nextToken();
            int cur = pos;
            // 여기서 연산
            for(int j = 0; j < x; j++){
                if(di.equals("L")){
                    pos--;
                } else {
                    pos++;
                }
            }

            x1[i] = Math.min(cur, pos);
            x2[i] = Math.max(cur, pos);
        }

        // System.out.println(Arrays.toString(x1));
        // System.out.println(Arrays.toString(x2));

        for(int i = 0; i < N; i++)
            for(int j = x1[i]; j < x2[i]; j++)
                nArr[j]++;

        int cnt = 0;
        for(int i = 0; i <= 2000; i++)
            if(nArr[i]>=2)
                cnt++;

        System.out.println(cnt);
    }

}