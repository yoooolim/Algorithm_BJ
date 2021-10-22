import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169_ControlRobot_DP {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M,maxValue;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        input();
        dpSolve();
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxValue=Integer.MIN_VALUE;
        board = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    private static void dpSolve(){
        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        //첫줄은 왼 -> 오 밖에 경우가 없다
        for(int i=1;i<M;i++) dp[0][i] = dp[0][i-1] + board[0][i];
        for(int i=1;i<N;i++){ //두번째 줄 부터는
            int[] goRight = new int[M];
            int[] goLeft = new int[M];
            //위에서 내려와서
            for(int j=0;j<M;j++) {
                int temp = dp[i - 1][j] + board[i][j];
                goRight[j] = temp; goLeft[j] = temp;
            }
            //중복이 안되기 때문에 따로 계산해야 한다
            for(int j=1;j<M;j++) goRight[j] = Math.max(goRight[j],goRight[j-1]+board[i][j]);//오른쪽으로만 이동하는 경우
            for(int j=M-2;j>=0;j--) goLeft[j] = Math.max(goLeft[j],goLeft[j+1]+board[i][j]);//왼쪽으로만 이동하는 경우
            for(int j=0;j<M;j++) dp[i][j] = Math.max(goRight[j],goLeft[j]);//둘 중 큰 경우를 택한다
        }
        System.out.print(dp[N-1][M-1]);
    }
}
