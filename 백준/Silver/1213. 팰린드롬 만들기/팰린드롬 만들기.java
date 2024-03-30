import java.io.*;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] name = bf.readLine().trim().split("");

        Map<String, Long> collect = Arrays.stream(name)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<String> keys = collect.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());;

        int oddCnt = 0;
        String oddStr = "";
        
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if(isOdd.test(collect.get(key))){
                oddCnt++;
                oddStr = key;
            }
            sb.append(key.repeat(collect.get(key).intValue()/2));
        }
        
        if(!validCheck.test(name.length,oddCnt)){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        String normal = sb.toString();
        String reverse = sb.reverse().toString();

        if(oddCnt > 0){
            System.out.println(normal + oddStr + reverse);
        } else {
            System.out.println(normal + reverse);
        }
    }


    private static BiPredicate<Integer,Integer> validCheck = (nameLen, oddCnt) ->
            (nameLen % 2 == 0 && oddCnt == 0) || (nameLen % 2 == 1 && oddCnt == 1);

    private static Predicate<Long> isOdd = (num) -> num % 2 == 1;
}
