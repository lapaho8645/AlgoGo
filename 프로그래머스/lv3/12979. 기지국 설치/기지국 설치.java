import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
       
        for(int i = 0; i < stations.length; i++){
            if(stations[i] - w > index){
                answer += Math.ceil((stations[i] - w - index) / (double)(2 * w + 1));
            } 
            index = stations[i] + w + 1;
        }
        if(index > 1 && index <= n){
            answer += Math.ceil((n + 1 - index) / (double)(2 * w + 1));
        }

        return answer;
    }
}