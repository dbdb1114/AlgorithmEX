import java.util.*;


class Solution {
    public int[] solution(int n, long left, long right) {
				int[] answer = {};
		answer = new int[(int)(right - left) + 1];
		int answerIdx = 0;
		
		long stRow = left / n;
		long edRow = right / n;
		for (long i = stRow; i <= edRow; i++) {
			for (long j = 0; j < n; j++) {
				long num = Math.max(i, j) + 1;
				if(left <= i*n + j && i*n +j <=right){
					answer[answerIdx++] = (int)num;
				}
			}
		}

		return answer;
	}
}