/**


    자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다.
        이웃나라와의 협약에 의해 공격력의 제한수치를 정하고
        제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매
    
    기사단원의 수를 나타내는 정수 number
    이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit
    초과한 기사가 사용할 무기의 공격력을 나타내는 정수 power
    
    무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 
    그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.
    
    1번부터 number까지 기사가 있다.
    
    각 기사별로 약수의 개수를 계산하고
        약수 계산후 limit이 넘는다면, power 공격력의 무기를 써야함 
        약수 계산후 limit이 넘지 않는다면, 자신의 무기 사용.
    
    무기의 공격력 1당 1kg
    
*/

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int pow = numberOfDevide(i);
            
            if(pow > limit){
                answer += power;
            } else {
                answer += pow;
            }
        }
        
        return answer;
    }
    
    public int numberOfDevide(int num){
        
        if(num == 1){
            return 1;
        }
        
        int res = 2;
        
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                res++;
            }
        }
        
        return res;
    }
    
}