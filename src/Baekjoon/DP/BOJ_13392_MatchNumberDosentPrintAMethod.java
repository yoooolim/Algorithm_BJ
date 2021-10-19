import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13392_MatchNumberDosentPrintAMethod {
    public static void main(String[] args) throws IOException {
        //initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String from = "f"+br.readLine(); //index 1부터 시작할거니까 앞에 쓰레기 값을 넣어준다
        String to = "t"+br.readLine();
        int[][] dp = new int[10001][10];
        for(int i=1;i<=N;i++) for(int j=0;j<10;j++) dp[i][j] = Integer.MAX_VALUE; //최대값으로 초기화
        for(int i=0;i<10;i++) dp[0][i]=i; //0번째 숫자나사 j만큼 돌리면 회전 횟수는 j (초기화)
        //dp start
        for(int i=1;i<=N;i++){ //숫자나사 index 하나씩 높여가면서
            int diff = (to.charAt(i)-'0')-(from.charAt(i)-'0');
            for(int j=0;j<10;j++){ //왼쪽으로 회전 횟수를 하나씩 높여가면서
                int left = (diff-j+20)%10; // from[i]+j(왼쪽으로 j만큼 돌렸을 때) => to[i]가 되어야 하니까
                int right = 10-left;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+right); //위에서 돌린만큼 돌아가고, 오른쪽으로 돌리느냐!
                dp[i][(diff+10)%10] = Math.min(dp[i][(diff+10)%10], dp[i-1][j]+left); //위쪽에서 돌린만큼 돌아가고, 왼쪽으로 돌리느냐!
            }
        }
        int minTurn = Integer.MAX_VALUE;
        for(int i=0;i<10;i++) minTurn = Math.min(minTurn,dp[N][i]);
        System.out.print(minTurn);
    }
}
