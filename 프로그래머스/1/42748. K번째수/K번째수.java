import java.util.Arrays;

class Solution {

	public int[] solution(int[] ar, int[][] commands) {
		
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			
            int st = commands[i][0];
			int ed = commands[i][1];
			int k = commands[i][2]-1;
            
			int[] temp = new int[ed - st + 1];
			
			for (int j = 0; j <= ed-st; j++) {
				temp[j] = ar[j + st - 1];
			}
			
			Arrays.sort(temp);
			
			answer[i] = temp[k];
		}
		
		return answer;
		
	}
	
}
