import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> songForGenres = new HashMap<>();
        Map<String,Integer> totForGenres = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            songForGenres.putIfAbsent(genres[i], new ArrayList<>());
            songForGenres.get(genres[i]).add(i);
        }
        
        songForGenres.keySet().stream()
            .forEach(key -> {
                songForGenres.get(key).sort((a,b)->{
                    if(plays[a] == plays[b]) {
                        return a - b;
                    } else {
                        return plays[b] - plays[a];
                    }
                });
                int sum = songForGenres.get(key).stream()
                    .map(a->plays[a])
                    .reduce((a,b)->a+b).get();
                totForGenres.put(key,sum);
            });
        
        List<String> rank = totForGenres.keySet().stream()
            .sorted(Comparator.comparing(key->totForGenres.get(key) * -1))
            .collect(Collectors.toList());
        System.out.println(rank);
        
        int idx = 0;
        int[] answer;
        List<Integer> answerList = new ArrayList<>();
        for(String genre : rank){
            for(int i = 0; i < Math.min(songForGenres.get(genre).size(), 2); i++){
                answerList.add(songForGenres.get(genre).get(i));
            }
        }
        answer = answerList.stream().mapToInt(a->a).toArray();
        return answer;
    }
}