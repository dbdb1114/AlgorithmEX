import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Main {
      public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int count = 0;
        String tree = bf.readLine();

        while(tree != null && !tree.equals("")){
            treeMap.put(tree, treeMap.getOrDefault(tree,0) +1);
            count++;
            tree = bf.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int finalCount = count;
        treeMap.keySet().stream()
                .forEach(x->{
                    sb.append(x + " ");
                    sb.append(String.format("%.4f",((treeMap.get(x) / (double)finalCount) * 100)));
                    sb.append("\n");
                });
        System.out.println(sb);
    }
}
