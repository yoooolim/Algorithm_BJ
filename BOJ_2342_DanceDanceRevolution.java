import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2342_DanceDanceRevolution {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> steps;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        input();
        System.out.print(solution(0,0,0,steps.size()));
    }
    private static void input() throws IOException {
        steps = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 0;
        while((temp = Integer.parseInt(st.nextToken()))!=0){
            steps.add(temp);
        }
        dp = new int[5][5][steps.size()+1];
    }
    private static int solution(int left, int right, int depth, int length) {
        if(length<=depth) return 0;
        if(dp[left][right][depth]!=0) return dp[left][right][depth];
        int nextStep = steps.get(depth);
        return dp[left][right][depth]=Math.min(solution(nextStep,right,depth+1,length)+scoring(left,nextStep),
                solution(left,nextStep,depth+1,length)+scoring(right,nextStep) );
    }
    private static int scoring(int before, int next){
        if(before==0) return 2;
        if(before==next) return 1;
        if((before+next)%2!=0) return 3;
        return 4;
    }
}
