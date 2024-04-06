import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Function;

public class Main {

/**
 산술평균 : N개의 수들의 합을 N으로 나눈 값
 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * */
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int zeroCnt = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(bf.readLine());
            map.put(M,map.getOrDefault(M,0) + 1);
            if(M == 0){
                zeroCnt++;
            }
        }


        int sum = 0; // 누적합
        // 함수형 인터페이스에 포함되는 변수는 불가변이어야함.
        // 위 for 문에서 증감식을 쓰고잇기 때문에 zeroCnt 그대로 들어갈 수 없음
        int finalZeroCnt = zeroCnt; 
        Function<Integer,Integer> avr = x->Math.round((float)x / N) ; // 평균값
        int mid = 0; // 중간값
        ArrayList<Integer> lotList = new ArrayList<>(); // 최빈값 배열
        int range = map.lastKey() - map.firstKey(); // 범위
        
        for(int key : map.keySet()){
            int value = map.get(key);

            // 누적합 
            sum += key * value;

            // 최빈값 key와 value 꺼내기
            // 최빈값 리스트가 비었다면, key를 0으로 하고, 그에 따라 value도 0으로 한다.
            // 리스트가 비어있지 않을 경우 모두 초기화
            int lotKey = lotList.isEmpty() ? 0 : lotList.get(0);
            int lotValue = lotList.isEmpty() ? 0 : map.get(lotKey);

            // 최빈값보다 더 많이 저장된 값이 있다면,
            // list를 clear하고 해당 Key값을 추가한다.
            if(lotValue < value){
                lotList.clear();
                lotList.add(key);
            }else if(lotValue == value){
                lotList.add(key);
            }
        }

        // 최빈값
        // 리스트에 최빈값이 많다면,
        // 두번째 최빈값을 꺼내기 위해 정렬 후 최빈값 초기화
        // 하나만 있다면, 해당 값으로 초기화
        int lot;
        if(lotList.size()>1){
            lotList.sort(Comparator.naturalOrder());
            lot = lotList.get(1);
        } else {
            lot = lotList.get(0);
        }


        // 중간값 초기화를 위해 value를 일일이 더해가며,
        // 더했을 때 값이 중간값 인덱스 이상일때 해당 키값으로
        // 중간값 설정 후 break;
        int ea = 0;
        for (Integer key : map.keySet()) {
            ea += map.get(key);
            if(ea >= N/2 + 1 ){
                mid = key;
                break;
            }
        }


        System.out.println(avr.apply(sum) + "\n" + mid + "\n" + lot + "\n" + range);
    }
}
