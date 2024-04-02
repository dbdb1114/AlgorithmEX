import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        bf.readLine();
        int[] nState = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = Integer.parseInt(bf.readLine());

        for (int i = 0; i < S; i++) {
            StringTokenizer s = new StringTokenizer(bf.readLine());
            if(s.nextToken().equals("1")){
                int cnt = 1;
                int num = Integer.parseInt(s.nextToken());

                while(cnt * num - 1< nState.length){
                    nState[cnt * num - 1] = nState[cnt * num - 1] == 1 ? 0 : 1;
                    cnt++;
                }
            } else {
                int num = Integer.parseInt(s.nextToken()) - 1;
                int st = num - 1;
                int ed = num + 1;

                while(st >= 0 && ed < nState.length){

                    if(nState[st] == nState[ed]){
                        nState[st] = nState[st] == 1 ? 0 : 1;
                        nState[ed] = nState[ed] == 1 ? 0 : 1;
                        st--;
                        ed++;
                    }else {
                        break;
                    }
                }
                nState[num] = nState[num] == 1 ? 0 : 1;
            }
        }

        for (int i = 0; i < nState.length; i++) {
            System.out.print(nState[i] + " ");
            if((i+1) % 20 == 0){
                System.out.println();
            }
        }

    }


}
