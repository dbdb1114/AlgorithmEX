import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {
            if (this.end == time.end){
                return this.start - time.start;
            }
            return this.end - time.end;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int conference = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Time> tlist = new ArrayList<>();
        for (int i = 0; i < conference; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tlist.add(new Time(s,e));
        }

        Collections.sort(tlist);

        int answer = 0;
        int prev = 0;

        for (Time time : tlist) {
            if(time.start >= prev){
                answer++;
                prev=time.end;
            }
        }
        System.out.println(answer);
    }
}
