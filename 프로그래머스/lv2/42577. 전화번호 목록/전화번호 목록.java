import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String prev =phone_book[0];
        int length = phone_book[0].length();
        for(int i = 1; i < phone_book.length; i++){
            prev = phone_book[i-1];
            length = prev.length();
            if(phone_book[i].length() < length){
                continue;
            }
            if(phone_book[i].substring(0, length).equals(prev)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}