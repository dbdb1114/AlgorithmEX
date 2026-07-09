import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        // Please write your code here.
        int stM = 0;
        int stD = 0;
        int edM = 0;
        int edD = 0;

        if(m2 < m1 || (m1==m2 && d2<d1)){
            stM = m2;
            stD = d2;
            edM = m1;
            edD = d1;
        } else {
            stM = m1;
            stD = d1;
            edM = m2;
            edD = d2;            
        }

        int days = 0;
        switch(edM - stM) {
            case 0:
                days = edD - stD;
                break;
            case 1:
                days = getDayForMonth(stM) - stD + edD;
                break;
            default:
                days = getDayForMonth(stM) - stD + edD;
                for(int i = stM+1; i < edM; i++){
                    days += getDayForMonth(i);
                }
                break;
        }

        int index = days % 7;
        String[] weeks = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

        // System.out.println(index);
        if((m1 == m2 && d1 == d2) || index == 0){
            System.out.println(weeks[0]);
        }else if(m1 < m2 || (m1==m2 && d1<d2)) {
            System.out.println(weeks[index]);
        } else {
            System.out.println(weeks[7-index]);
        }

    }

    public static int getDayForMonth(int month) {
        if(month <= 7){
            return getDayForMonthBefore7(month);
        } else {
            return getDayForMonthAfter6(month);
        }
    }

    public static int getDayForMonthBefore7(int month) {
        if(month == 2) return 28;

        if(month % 2 == 1){
            return 31;
        } else {
            return 30;
        }
    }

    public static int getDayForMonthAfter6(int month) {
        if(month % 2 == 0){
            return 31;
        } else {
            return 30;
        }
    }
}