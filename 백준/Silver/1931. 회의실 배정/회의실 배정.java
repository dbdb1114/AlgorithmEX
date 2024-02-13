import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Main {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int conference = Integer.parseInt(bufferedReader.readLine());
        Map<Integer,ArrayList<Integer>> conferencesTime = new HashMap<>();
        Map<Integer, Integer> confferencesTime = new HashMap<>();

        for (int i = 0; i < conference; i++) {
            int[] readLine = Arrays.stream((bufferedReader.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();

            int start = readLine[0];
            int end = readLine[1];

            if(!conferencesTime.containsKey(start)){
                conferencesTime.put(start,new ArrayList<>());
            }
            conferencesTime.get(start).add(end);
        }

        for (ArrayList<Integer> integers : conferencesTime.values()) {
            integers.sort(Comparator.naturalOrder());
        }

        int endTime = 0;

        List<Integer> keys = conferencesTime.keySet().stream().sorted().collect(Collectors.toList());

        for (int key : keys) {
            
            Iterator<Integer> iterator = conferencesTime.get(key).iterator();
            
            int st = key;
            int ed = iterator.next();

            if(st < endTime){
                continue;
            }

            while(isShort(conferencesTime, st,ed)){
                answer++;
                endTime = ed;

                if(st != ed){
                    break;
                }

                if(iterator.hasNext()){
                    ed = iterator.next();
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isShort(Map<Integer,ArrayList<Integer>> times, int stTime, int edTime){
        if(stTime == edTime) {
            return true;
        }

        for (int i = stTime+1; i <= edTime; i++) {
            if(times.containsKey(i) && times.get(i).get(0) < edTime){
                return false;
            }
        }

        return true;
    }
}
