import java.util.LinkedList;


class Solution {
    public int[] solution(String[] operation) {
        int[] answer = new int[2];
        LinkedList<Integer> queue = new LinkedList<>();

        for( int i = 0; i < operation.length; i++){

            if ( operation[i].startsWith("D 1") && !queue.isEmpty() ){
                queue.sort((c1,c2)->c1 > c2 ? 1 : -1);
                queue.removeLast();
            } else if ( operation[i].startsWith("D -1") && !queue.isEmpty() ){
                queue.sort((c1,c2)->c1 > c2 ? 1 : -1);
                queue.removeFirst();
            } else if ( operation[i].startsWith("I") ){
                int num = Integer.parseInt(operation[i].substring(2));
                queue.add(num);
            }
        }
                queue.sort((c1,c2)->c1 > c2 ? 1 : -1);

        if( queue.isEmpty() ){
            return answer;
        }
        answer[0] = queue.getLast();
        answer[1] = queue.getFirst();

        return answer;
    }
}