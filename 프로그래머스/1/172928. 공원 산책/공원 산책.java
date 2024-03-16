import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<Character, Integer> direction = new HashMap<>();

        direction.put('N', 0);
        direction.put('E', 1);
        direction.put('S', 2);
        direction.put('W', 3);

        int parkX = park.length;
        int parkY = park[0].length();

        // 상 우 하 좌
        // 북 동 남 서
        int[] posX = {-1,0,1,0};
        int[] posY = {0,1,0,-1};

        int[] nowPos = new int[2];

        for(int i = 0; i < park.length; i++){
            if(park[i].contains("S")){
                nowPos[0] = i;
                nowPos[1] = park[i].indexOf('S');
                break;
            }
        }
        System.out.println(Arrays.toString(nowPos));

        for(String move : routes){
            System.out.println(move);
            char heading = move.charAt(0); // 방향
            int distance = move.charAt(2) - '0'; // 

            int newX = nowPos[0] + (posX[direction.get(heading)] * distance);
            int newY = nowPos[1] + (posY[direction.get(heading)] * distance);
            
            
            int checkX = 0;
            int checkY = 0;
            
            // 지나가는 길에 장애물이나 끝을 만나는지 확인
            for(int i = 1; i <= distance; i++){
                checkX = nowPos[0] + posX[direction.get(heading)] * i;
                checkY = nowPos[1] + posY[direction.get(heading)] * i;
                if(checkX < 0 || checkX >= parkX 
                   || checkY < 0 || checkY >= parkY 
                   || park[checkX].charAt(checkY) == 'X'){
                    checkX = -10;
                    break;
                }
            }
            
            /**
             { 0, 1}
             { 3, 1}
            */
            
            if(checkX == newX){
                System.out.println("이동함");
                System.out.println("newX : " + newX);
                System.out.println("newY : " + newY);
                nowPos[0] = newX;
                nowPos[1] = newY;
            } else {
                continue;
            }
            
        }

        return nowPos;
    }
}