class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) 
            if (skill.indexOf(s.replaceAll(String.format("[^%s]", skill), "")) == 0) 
                answer++;
        return answer;
    }
}