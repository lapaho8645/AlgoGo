import java.util.*;
import java.io.*;
class Solution {
    public String solution(int n) {
        int [] numbers = new int[]{1, 2, 4};
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(n <= 3){
            int index = n % 3;
            if(index == 0) index += 3;
            return answer += numbers[index - 1];
        }
        int size = 1;
        int sum = 0;
        while(true){
            if(sum + Math.pow(3, size) >= n){
                break;
            }
            sum += Math.pow(3, size++);
        }
        int temp = n - sum;
        while(size > 1){
            int cur = (int)Math.pow(3, size - 1);
            int div = temp / cur;
            int mod = temp % cur;
            if(mod == 0){
                div = (div-1 + 3) % 3;
            }
            temp = mod;
            sb.append(numbers[div]);
            size--;
        }
      
        sb.append(numbers[n % 3 == 0 ? n % 3 + 2 : n % 3 - 1]);
        answer = sb.toString();
        return answer;
    }
}
