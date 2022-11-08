class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length ; i++){
            answer = lcm(answer, arr[i]);
           
        }
        return answer;
    }
    public int gcd(int a, int b){
        int r = 0;
        while(b > 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}