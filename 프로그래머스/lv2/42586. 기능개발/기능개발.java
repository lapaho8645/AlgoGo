import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        List<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        //int[] temp = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            queue.add((100 - progresses[i]) % speeds[i] == 0 ?
                (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1);
        }
        int cnt = 1;
        int cur = queue.poll();
        while(!queue.isEmpty()){
            if(cur < queue.peek()){
                list.add(cnt);
                cur = queue.poll();
                cnt = 1;
            }else{
            cnt++;
            queue.poll();}
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
