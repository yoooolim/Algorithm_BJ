import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_MatrixPow {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n; static long powNum;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); powNum = Long.parseLong(st.nextToken());
        matrix = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) matrix[i][j]=Integer.parseInt(st.nextToken());
        }
    }
    private static void solution(){
        int[][] ans = matrix;
        String binaryString = Long.toBinaryString(powNum);
        for(int i=1;i<binaryString.length();i++){
            if((int)(binaryString.charAt(i)-'0')%2==0) ans = matrixMulti(ans,ans);
            else{ ans = matrixMulti(ans,ans); ans = matrixMulti(ans,matrix); }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) sb.append(ans[i][j]%1000+" ");
            //%1000을 하는 이유 : powNum값이 1일때, 입력으로 1000이 들어올 수 있다 ==> 1000이 아닌 0을 출력해야 하기 때문
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static int[][] matrixMulti(int[][] ori, int[][] mul){
        int[][] answer = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++) { answer[i][j] += ori[i][k] * mul[k][j]; answer[i][j]%=1000; }
            }
        }
        return answer;
    }
}
