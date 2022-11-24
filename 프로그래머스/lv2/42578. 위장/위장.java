import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1] , 0) + 1);
        }
        for(String key : map.keySet()){
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
     }
}
/*************시간 초과*********************/
//     static boolean [] isSelected;
//     static int answer = 0;
//     static HashMap<String, Integer> map;
//     static LinkedList<String> list;
//     public int solution(String[][] clothes) {
       
//         map = new HashMap<>();
//         for(int i = 0; i < clothes.length; i++){
//             map.put(clothes[i][1], map.getOrDefault(clothes[i][1] , 0) + 1);
//         }
//         list = new LinkedList<>(map.keySet());
//         isSelected = new boolean [map.size()];
        
//         subset(0);
//         // 공집합 제외
//         return answer - 1;
//     }
//     public void subset(int cnt){
//         if(cnt == isSelected.length){
//             int sum = 1;
//             for(int i = 0; i < isSelected.length; i++){
//                 if(isSelected[i] == true){
//                     sum = sum * map.get(list.get(i));
//                 }
//             }
//             answer += sum;
//             return;
//         }
//         isSelected[cnt] = true;
//         subset(cnt+1);
        
//         isSelected[cnt] = false;
//         subset(cnt+1);
//     }
