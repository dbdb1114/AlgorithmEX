import java.util.*;


class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
    
        int loPos = 0;
        int rePos = 0;
        
        ArrayList<Integer> lostArr = new ArrayList<>();
        ArrayList<Integer> resArr = new ArrayList<>();
        
        for(int i : lost){
            lostArr.add(i);
        }
        
        for(int i : reserve){
            resArr.add(i);
        }
        
        Collections.sort(lostArr);
        Collections.sort(resArr);
       
        ArrayList<Integer> removeArr = new ArrayList<Integer>();
        for(int i : lostArr){
            if(resArr.contains(i)){
                removeArr.add(i);
            }
        }
        
        lostArr.removeAll(removeArr);
        resArr.removeAll(removeArr);
        
        int answer = n - lostArr.size();
        
        while(loPos < lostArr.size() && rePos < resArr.size()){
            if(lostArr.get(loPos) + 1 == resArr.get(rePos) || 
               lostArr.get(loPos) - 1 == resArr.get(rePos) ){
                loPos++;
                rePos++;
                answer++;
            } else if (lostArr.get(loPos) < resArr.get(rePos)){
                loPos++;
            } else if (lostArr.get(loPos) > resArr.get(rePos)){
                rePos++;
            }
        }
        
        return answer;
    }
}