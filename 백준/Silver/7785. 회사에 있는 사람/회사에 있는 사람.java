
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 자동으로 정렬되고, 중복을 제거하는 SortedSet을 사용했습니다.
        // 그리고 사전순 역순으로 출력해야하기 때문에 정렬방법을 지정했습니다.
        int N = Integer.parseInt(bf.readLine());
        SortedSet<String> nameSet = new TreeSet<>(Comparator.reverseOrder());

        // 문제를 보면 enter와 leave를 체크할 필요 없다고 판단했습니다. 
        // 
        // 이름이 두 번 나오면 
        //      들어왔다 나간 것이고, 
        // 
        // 한 번 나오면 
        //      들어오기만 한 것입니다.
        
        // 그래서 이름이 nameSet에 있으면 삭제시키고,
        // 없으면 추가하여 출력해줬습니다..
        for (int i = 0; i < N; i++) {
            String name = bf.readLine().split(" ")[0];
            if(nameSet.contains(name)){
                nameSet.remove(name);
            } else {
                nameSet.add(name);
            }
        }

        for (String s : nameSet) {
            System.out.println(s);
        }
    }
}
