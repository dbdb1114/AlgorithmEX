import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {
    public static class MyNum{
        public MyNum(long num) {
            this.num = num;
        }

        private Long num;
        
        @Override
        public int hashCode() {
            return Objects.hash(num) * (int) (Math.random() * 1234);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<MyNum> treeSet = new TreeSet<>((a, b)-> {
            int compare = Long.compare(a.num, b.num);
            if(compare != 0){
                return compare * -1;
            } else {
                return 1;
            }
        });

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(bf.readLine());

            for (int j = 0; j < K; j++) {
                StringTokenizer tk = new StringTokenizer(bf.readLine());

                char cal = tk.nextToken().charAt(0);
                long num = Long.parseLong(tk.nextToken());

                if(cal == 'I'){
                    treeSet.add(new MyNum(num));
                } else if(!treeSet.isEmpty() && num == -1) {
                    treeSet.pollLast();
                } else if(!treeSet.isEmpty() && num == 1){
                    treeSet.pollFirst();
                }

            }


            if (treeSet.size() > 1){
                sb.append(treeSet.pollFirst().num + " " + treeSet.pollLast().num);
            } else if (!treeSet.isEmpty()){
                Long poll = treeSet.pollFirst().num;
                sb.append(poll + " " + poll);
            } else {
                sb.append("EMPTY");
            }

            sb.append("\n");
            treeSet.clear();
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
