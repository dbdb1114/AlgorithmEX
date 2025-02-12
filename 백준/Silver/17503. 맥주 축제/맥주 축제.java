
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initNumbers = br.readLine().split(" ");

        long[][] beers;
        long answer = Long.MAX_VALUE;
        int N = Integer.parseInt(initNumbers[0]);
        int M = Integer.parseInt(initNumbers[1]);
        int K = Integer.parseInt(initNumbers[2]);

        beers = new long[K][2];

        for(int i = 0; i < K; i++) {
            long[] beer = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            beers[i] = beer;
        }

        Arrays.sort(beers, Comparator.comparing(ar->ar[1]));

        // 도수 중앙값 설정
        long st = 0;
        long ed = beers[beers.length-1][1];

        while(st <= ed){
            long mid = st + (ed - st)/2;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            long favorSum = 0;
            for (long[] beer : beers) {
                if (beer[1] > mid) break; // 도수 제한 초과 시 탐색 중단

                pq.add(beer[0]);
                favorSum += beer[0];

                if (pq.size() > N) {
                    favorSum -= pq.poll(); // 선호도가 가장 낮은 맥주 제거
                }
            }

            if(pq.size() == N && favorSum >= M){
                // 정답 확인
                // 도수 감소 => ed 감소
                answer = Math.min(answer, mid);
                ed = mid - 1;
            } else {
                // 도수 증가 => st 증가
                st = mid + 1;
            }
        }

        if(answer == Long.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
