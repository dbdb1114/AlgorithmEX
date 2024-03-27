import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<String> set = new HashSet();
        for (int i = 0; i < N; i++) {
            String name = bf.readLine().split(" ")[0];
            if(set.contains(name)){
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        set.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
