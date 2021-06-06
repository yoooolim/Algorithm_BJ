package Programmers.FullSearch;

public class P42842_Carpet {
    public static void main(String[] args){
        int brown = 10;
        int yellow = 2;
        int[] answer = solution(brown,yellow);
        System.out.print(answer[0]+" "+answer[1]);
    }
    static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int sum = brown + yellow;
        int sqrtSum = (int)Math.sqrt(sum);
        for(int i=2;i<=sqrtSum;i++){
            if(sum%i==0){
                int j = sum/i;
                if(2*i+2*j-4==brown){
                    if(i>=j){
                        answer[0]=i;
                        answer[1]=j;
                    }
                    else{
                        answer[0]=j;
                        answer[1]=i;
                    }
                }
            }
        }
        return answer;
    }
}
