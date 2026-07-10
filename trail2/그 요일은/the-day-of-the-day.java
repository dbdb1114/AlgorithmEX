import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 24 m1 d1 => 월 
        // 24 m2 d2 => 까지 A요일이 얼마나 나오는가? 
        // (m1, d1) <= (m2, d2) 
        // (m2, d2) = (m1, d1) => N일 
        // 현재 요일 Indedx + N일 % 7 
        
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        sc.nextLine();
        String tarDay = sc.nextLine();
        
        String[] weeks = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int tarIndex = indexFromWeeks(weeks, tarDay);
        int daysDiff = daysDiff(m1, d1, m2, d2);
        
        int lastDays = daysDiff % 7;
        int answer = daysDiff / 7;
        if(answer > 0 && lastDays > 0 && tarIndex <= lastDays) {
            answer++;
        }

        System.out.println(answer);
    }

    public static int indexFromWeeks(String[] weeks, String tar) {
        for(int i = 0; i < weeks.length; i++){
            if(weeks[i].equals(tar)){
                return i;
            }
        }
        return 0;
    }

    public static int daysDiff(int m1, int d1, int m2, int d2){
        int mDays = 0;
        if (m2 - m1 == 0){
            return d2 - d1;
        } else if(m2 - m1 >= 2) {
            mDays = getDaysDiffFromMonth(m1, m2);
        }

        return getDaysFromMonth(m1) - d1 + d2 + mDays;
    }

    public static int getDaysDiffFromMonth(int m1, int m2){
        int days = 0;
        for (int i = m1+1; i < m2; i++){
            days += getDaysFromMonth(i);
        }
        return days;
    }

    public static int getDaysFromMonth(int m) {
        if(m <= 7){
            return getDaysFromMonthBefore8(m);
        } else {
            return getDaysFromMonthAfter7(m);
        }
    }

    public static int getDaysFromMonthBefore8(int m) {
        if( m == 2) return 29;

        if(m%2 == 1){
            return 31;
        } else {
            return 30;
        }
    }
    public static int getDaysFromMonthAfter7(int m){
        if(m%2 == 1){
            return 30;
        } else {
            return 31;
        }
    }
}