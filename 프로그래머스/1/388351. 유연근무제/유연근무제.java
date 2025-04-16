class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            boolean success = true;
            for(int j = 0; j < timelogs[i].length; j++){
                if(isWeekend(startday, j)) continue;
                if(!isNotLate(schedules[i], timelogs[i][j])){
                    success = false;
                    break;
                }
            }
            if(success){
                answer++;
            }
        }
        
        return answer;
    }
    
    // 주말 체크
    public boolean isWeekend(int startDay, int days){
        boolean a = (startDay + days) % 7 == 6 || (startDay + days) % 7 == 0;
        return a;
    }
    
    // 평일 출근 지각 계산 
    public boolean isNotLate(int schedule, int time){
        int ltHour = schedule / 100;
        int ltMinute = schedule - (ltHour * 100);
        
        int rtHour = ltHour;
        int rtMinute = ltMinute + 10;
        
        if(rtMinute >= 60){
            rtHour++;
            rtMinute -= 60;
        }
        
        int timeHour = time / 100;
        int timeMinute = time - (timeHour * 100);
        
        return (timeHour == rtHour && timeMinute <= rtMinute) ||
            (timeHour < rtHour);
        
    }
    
}