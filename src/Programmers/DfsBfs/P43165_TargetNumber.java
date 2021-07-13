package Programmers.DfsBfs;

public class P43165_TargetNumber {
    static int answer;
    public static void main(String[] args) throws Exception{
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        solution(numbers,target);
    }
    static public int solution(int[] numbers, int target) {
        answer = 0;
        boolean[] isPlus = new boolean[numbers.length];
        DFS(isPlus, 0, target, numbers);
        return answer;
    }
    static void DFS(boolean[] isPlus, int depth, int target,  int[] numbers){
        if(depth == numbers.length){
            int sum  =  0;
            for(int i=0;i<depth;i++){
                if(isPlus[i]) sum+=numbers[i];
                else sum-=numbers[i];
            }
            if(sum == target) answer++;
            return;
        }
        DFS(isPlus, depth+1, target, numbers);
        isPlus[depth]=true;
        DFS(isPlus, depth+1, target, numbers);
    }
}
