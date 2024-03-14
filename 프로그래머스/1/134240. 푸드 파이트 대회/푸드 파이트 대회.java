/**
- 문제 분석
수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최한다. 
1 대 1이며, 매 대결마다 음식의 종류와 양이 바뀐다. ( 음식은 일렬로 배치한다. )
한 선수는 (왼 => 오), 한 선수는 (오 => 왼), 중안에는 물이 있는데 가장 빨리 먹는 선수가 승리 

음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 한다. ( 데칼코마니처럼 )
    => 칼로리가 낮은 음식을 먼저 먹을 수 있도록 배치 

칼로리와 음식의 수를 고려하지 않은 음식의 갯수 food가 주어졌을 때 
대회를 위한 음식의 배치를 나타내는 문자열을 return 하라

제한 사항 
1 <= food의 각 원소 <= 1000                ->  정답의 길이가 매우 길어질 수 있다.
food는 칼로리가 적은 순서대로 음식의 양이 담겨있다. ->  인덱스 0부터 순회하면 된다. 

해결 방안 
각 인덱스의 값을 2로 나눈 몫 만큼 문자열의 양쪽에 더해준다.
=> StringBuilder를 통해 조건에 맞게 오른쪽 선수기준으로 하나 만든 후 
    reverse를 해서 붙여주면 것 같다. 

*/

class Solution {
    
    public String solution(int[] food) {
        StringBuilder foodOrder = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            repeat(foodOrder, i, food[i]/2);
        }
        
        String left = foodOrder.toString();
        String right = foodOrder.reverse().toString();
        
        return left + '0' + right;
    }
    
    public void repeat(StringBuilder sb, int target, int cnt){
        for(int i = 0; i < cnt; i++){
            sb.append(target);
        }
    }
    
}
