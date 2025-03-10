import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < N; j++) {
				set.add(br.readLine());
			}
			boolean answer = true;
			for(String st : set){
				for (int j = 0; j < st.length(); j++) {
					if(set.contains(st.substring(0,j))){
						answer = false;
						break;
					}
				}
				if(!answer){
					break;
				}
			}

			if(answer){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
