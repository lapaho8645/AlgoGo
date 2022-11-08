import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        int num =0;
        int turn = 0;
        HashSet<String> set = new HashSet<>();
        char current = words[0].charAt(0);
        for(int i = 0; i < words.length; i++){

            if(set.contains(words[i]) || words[i].charAt(0) != current){
                num = (i % n) + 1;
                turn = (i / n) + 1 ;  
                break;
            }else{
                set.add(words[i]);
                current = words[i].charAt(words[i].length() - 1);
            }
                
        }
        int[] answer = {num, turn};
        return answer;
    }
}