import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < people.length; i++){
            dq.add(people[i]);
        }
        int answer = 0;
        while(!dq.isEmpty()){
            if(dq.peekFirst() + dq.peekLast() <= limit){
                
                dq.pollFirst();
                dq.pollLast();
            }else{
                dq.pollLast();
               
            }
             answer++;
        }
           
        
        return answer;
    }
}