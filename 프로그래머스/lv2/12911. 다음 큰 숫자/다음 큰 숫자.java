import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        
        while(true){
            n++;
            if(cnt == Integer.bitCount(n))
                break;
        }
        int answer = n;
        return answer;
    }
}