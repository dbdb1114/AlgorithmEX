import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static class Plug{
		int electron;
		int nextUse;

		public Plug(int electron, int nextUse){
			this.electron = electron;
			this.nextUse = nextUse;
		}

		public Plug(int electron){
			this.electron = electron;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		Plug[] electrons = new Plug[K];
		for(int i = 0; i < K; i++){
			electrons[i] = new Plug(Integer.parseInt(st1.nextToken()));
		}

		for(int i = 0; i < K; i++){
			electrons[i].nextUse = findNextUse(electrons, i);
		}

		List<Plug> nowUseList = new ArrayList<>();

		// 첫 사용 초기화
		int idx = 0;
		while(idx < electrons.length && nowUseList.size() < N) {
			if(electrons[idx].nextUse < idx + (N - nowUseList.size())){
			    idx++;
				continue;
			}
			nowUseList.add(electrons[idx]);
			idx++;
		}

		int answer = 0;
		nowUseList.sort(Comparator.comparing(plug -> plug.nextUse * -1));
		for(int i = idx; i < electrons.length; i++){
			boolean isExist = false;
			int existIdx = 0;

			for (int j = 0; j < nowUseList.size(); j++) {
				if(electrons[i].electron == nowUseList.get(j).electron){
					isExist = true;
					existIdx = j;
					break;
				}
			}

			if(isExist){
				nowUseList.get(existIdx).nextUse = electrons[i].nextUse;
			} else {
				answer++;
				nowUseList.remove(0);
				nowUseList.add(electrons[i]);
			}
			nowUseList.sort(Comparator.comparing(plug -> plug.nextUse * -1));
		}

		System.out.println(answer);
	}

	public static int findNextUse(Plug[] ar,  int idx){
		for(int i = idx+1; i < ar.length; i++){
			if(ar[i].electron == ar[idx].electron){
				return i;
			}
		}

		return 101;
	}
}
//  = > 1
// 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5

// 1 2 3 4 ;
// 1 2 3 5 / 1 => 4
// 1 2 4 5 / 2 => 3
// 1 3 4 5 / 3 => 2
