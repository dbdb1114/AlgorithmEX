import java.io.*;
import java.util.function.*;

public class Main {

    static int a1;
    static int a0;

    static Function<Integer, Integer> f = (n) -> (a1 * n) + a0;

    static Function<Integer, Integer> g = (n) -> n;

    static BiPredicate<Integer,Integer> result = (c, n) -> f.apply(n) <= (g.apply(n) * c);

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        a1 = Integer.parseInt(s[0]);
        a0 = Integer.parseInt(s[1]);

        int c = Integer.parseInt(bf.readLine());
        int n0 = Integer.parseInt(bf.readLine());

        int answer = result.test(c,n0) && result.test(c,100) ? 1 : 0;
        System.out.println(answer);
    }
}
