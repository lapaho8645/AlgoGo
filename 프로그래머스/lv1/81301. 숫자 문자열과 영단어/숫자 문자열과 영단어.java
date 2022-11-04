class Solution {
    
    public int solution(String s) {
        String [] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < english.length; i++){
            s = s.replace(english[i], Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}