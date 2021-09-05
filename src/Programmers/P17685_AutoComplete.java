package Programmers;

import java.util.Arrays;

public class P17685_AutoComplete {
    public static void main(String[] args){
        String[] words = {"word","war","warrior","world"};
        System.out.print(solution(words));
    }
    public static int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        for(int i=0;i<words.length;i++){
            String now = words[i];
            int length = 0;
            for(int j=0;j<now.length();j++){
                if(i!=0) {
                    if(isSame(now,words[i-1],j+1)) continue;
                }
                if(i!=words.length-1){
                    if(isSame(now,words[i+1],j+1)) continue;
                }
                length = j+1;
                break;
            }
            if(length==0) answer+=now.length();
            else answer+=length;
        }
        return answer;
    }
    private static boolean isSame(String a, String b, int idx){
        if(b.length()<idx) return false;
        if(a.substring(0,idx).equals(b.substring(0,idx))) return true;
        return false;
    }
}
