import java.util.HashSet;
import java.util.Set;

class Solution {
    private static boolean checkLastCharacter(String prev, String word) {
        if (prev.charAt(prev.length() - 1) == word.charAt(0)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean duplicateWord(Set<String> wordsSet, String word) {
        if (wordsSet.add(word)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isOneCharacter(String word) {
        if (word.length() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkWordCondition(Set<String> wordsSet, String prev, String word) {
        if (checkLastCharacter(prev, word) && duplicateWord(wordsSet, word) && isOneCharacter(word)) {
            return true;
        } else {
            return false;
        }
    }

    private static int[] setAnswer(int n, int numberOfFinishWord) {

        int[] answer = new int[2];

        boolean isZeroRemain = numberOfFinishWord % n == 0;

        if (numberOfFinishWord != 0) {
            answer[0] = isZeroRemain ? n : numberOfFinishWord % n;
            answer[1] = isZeroRemain ? numberOfFinishWord / n : numberOfFinishWord / n + 1;
        }

        return answer;
    }

    public static int[] solution(int n, String[] words) {

        Set<String> wordsSet = new HashSet<>();
        int numberOfFinishWord = 0;

        if (isOneCharacter(words[0])) {
            wordsSet.add(words[0]);
        } else {
            return new int[]{1, 1};
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String word = words[i];
            if (!checkWordCondition(wordsSet, prev, word)) {
                numberOfFinishWord = i + 1;
                break;
            }
        }

        return setAnswer(n, numberOfFinishWord);
    }
}