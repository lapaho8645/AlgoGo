import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++){
            int idx = -1;
            boolean check = true;
            for(int j = 0; j < skill_trees[i].length(); j++){
                int skillIdx = skill.indexOf(skill_trees[i].charAt(j));

                if(skillIdx != -1){
                    if(skillIdx != idx+1){
                        check = false;
                        break;
                    }
                    idx = skillIdx;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}