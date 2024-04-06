import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
/**
김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다.
 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다.
 게임 횟수 : X
 이긴 게임 : Y (Z%)
 Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.

 X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.
 */


    static long X;
    static long Y;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(bf.readLine());

        X = Long.parseLong(tk.nextToken());
        Y = Long.parseLong(tk.nextToken());

        if (X == Y){
            System.out.println(-1);
            return;
        }

        long answer = binarySearch(0, X, X/2, Y*100/X);
        System.out.println(answer == 0 ? -1 : answer);
    }


    public static long binarySearch(long lt, long rt, long mid, long tar){
        long percent = (Y+mid)*100/(X+mid);
        if(lt > rt){
            return result;
        }
        if(percent > tar){
            result = mid;
        }

        if(percent <= tar){
            return binarySearch(mid+1, rt, (mid + 1 + rt)/2, tar);
        } else {
            return binarySearch(lt, mid-1, (mid - 1 + lt)/2, tar);
        }
    }

}
