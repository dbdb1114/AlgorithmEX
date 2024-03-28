import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws Exception{
        String str = bf.readLine();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                set.add(str.substring(i,j));
            }
        }

        System.out.println(set.size());
    }
}
