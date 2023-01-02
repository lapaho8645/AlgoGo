import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int length = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < length; i++){
            pq.add(works[i]);
        }
       
        while(n > 0 && pq.peek() > 0){
            int num = pq.poll();
            pq.add(num-1);
            n--;
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
// 가장 큰거로 정렬해서 가장 큰거에서 --