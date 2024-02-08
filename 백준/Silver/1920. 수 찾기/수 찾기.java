import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Arrays;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] Narr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(bufferedReader.readLine());
        int[] Marr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(Narr);
        
        for (int i = 0; i < M; i++) {
            int find = Marr[i];
            System.out.println(binarySearch(Narr, find, 0, N - 1));
        }
        
    }
    
    public static int binarySearch(int[]arr, int find, int start, int end) {
        if(start > end) return 0;

        int mid = start + (end - start)/2;

        if(arr[mid] == find) {
            return 1;
        }

        if( arr[mid] < find ) {
            return binarySearch(arr, find, mid+1 , end);
        } else {
            return binarySearch(arr, find, start , mid-1);
        }

    }
}
