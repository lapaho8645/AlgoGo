import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int [] result = new int[enroll.length];
        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, String> refererMap = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            indexMap.put(enroll[i], i);
            refererMap.put(enroll[i], referral[i]);
        }
        for(int i = 0; i < seller.length; i++){
            int index = indexMap.get(seller[i]);
            String referer = refererMap.get(seller[i]);
            int revenue = amount[i] * 100;
            result[index] += revenue - (int)revenue * 0.1;
            while(!referer.equals("-") && revenue >= 1){ 
                index = indexMap.get(referer);
                referer = refererMap.get(referer);
                revenue = (int)(revenue * 0.1);
                result[index] += revenue - (int)(revenue * 0.1);
            }
            
        }
        int[] answer = new int [enroll.length];
        for(int i = 0; i < enroll.length; i++){
           answer[i] = result[i];
        }
        return answer;
    }
 
}