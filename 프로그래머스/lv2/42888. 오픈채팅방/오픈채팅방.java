import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        String[] command = new String[record.length];
        String [] uuid = new String[record.length];
        int cnt = 0;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String input [] = record[i].split(" ");
            if(!input[0].equals("Change") ){
                command[cnt] = input[0];
                uuid[cnt++] = input[1];
            }
            if(!input[0].equals("Leave")){
                map.put(input[1], input[2]);
            }
            
        }
        String [] answer = new String[cnt];
        for(int i = 0; i < cnt; i++){
            if(command[i].equals("Enter")){
                answer[i] = map.get(uuid[i]) + "님이 들어왔습니다.";
            }else{
                answer[i] = map.get(uuid[i]) + "님이 나갔습니다.";
            }
        }
        
      
        return answer;
    }
}