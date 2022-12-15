import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(); //오름차순
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        String command;
        Integer num;
        int cnt = 0;
        for(int i = 0; i < operations.length; i++){
            command = operations[i].split(" ")[0];
            num = Integer.parseInt(operations[i].split(" ")[1]);
            if(command.equals("I")){
                priorityQueue1.add(num);
                priorityQueue2.add(num);
                cnt++;
            }else if(command.equals("D")){
                if(!priorityQueue2.isEmpty() && num == 1){
                    cnt--;
                    priorityQueue2.poll();
                }else if(!priorityQueue1.isEmpty() && num == -1){
                    cnt--;
                    priorityQueue1.poll();
                }
                if(cnt == 0){
                    priorityQueue1 = new PriorityQueue<>();
                    priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
                }
            }
        }
        int max = priorityQueue2.isEmpty() ? 0 : priorityQueue2.poll();
        int min = priorityQueue1.isEmpty() ? 0 : priorityQueue1.poll();
        int[] answer = {max, min};
        return answer;
    }
}
