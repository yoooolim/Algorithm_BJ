package Programmers;

import java.util.Arrays;

public class NotCompletePerson {
    public static void main(String[] args){
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++){
            if(participant[i]!=completion[i]) {
                answer = participant[i];
                break;
            }
        }
        answer = participant[completion.length];
        return answer;
    }
}
