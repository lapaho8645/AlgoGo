import java.util.*;
class Solution {
    char [] alphabet = {'A', 'E', 'I', 'O' ,'U'};
    LinkedList<String> list = new LinkedList<>();
    public int solution(String word) {
        int answer = 0;
        dfs("", word);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public void dfs(String curWord, String word){
        if(curWord.length() > 5) return;
        
        list.add(curWord);
        
        if(word.equals(curWord)){
            return;
        }
       
        for(int i = 0; i < 5; i++){
            if(curWord.length() <= 4)
                dfs(curWord + alphabet[i], word);
        }
        
        
    }
}