import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2)-> map.get(o2) - map.get(o1));       //밸류값 내림차순
        int sum = 0;
        for(int i = 0; i < keySet.size(); i++){
            answer++;
            sum += map.get(keySet.get(i));
            if(sum >= k)
                break;
        }
        return answer;
    }
}