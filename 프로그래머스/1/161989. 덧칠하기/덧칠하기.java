/**쓸데없이 말이 엄청 길다 화난다*/
/**
    시작 부분과 시작 부분 + m을 이용한다. 
    pointer 변수를 이용해 section의 값을 확인하여 위 경계값 내에 있다면,
    
    다음 페인트칠 섹션을 찾는다. 이때 섹션이 다시 시작부분이 된다. 
    
*/
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int sectionPos = 0;
        int st = section[sectionPos];  // 2 
        int ed = section[sectionPos] + m - 1; // section[0]을 포함해서 칠해야하므로, // 5
        
        while(sectionPos < section.length){
            if(section[sectionPos] <= ed){
                sectionPos++;
            } else {
                st = section[sectionPos];
                ed = section[sectionPos] + m - 1;
                answer++;
            }
        }

        return answer;
    }
}