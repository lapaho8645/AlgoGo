import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        String [] head = new String[files.length];
        String [] number = new String[files.length];
        String [] tail = new String[files.length];
        
        for(int i = 0; i < files.length; i++){
            boolean check = false;
            int tempIdx = 0;
            
            for(int j = 0; j < files[i].length(); j++){
                if(!check && (files[i].charAt(j) <= '9' && files[i].charAt(j) >= '0')){
                    head[i] = files[i].substring(0, j);
                    tempIdx = j;
                    check = true;
                }else if(check && (files[i].charAt(j) > '9' || files[i].charAt(j) < '0')){
                    number[i] = files[i].substring(tempIdx, j);
                    tail[i] = files[i].substring(j, files[i].length());
                    break;
                } 
                if(check && j == (files[i].length()-1)){
                    number[i] = files[i].substring(tempIdx, files[i].length());
                    tail[i] = "";
                }
                
            }
            
        }
   String[] answer = new String[files.length];
        PriorityQueue<FileName> pq = new PriorityQueue<>();
        for(int i = 0; i < files.length; i++){
            if(number[i].length() <= 5){
                 pq.add(new FileName(head[i].toLowerCase(), Integer.parseInt(number[i]), i));
            }else{
                
                pq.add(new FileName(head[i].toLowerCase(), Integer.parseInt(number[i].substring(0,5)), i));
            }
        }
        
        for(int i = 0; i < files.length; i++){
            FileName cur = pq.poll();
           
            if(tail[cur.index] != null && number[cur.index] != null)
                answer[i] = head[cur.index] + number[cur.index] + tail[cur.index];
                
            else if(tail[cur.index] == null && number[cur.index] != null){
                answer[i] = head[cur.index] + number[cur.index];
            }
                
        }
       
        return answer;
    }
    
    public class FileName implements Comparable<FileName>{
        String head;
        int number;
        int index;
        FileName(String head, int number, int index){
            this.head = head;
            this.number = number;
            this.index = index;
        }
        @Override
        public int compareTo(FileName f){
            if(this.head.equals(f.head)){
                if(this.number == f.number){
                    return this.index - f.index;
                }else{
                    return this.number - f.number;
                }
            }else{
                return this.head.compareTo(f.head);
            }
        }
    }
}