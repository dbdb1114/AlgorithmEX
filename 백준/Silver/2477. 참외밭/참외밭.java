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
            if(hexagon.get(i)[0] == hexagon.get(prevIdx(hexagon,i,2))[0]
                    && hexagon.get(prevIdx(hexagon,i,1))[0] == hexagon.get(prevIdx(hexagon,i,3))[0]){
                smallSquare = hexagon.get(prevIdx(hexagon,i,2))[1] * hexagon.get(prevIdx(hexagon,i,1))[1];
                bigSquare = (hexagon.get(i)[1] + hexagon.get(prevIdx(hexagon,i,2))[1]) * (hexagon.get(prevIdx(hexagon,i,1))[1] + hexagon.get(prevIdx(hexagon,i,3))[1]);
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
