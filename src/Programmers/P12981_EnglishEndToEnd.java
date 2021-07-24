import java.util.HashSet;

public class P12981_EnglishEndToEnd {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0,0};
            HashSet<String> checkOverlap = new HashSet<>();
            checkOverlap.add(words[0]);
            for(int i=1;i<words.length;i++){
                checkOverlap.add(words[i]);
                if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)
                        ||checkOverlap.size()!=i+1){
                    answer[0]=i%n+1;
                    answer[1]=i/n+1;
                    break;
                }
            }
            return answer;
        }
    }
}
