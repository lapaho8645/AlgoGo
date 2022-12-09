import java.util.*;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A' + i)), i+1);
        }
     
        int index = 27;
        for(int i = 0; i < msg.length(); i++){
            int temp = 1;
            String prev = "";
            while(true){
                temp = i + temp > msg.length() ? 0 : temp; 
                String cur = msg.substring(i, i + temp);  
                if(map.containsKey(cur)){
                    prev = cur;
                    temp++; 
                }else{
                    map.put(cur, index);
                    list.add(map.get(prev));
                    i = i + prev.length() - 1;
                    index++;
                    break;
                }
            }
           
        }
        int[] answer = new int [list.size()];
       for(int i = 0 ; i < list.size(); i++){
           answer[i] = list.get(i);
       }
        
        return answer;
    }
}