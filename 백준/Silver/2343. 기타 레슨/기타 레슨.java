import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lesson = firstLine[0];
        int blulay = firstLine[1];

        int[] videoArr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int videoAverage = Arrays.stream(videoArr).sum()/blulay;


        int size = videoAverage;
        int j = -1;

        while (true){

            for (int i = 0; i < blulay; i++){

                int length = 0;
                while (length < size && j < videoArr.length - 1){
                    j++;
                    length += videoArr[j];
                }

                if(length > size){
                    j--;
                }
            }

            if(j == videoArr.length - 1){
                break;
            } else {
                j = -1;
                size++;
            }
            
        }

        System.out.println(size);
    }
}
