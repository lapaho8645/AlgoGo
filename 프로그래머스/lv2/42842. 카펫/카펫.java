import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        int x = 0;
        int y = 0;
        for(int i = 1; i <= size; i++){
            if(size % i == 0){
                x = i;
                y = size / i;
                if(yellow == ((x-2) * (y-2)) && brown == ((2 *x + 2 *(y-2)))){
                    break;
                }
               
            }

           
        }
        int[] answer = {y,x};
        return answer;
    }
    
    
}