import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        int sum = 0; 
        for(int i = 0; i < truck_weights.length; i++){
            while(sum - queue.peek() + truck_weights[i] > weight){
                sum -= queue.poll();
                queue.add(0);
                answer++;
            }
            sum -= queue.poll();
            sum += truck_weights[i];
            queue.add(truck_weights[i]);
            answer++;
        }
        
        return answer + bridge_length;
    }
}
