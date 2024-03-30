import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tot = Arrays.stream(bf.readLine().split(" "))
                .filter(x->x.length()>0)
                .mapToInt(Integer::parseInt).sum();


        Set<String> set = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < tot; i++) {
            String name = bf.readLine().trim();
            if(set.contains(name)){
                cnt++;
                answer.add(name);
            } else {
                set.add(name);
            }
        }

        System.out.println(cnt);
        answer.stream().sorted().forEach(System.out::println);
    }
}
