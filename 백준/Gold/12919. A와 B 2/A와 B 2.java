import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String S;
	static String T;
	static int answer = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		seek(new StringBuilder(T));
		System.out.println(answer);
	}

	public static void seek(StringBuilder formattedT){
		if(formattedT.length() == S.length()){
			if(formattedT.toString().equals(S)){
				answer = 1;
			}
			return;
		}

		if(formattedT.charAt(formattedT.length()-1) == 'A'){
			StringBuilder formattedT1 = new StringBuilder(formattedT.substring(0, formattedT.length() - 1));
			seek(formattedT1);
		}
		if(formattedT.charAt(0) == 'B'){
			StringBuilder formattedT1  = new StringBuilder(formattedT.substring(1)).reverse();
			seek(formattedT1);
		}
	}
}
