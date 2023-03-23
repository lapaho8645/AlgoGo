import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int min = Integer.MAX_VALUE;
        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            min = Math.min(min, queue1[i]);
            firstQueue.add(queue1[i]);
        }
        for(int i = 0; i < queue2.length; i++){
            sum2 += queue2[i];
            min = Math.min(min, queue2[i]);
            secondQueue.add(queue2[i]);
        }
        int size = firstQueue.size() * 3;
        if((sum1 + sum2) % 2 != 0) return -1;

        while(!firstQueue.isEmpty() && !secondQueue.isEmpty() && sum1 != sum2
                && size-- >= 0){
            answer++;
            if(sum1 < sum2){
                int temp = secondQueue.poll();
                sum1 += temp;
                sum2 -= temp;
                firstQueue.add(temp);
            }else{
                int temp = firstQueue.poll();
                sum1 -= temp;
                sum2 += temp;
                secondQueue.add(temp);
            }
 
        } 
        if(sum1 != sum2) answer = -1;
        return answer;
    }
}
