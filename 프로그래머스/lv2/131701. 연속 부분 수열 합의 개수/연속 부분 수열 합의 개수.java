import java.util.*;
class Solution {
    
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int size = elements.length;
        for(int i = 0 ; i < size; i++){
            int sum = 0;
            for(int j = 0; j < size; j++){
                sum += elements[(i + j) % size];
                set.add(sum);
            }
            
        }
        int answer = set.size();
        return answer;
    }
    
}