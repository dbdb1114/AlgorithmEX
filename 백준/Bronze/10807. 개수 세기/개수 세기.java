import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static int getInteger() throws IOException{
        return Integer.parseInt(bf.readLine());
    }

    public static int[] getIntegerArr() throws IOException{
        return Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {

        int N = getInteger();
        int[] nArr = getIntegerArr();
        int V = getInteger();

        long res = Arrays.stream(nArr).filter(x->x==V).count();
        System.out.println(res);
    }
}
