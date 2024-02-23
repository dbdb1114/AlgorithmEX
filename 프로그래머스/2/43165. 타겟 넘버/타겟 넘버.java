/**
n개의 음이 아닌 정수들이 있습니다. 
이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 

숫자 배열을 적당히 더하고 빼서 target 넘버를 만들어라

'-'하나 '+'여러개
전부 더하는 것부터 시작하여,
깊이만큼 '-'를 늘려간다. 

전부 더한 것부터 시작해서 뺄셈을 돌아가면서 한다.

lv만큼 뺄셈을 늘려간다. 
            [1,1,1,1,1]
            다 더 했을 때 
0인덱스만 뺐을 때, 1번 인덱스만 뺐을 때, 2번 인덱스만 뺐을 때 


for(i = lv; i<len i++ ){
    num -= nums[i]*2;
    DFS(i+1);
    num += nums[i]*2;
}

*/

import java.util.*;

class Solution {
    int target;
    int num;
    int[] numbers;
    int answer;
    
     public int solution(int[] numbers, int target) {
         this.target = target;
         this.numbers = numbers;
         this.num = 0;
         
         for(int i = 0; i < numbers.length; i++){
             num += numbers[i];
         }
         if(num == target) {
             this.answer++;
         }
         
         recursive(0);
        
        return this.answer;
        
    }
    
    public void recursive(int lv){
        if(num == this.target){
            answer ++;
            return;
        }
        
        for(int i = lv; i<this.numbers.length; i++ ){
            num -= this.numbers[i]*2;
            recursive(i+1);
            num += this.numbers[i]*2;
        }
    }
    
}