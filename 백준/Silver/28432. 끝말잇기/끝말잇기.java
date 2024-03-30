import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Set<String> dist = new HashSet<>();
        String[] words = new String[N];
        int idx = 0; // 채워넣을 인덱스

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            words[i] = s;
            dist.add(s);
            if(s.equals("?")){
                idx = i;
            }
        }

        int M = Integer.parseInt(bf.readLine());
        String answer = "";

        for (int i = 0; i < M; i++) {
            String target = bf.readLine();

            if (isValid(dist, words, target, idx)){
                answer = target;
            }
        }

        System.out.println(answer);
    }

    private static boolean isValid (Set<String> set, String[] words, String target, int idx) {
        if(words.length == 1) {
            return true;
        }
        if(isDist(set, target)){
            return false;
        }

        if(idx == 0){
            return isNext(words[idx+1],target);
        }
        if(idx == words.length - 1){
            return isPre(words[idx-1],target);
        }
        return  isNext(words[idx+1],target) && isPre(words[idx-1],target);
    }

    private static boolean isDist(Set<String> set, String target){
        return set.contains(target);
    }

    private static boolean isPre(String prev, String target){
        return prev.charAt(prev.length()-1) == target.charAt(0);
    }

    private static boolean isNext(String next, String now){
        return now.charAt(now.length()-1) == next.charAt(0);
    }
}
