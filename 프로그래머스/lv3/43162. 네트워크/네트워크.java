import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean [] check = new boolean[computers[0].length];
        for(int i = 0 ; i < computers[0].length; i++){
            if(check[i])
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            check[i] = true;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int j = 0; j < computers[0].length; j++){
                    if(computers[cur][j] == 1 && !check[j]){
                        check[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer++;
        }
       
       
        return answer;
    }
}