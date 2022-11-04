class Solution {

    public int[] solution(String s) {
        int sum = 0;
        int cnt = 0;
        while(!s.equals("1")){
            int c = s.length();
            s = s.replace("0", "");
            sum += c - s.length();
            s = Integer.toBinaryString(s.length());
            cnt ++;
        }
        
        int[] answer = {cnt, sum};
        return answer;
    }
    
}