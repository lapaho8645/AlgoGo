import java.util.*;
class Solution {
    static int [] max = new int[11];
    public String[] solution(String[] orders, int[] course) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < orders.length; i++){
            for(int j = 0; j < course.length; j++){
                combi(map, orders[i], new String [course[j]], 0, course[j], 0);
            }
        }
        List<String> list = new LinkedList<>();
        for(String key : map.keySet()){
            for(int j = 0; j < course.length; j++){
                if(key.length() == course[j] && map.get(key) >= 2 && map.get(key) == max[course[j]])
                    list.add(key);
            }
            
        }
         String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    public void combi(HashMap<String, Integer> map, String order, String[] selected, int start, int course, int cnt){
        
        if(cnt == course){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < selected.length; i++){
                sb.append(selected[i]);
            }
            String key = sb.toString();
            char [] temp = key.toCharArray();
            Arrays.sort(temp);
            key = String.valueOf(temp);
            map.put(key, map.getOrDefault(key, 0) + 1);
            max[course] = Math.max(max[course], map.get(key));
            return;
        }
        for(int i = start; i < order.length(); i++){
            selected[cnt] = String.valueOf(order.charAt(i));
            combi(map, order, selected, i + 1, course, cnt + 1);
        }
    }
} 
