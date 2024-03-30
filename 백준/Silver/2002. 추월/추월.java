import java.io.*;
import java.util.*;
/**
 *
 * 각각 배열에 포지션 변수를 두고
 * 동시에 움직이면서, 체크를 하면 어떨까
 *
 * while(st < len && ed < len) {
 *     if (st == ed){
 *       st++;
 *       ed++;
 *     } else if ( set.contains(st) ) {
 *       st++;
 *     } else {
 *       추월SET.add(ed)
 *       ed++;
 *     }
 * }
 *
 * */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] start = new String[N];
        for (int i = 0; i < N; i++) {
            start[i] = bf.readLine();
        }

        String[] end = new String[N];
        for (int i = 0; i < N; i++) {
            end[i] = bf.readLine();
        }

        int st = 0;
        int ed = 0;

        Set<String> overSpeed = new HashSet<>();
        while (st < start.length && ed < end.length) {

            String stCar = start[st];
            String edCar = end[ed];

            if(stCar.equals(edCar)){
                st++;
                ed++;
            } else if (overSpeed.contains(stCar)){
                st++;
            } else {
                overSpeed.add(edCar);
                ed++;
            }
        }

        System.out.println(overSpeed.size());
    }
}
