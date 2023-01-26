import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        
        for(int i = 0; i <= t*m; i++){
            sb1.append(toN(i, n));
        }
        String arr = sb1.toString();
        int num = 0;
        int index = p-1;
        while(num < t){
            sb2.append(arr.charAt(index));
            index += m;
            num++;
        }
        String answer = sb2.toString();
        return answer;
    }
    
    public String toN(int num, int n){
        String result = "";
        if(num == 0) result = "0";
        while(num > 0){
            if(num % n > 9){
                result = (char)('A'+ num % n - 10) + result;
            }else{
                result = num % n + result;
            }
            num = num / n;
        }
       
        return result;
    }
}
