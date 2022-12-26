import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        String temp = "";
        int intersection = 0;
        int union = 0;
        for(int i = 0; i < str1.length() - 1; i++){
            temp = str1.substring(i, i+2);
            if(temp.matches("^[a-zA-Z]*$")){
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                union++;
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            temp = str2.substring(i, i+2);
            if(temp.matches("^[a-zA-Z]*$")){               
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                union++;
            }
        }
  
        for(String key : map1.keySet()){
            if(map2.get(key) != null){
                intersection += Math.min(map1.get(key) , map2.get(key));
            }
        }
        int answer = 65536;
        if(union - intersection == 0)
            return answer;
        answer = (int)(intersection / (float) (union - intersection) * answer);
        return answer;
    }
}