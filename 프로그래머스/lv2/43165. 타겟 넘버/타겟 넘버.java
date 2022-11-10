class Solution {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0, 0);
       
        return cnt;
    }
    
    public void dfs(int target, int [] numbers, int i, int sum){
    
        if(i == numbers.length){
            if(sum == target){
                cnt++;
                return;
            }else{
                return;
            }
        }  
        dfs(target, numbers, i+1, sum - numbers[i]);
        dfs(target, numbers, i+1, sum + numbers[i]);
    }
}