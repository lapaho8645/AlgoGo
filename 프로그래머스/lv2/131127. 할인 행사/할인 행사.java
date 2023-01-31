import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        if(isPossible(map)) answer++;
        for(int i = 10; i < discount.length; i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i]) - 1);
            }
            if(map.get(discount[i-10]) != null){
                map.put(discount[i-10], map.get(discount[i-10]) + 1);
            }
            if(isPossible(map)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPossible(HashMap<String, Integer> map){
        boolean result = true;
        for(String key : map.keySet()){
            if(map.get(key) > 0){
                result = false;
                break;
            }
        }
        
        return result;
    }
}