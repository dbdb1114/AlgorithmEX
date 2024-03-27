import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer[]> hexagon = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bf.readLine(), " ");

            int direct = Integer.parseInt(tokenizer.nextToken());
            int distance = Integer.parseInt(tokenizer.nextToken());

            Integer[] dire = {direct, distance};
            hexagon.add(dire);
        }

        int smallSquare = 0;
        int bigSquare = 0;

        for (int i = 0; i < hexagon.size(); i++) {
            
            int onePrev = prevIdx(hexagon,i,1);
            int twoPrev = prevIdx(hexagon,i,2);
            int threePrev = prevIdx(hexagon,i,3);
            
            if(hexagon.get(i)[0] == hexagon.get(twoPrev)[0]
                    && hexagon.get(onePrev)[0] == hexagon.get(threePrev)[0]){
                
                smallSquare = hexagon.get(twoPrev)[1] * hexagon.get(prevIdx(hexagon,i,1))[1];
                bigSquare = (hexagon.get(i)[1] + hexagon.get(twoPrev)[1]) * (hexagon.get(onePrev)[1] + hexagon.get(threePrev)[1]);
                
                break;
            }
        }

        System.out.println((bigSquare - smallSquare) * N);
    }

    public static int prevIdx (List<Integer[]> list, int idx, int move){
        int prev = idx - move;
        if(prev < 0){
            return list.size() + prev;
        } else {
            return prev;
        }
    }
}
