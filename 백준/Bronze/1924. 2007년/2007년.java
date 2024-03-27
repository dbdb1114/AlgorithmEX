import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] date = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2007,date[0]-1,date[1]);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] dowArr = {"SUN", "MON", "TUE", "WED","THU","FRI","SAT"};
        System.out.println(dowArr[firstDayOfWeek-1]);
    }
}
