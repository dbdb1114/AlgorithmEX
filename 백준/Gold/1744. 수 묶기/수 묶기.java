import static java.util.stream.Collectors.partitioningBy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        Map<Boolean, List<Integer>> listMap = numbers.stream().collect(partitioningBy(x -> x > 0));

        List<Integer> plusNumber = listMap.get(true);
        List<Integer> minusNumber = listMap.get(false);

        plusNumber.sort(Comparator.reverseOrder());
        minusNumber.sort(Comparator.naturalOrder());

        for (int i = 0; i < plusNumber.size(); i+=2) {
            try {
                answer += multipleNumber(plusNumber.get(i) , plusNumber.get(i+1));
            }catch (IndexOutOfBoundsException e ){
                answer += plusNumber.get(i);
            }
        }

        for (int i = 0; i < minusNumber.size(); i+=2) {
            try {
                answer += minusNumber.get(i) * minusNumber.get(i+1);
            }catch (IndexOutOfBoundsException e ){
                answer += minusNumber.get(i);
            }
        }

        System.out.println(answer);
    }

    public static int multipleNumber (int num1, int num2){
        boolean isBig = num1 * num2 > num1 + num2;
        if(isBig){
            return num1 * num2;
        } else {
            return num1 + num2;
        }
    }
}
