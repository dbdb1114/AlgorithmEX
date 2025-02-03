import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < N; i++) {

			int setSize1 = set.size();
			String[] words = br.readLine().split(" ");
			for (int j = 0; j < words.length; j++) {
				char ftChar = words[j].charAt(0);
				if(!set.contains(Character.toLowerCase(ftChar))){
					words[j] = "[" + ftChar + "]" + words[j].substring(1);
					System.out.println(String.join(" ", words));
					set.add(Character.toLowerCase(ftChar));
					break;
				}
			}

			if(setSize1 < set.size()){
				continue;
			}

			int setSize2 = set.size();
			String word = String.join(" ", words);
			for (int j = 0; j < word.length(); j++) {
				char character = word.charAt(j);
				if(character == ' ') continue;
				if(!set.contains(Character.toLowerCase(character))){
					set.add(Character.toLowerCase(character));
					word = word.substring(0,j) + "[" + character + "]" + word.substring(j+1);
					System.out.println(word);
					break;
				}
			}

			if(setSize2 < set.size()){
				continue;
			}

			if(i == N - 1){
				System.out.print(word);
			} else {
				System.out.println(word);
			}
		}
	}
}
