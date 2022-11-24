import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replace("{", "");
        s = s.replace("}", "");
        String [] input = s.split(",");
       
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length; i++){
            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i])+1);
            }else{
                map.put(input[i], 1);
            }
        }
        List<String> keySet = new LinkedList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int [] answer = new int [keySet.size()];
        for(int i = 0; i < keySet.size(); i++){
            answer[i] = Integer.parseInt(keySet.get(i));
        }
       
        return answer;
    }
}

// 개수를 세서 가장 많이 나오는 순으로