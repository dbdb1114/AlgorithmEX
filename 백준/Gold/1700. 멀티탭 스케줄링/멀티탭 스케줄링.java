import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
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


		@Override
		public boolean equals(Object o){
			Plug p = (Plug) o;
			return this.electron == p.electron;
		}

		@Override
		public int hashCode(){
			return Objects.hashCode(electron);
		}

		@Override
		public String toString(){
			return "electron = " + electron +", " + "nextUse" + nextUse;
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

		PriorityQueue<Plug> nowUseQueue = new PriorityQueue<>(Comparator.comparingInt(p->p.nextUse * -1));
		Set<Plug> plugSet = new HashSet<>();
		// 첫 사용 초기화
		int idx = 0;
		while(idx < electrons.length && nowUseQueue.size() < N) {
			if(electrons[idx].nextUse < idx + (N - nowUseQueue.size())){
			    idx++;
				continue;
			}
			nowUseQueue.add(electrons[idx]);
			plugSet.add(electrons[idx]);
			idx++;
		}

		int answer = 0;
		// 사용중인 plug,
		// 사용중인 plug 기록.
		for(int i = idx; i < electrons.length; i++){
			if(!plugSet.contains(electrons[i])){
				answer++;
				Plug cur = nowUseQueue.poll();
				plugSet.remove(cur);
				plugSet.add(electrons[i]);
			}
			nowUseQueue.add(electrons[i]);
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