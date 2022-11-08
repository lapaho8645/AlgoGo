import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n > 0){
            if(n % 2 == 1){
                ans++;
                n -= 1;
            }else{
                n = n / 2;
            }
        }

        return ans;
    }
}

// K 칸 앞으로 전진 - K 만큼의 건전지 사용량
// (현재온 거리) * 2에 해당하는 위치로 순간 이동 - 건전지 줄지 않음
// 1 전진 -> 2 순간이동 -> 1 전진 - > 6 순간이동
// 1 전진 -> 2 -> 4 -> 16 -> 32 -> ...1024 -> 2048 -> 4096 
// 2500 1250 625 -> 624 312 156 78 39 -> 38 19 -> 18 9 -> 8 4 2 1 -> 0
