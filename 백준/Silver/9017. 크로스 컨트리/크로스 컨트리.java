import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
/**
2
15
1 2 1 2 4 1 1 3 3 3 3 1 3 3 1
18
1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1
 *
 * */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] inputRank = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			int[] teamNumber = new int[201];
			for (int j = 0; j < inputRank.length; j++) {
				teamNumber[inputRank[j]]++;
			}

			Set<Integer> validTeam = new HashSet<>();
			for (int j = 0; j < teamNumber.length; j++) {
				if(6 <= teamNumber[j]){
					validTeam.add(j);
				}
			}

			int[] realRank = Arrays.stream(inputRank).filter(team -> validTeam.contains(team)).toArray();
			Map<Integer, List<Integer>> teamRankList = new HashMap<>();
			for (int j = 0; j < realRank.length; j++) {
				if(!teamRankList.containsKey(realRank[j])){
					teamRankList.put(realRank[j], new ArrayList<>());
				}
				teamRankList.get(realRank[j]).add(j+1);
			}


			// 팀별 점수 계산
			Map<Integer, Integer> teamTotalScore = new HashMap<>();
			for (Integer key : teamRankList.keySet()) {
				int teamScore = teamRankList.get(key).subList(0, 4).stream().mapToInt(a -> a).sum();
				teamTotalScore.put(key, teamScore);
			}

			// 점수로 정렬
			List<Integer> teamTotalRank = teamTotalScore.keySet().stream()
				.sorted(Comparator.comparingInt(teamTotalScore::get))
				.collect(Collectors.toList());

			int firstScore = teamTotalScore.get(teamTotalRank.get(0));

			// 동점자 처리 (다섯 번째 주자의 순위 비교)
			List<Integer> list = teamTotalScore.keySet().stream()
				.filter(key -> teamTotalScore.get(key) == firstScore)
				.sorted(Comparator.comparingInt(key -> teamRankList.get(key).get(4)))
				.collect(Collectors.toList());

			System.out.println(list.get(0));
		}
	}
}
