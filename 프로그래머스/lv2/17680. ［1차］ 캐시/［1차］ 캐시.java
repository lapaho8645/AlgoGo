import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int hit = 1;
        int miss = 5;
        int index = 0;
     
        if(cacheSize == 0){
            return miss * (cities.length);
        } 
        
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
           
            if(list.indexOf(cities[i].toLowerCase()) == -1){       //없음
                answer += miss; 
                if(list.size() >= cacheSize){
                    list.remove(0);
                }
                list.add(cities[i].toLowerCase());
            }else{
                 answer += hit;
                 list.remove(cities[i].toLowerCase());
                 list.add(cities[i].toLowerCase());
            }
         
        }
        return answer;
    }
}
