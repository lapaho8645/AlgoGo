import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(new int []{priorities[i], i});
        }
        Arrays.sort(priorities);
        int index = priorities.length - 1;
        int top = priorities[index];
        int [] cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur[0] == top){          //현재꺼가 가장 중요도가 높으면
                answer++;
                if(cur[1] == location){
                    break;
                }
                index--;
                top = priorities[index];
            }else{          //아니면 다시 맨 뒤로 넣기
                queue.add(cur);
            }
        }
        return answer;
    }
}