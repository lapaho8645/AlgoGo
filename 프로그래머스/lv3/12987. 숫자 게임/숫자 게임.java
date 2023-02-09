import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int index = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = index; j < B.length; j++){
                if(B[index] > A[i]){
                    answer++;
                    index++;
                    break;
                }else{
                    index++;     
                }
            }
        }
        return answer;
    }
    
}
// 1 3 5 7
// 2 2 6 8