import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main  {
    static Map<String, Double> achieve = new HashMap<>();

    static {
        achieve.put("A+",4.5);
        achieve.put("A0",4.0);
        achieve.put("B+",3.5);
        achieve.put("B0",3.0);
        achieve.put("C+",2.5);
        achieve.put("C0",2.0);
        achieve.put("D+",1.5);
        achieve.put("D0",1.0);
        achieve.put("F",0.0);
    }
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double totGrade = 0;
        double totScore = 0;

        for (int i = 0; i < 20; i++) {
            String[] subject = bf.readLine().split(" ");

            if(subject[2].trim().equals("P")) {
                continue;
            }

            double grade = Double.parseDouble(subject[1].trim());
            double score = grade * achieve.get(subject[2].trim());

            totGrade += grade;
            totScore += score;
        }

        System.out.println(totScore / totGrade);
    }
}
