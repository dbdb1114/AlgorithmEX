import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        StringTokenizer stNM = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(stNM.nextToken());
        int M = Integer.parseInt(stNM.nextToken());

        Queue<String> Aq = new LinkedList<>();
        Queue<String> Bq = new LinkedList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String d = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++){
                Aq.add(d);
            }
        }
        
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String d = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++){
                Bq.add(d);
            }
        }

        int AP = 0;
        int BP = 0;
        int count = 0;
        boolean isMeet = false;
        do{
            count++;

            if(!Aq.isEmpty()){
                String AD = Aq.poll();
                if(AD.equals("R")){
                    AP++;
                } else {
                    AP--;
                }
            }
            
            if(!Bq.isEmpty()){
                String BD = Bq.poll();
                if(BD.equals("R")){
                    BP++;
                } else {
                    BP--;
                }
            }


            if(Bq.size() * 2 < Math.abs(AP - BP)) {
                break;
            }
            if(AP == BP) {
                isMeet=true;
                break;
            }
        } while (AP != BP);


        System.out.println(isMeet?count:-1);
    }
}