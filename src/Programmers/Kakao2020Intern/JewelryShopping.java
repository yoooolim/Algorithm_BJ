package Programmers.Kakao2020Intern;

import java.util.ArrayList;

public class JewelryShopping {
    public static void main(String[] args) throws Exception{
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer = solution(gems);
        System.out.println(answer[0]+" "+answer[1]);
    }
    public static int[] solution(String[] gems) {
        int[] answer = {0,0};
        int[] count = new int[gems.length];
        int[] end = new int[gems.length];
        ArrayList[] dp = new ArrayList[gems.length];
        for(int i=0;i<gems.length;i++){
            int max=0;
            dp[i]=new ArrayList();
            dp[i].add(gems[i]);
            count[i]++;
            end[i]=i;
            for(int j=i+1;j<gems.length;j++){
                if(dp[i].indexOf(gems[j])==-1){
                    count[i]++;
                    dp[i].add(gems[j]);
                    if((max=Math.max(max,count[i]))==count[i]){
                        end[i]=j;

                    }
                }
            }
        }
        int max = 0;
        int maxLength = 0;
        for(int i=0;i<gems.length;i++){
            if(max<count[i]||(max==count[i]&&end[i]-i<maxLength)){
                max=count[i];
                answer[0]=i+1;
                answer[1]=end[i]+1;
                maxLength=end[i]-i;
            }
        }
        return answer;
    }
}
