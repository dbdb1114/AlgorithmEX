import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String target = br.readLine();

		StringBuilder sb = new StringBuilder(target);
		while(sb.length() > start.length()) {
			if(sb.charAt(sb.length()-1) == 'B'){
				sb.deleteCharAt(sb.length() - 1);
				sb.reverse();
			} else {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		if(sb.toString().equals(start)){
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}
}
