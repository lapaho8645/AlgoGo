import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        LinkedList<Movement> list = new LinkedList<>();
        for(int i = 0 ; i < routes.length ; i++){
            list.add(new Movement(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(list);
      
        int start = list.get(0).start;
        int end = list.get(0).end;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).start > end){
                answer++;
                end = list.get(i).end;
            }
            if(list.get(i).end < end){
                end = list.get(i).end;
            }
        }
            
        return answer;
    }
}
class Movement implements Comparable<Movement>{
    int start;
    int end;
    Movement(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Movement o){
        return this.start == o.start ? this.end - o.end : this.start - o.start;
    }
}