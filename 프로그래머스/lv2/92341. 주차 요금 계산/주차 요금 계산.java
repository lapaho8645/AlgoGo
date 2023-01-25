import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        HashMap<String, Integer> map1 = new HashMap<>();        // 입출차시간
        HashMap<String, Integer> map2 = new HashMap<>();        // 총 소요시간
        String [] input;
        for(int i = 0; i < records.length; i++){
            input = records[i].split(" ");
            int time = changeMinute(input[0]);
            String carNum = input[1];
            if(input[2].equals("IN")){
                map1.put(carNum, time);
            }else{
                time -= map1.get(carNum);
                map1.remove(carNum);
                map2.put(carNum, map2.getOrDefault(carNum, 0) + time);
            }
        }
        for(String key : map1.keySet()){
            int time = changeMinute("23:59") - map1.get(key);
            map2.put(key, map2.getOrDefault(key, 0) + time);
        }
        List<String> keySet = new ArrayList<>(map2.keySet());
        keySet.sort((s1, s2) -> s1.compareTo(s2));
        
        int[] answer = new int[map2.size()];
        for(int i = 0; i < keySet.size(); i++){
            int total = map2.get(keySet.get(i));
            if(total <= baseTime) 
                answer[i] = baseFee;
            else{
                answer[i] = baseFee + (int)Math.ceil((total-baseTime) / (double)unitTime) * unitFee;
            }
           
        }
        
        return answer;
    }
    
    public int changeMinute(String time){
        String [] input = time.split(":");
        return Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
    }
}