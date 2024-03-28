import java.io.*;
import java.util.*;

//이 머리로 공부를 하지 세준아
public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(bf.readLine());

        // 입력받은 문자열을 공백 단위로 나눠주고,
        // mapToDouble 메소드를 이용하여 원소를 double로 바꿔줍니다.
        // 마지막으로 정렬시키고, 배열로 만들어줍니다.
        double[] score = Arrays.stream(bf.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();

        // 정렬된 점수 배열을 스트림으로 만들고,
        // map을 통해 최고점으로 나누고, 100을 곱합니다.
        // 마지막으로 집계함수를 이용하여 평균을 내어줍니다.
        double average = Arrays.stream(score)
                .map(x ->(x / score[N - 1]) * 100)
                .average().getAsDouble();

        System.out.println(average);
    }
}
