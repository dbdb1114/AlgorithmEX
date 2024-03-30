import java.io.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String S = bf.readLine();
        String Pn = P.apply(N);

        int answer = 0;

        int st = 0;
        int ed = st + Pn.length() - 1;

        StringBuilder find = new StringBuilder();
        find.append(' ');
        find.append(S.substring(st,ed));

        while (ed < M){
            find.delete(0,1);
            find.append(S.charAt(ed));

            if(find.toString().equals(Pn)){
                answer++;
            }

            st++;
            ed++;
        }

        System.out.println(answer);
    }


    static Function<Integer,String> P = N -> {
        StringBuilder sb = new StringBuilder();
        IntStream.range(1, 2 * N + 2)
                .forEach(x-> sb.append( x % 2 == 1 ? "I" : "O") );
        return sb.toString();
    };
}
