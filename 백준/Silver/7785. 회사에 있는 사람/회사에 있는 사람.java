import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        SortedSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            String name = bf.readLine().split(" ")[0];
            if(set.contains(name)){
                set.remove(name);
            } else {
                set.add(name);
            }
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
