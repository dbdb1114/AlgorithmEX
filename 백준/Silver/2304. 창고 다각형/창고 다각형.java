import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int pos = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            maxHeight = Math.max(maxHeight, height);
            arr.add(new int[]{pos, height});
        }

        // 좌표 기준 정렬
        arr.sort(Comparator.comparingInt(el -> el[0]));
        int maxLtPos = 0;
        int maxRtPos = 0;

        // 왼쪽 최대 높이
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i)[1] == maxHeight) {
                maxLtPos = i;
                break;
            }
        }
        // 오른쪽 최대 높이
        for (int i = arr.size()-1; i >= 0; i--) {
            if(arr.get(i)[1] == maxHeight) {
                maxRtPos = i;
                break;
            }
        }

        // 좌측 면적
        int leftSum = 0;
        int leftSt = 0;
        int leftEd = leftSt + 1;
        while (leftEd <= maxLtPos) {
            if(arr.get(leftSt)[1] < arr.get(leftEd)[1]) {
                leftSum += (arr.get(leftEd)[0] - arr.get(leftSt)[0]) * arr.get(leftSt)[1];
                leftSt = leftEd;
            } else {
                leftEd++;
            }
        }

        // 우측 면적
        int rightSum = 0;
        int rightSt = N - 1;
        int rightEd = rightSt - 1;
        while(rightEd >= maxRtPos) {
            if(arr.get(rightSt)[1] < arr.get(rightEd)[1]) {
                rightSum += (arr.get(rightSt)[0] - arr.get(rightEd)[0]) * arr.get(rightSt)[1];
                rightSt = rightEd;
            } else {
                rightEd--;
            }
        }

        int maxHeightSum = (arr.get(maxRtPos)[0] - arr.get(maxLtPos)[0]) * maxHeight + (maxHeight*1);

        System.out.println(leftSum + rightSum + maxHeightSum);
    }
}
