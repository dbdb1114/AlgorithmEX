import java.util.*;


class Solution {
    
       public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int los : lost) {
            lostSet.add(los);
        }

        for (int res : reserve) {
            if(lostSet.contains(res)){
                lostSet.remove(res);
            } else {
                resSet.add(res);
            }
        }

        Iterator<Integer> iterator = lostSet.iterator();
        while (iterator.hasNext()) {
            int stu = iterator.next();
            if (resSet.contains(stu)) {
                resSet.remove(stu);
                iterator.remove();
            } else if (resSet.contains(stu - 1)) {
                resSet.remove(stu - 1);
                iterator.remove();
            } else if (resSet.contains(stu + 1)) {
                resSet.remove(stu + 1);
                iterator.remove();
            }
        }

        return n - lostSet.size();
    }

}