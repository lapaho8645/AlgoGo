import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % k);
            n = n / k;
        }
        String input = sb.reverse().toString();
        String [] arr = input.split("0");
        for(String s : arr){
            if(!s.equals("") && isPrime(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long num){
        if(num == 1)
            return false;
        if(num == 2)
            return true;
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
// k진수로 바꾸고 0으로 split한 후 소수인지 확인
