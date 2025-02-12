import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        setMap(map1, str1);
        setMap(map2, str2);
    
        int sum = 0;
        int cros = 0;
        for(String key : map1.keySet()){
            int sumTar = map1.get(key);
            if(map2.containsKey(key)){
                 sumTar = Math.max(map1.get(key),map2.get(key));
                 cros += Math.min(map1.get(key),map2.get(key));
            }
            sum += sumTar;
        }
        for(String key : map2.keySet()){
            int sumTar = map2.get(key);
            if(map1.containsKey(key)){
                continue;
            }
            sum += sumTar;
        }
        
        if(sum == 0 && cros == 0){
            return 65536;
        } else {
            return cros * 65536 / sum;
        }
    }
    
    public void setMap(Map<String, Integer> map, String str){
        for(int i = 0; i < str.length()-1; i++){
            String key = str.substring(i,i+2);
            if(key.replaceAll("[a-z]","").length() != 0){
                continue;
            }
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
        }
    }
}