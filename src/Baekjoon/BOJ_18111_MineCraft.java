import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_MineCraft {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Initial init = input();
        solution(init.blocks, init.max, init.min, init.initB);
    }
    private static Initial input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int initBlocks = Integer.parseInt(st.nextToken());
        int[][] blocks = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int temp = Integer.parseInt(st.nextToken());
                blocks[i][j] = temp;
                max = Math.max(max,temp);
                min = Math.min(min,temp);
            }
        }
        Initial init = new Initial(blocks,max,min,initBlocks);
        return init;
    }
    private static void solution(int[][] blocks, int max, int min, int initB){
        int fastestTime = Integer.MAX_VALUE;
        int fastestHeight = 0;
        int N = blocks.length;
        int M = blocks[0].length;
        for(int i=max; i>=min; i--){
            int time = 0, remove=0, put=0;
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(blocks[j][k]<i){
                        put += i-blocks[j][k];
                    } else if(blocks[j][k]>i){
                        remove += blocks[j][k]-i;
                    }
                }
            }
            if(remove+initB<put) continue;
            time = remove*2+put;
            if(time<fastestTime){ fastestTime=time; fastestHeight=i; }
        }
        System.out.print(fastestTime+" "+fastestHeight);
    }
    private static class Initial{
        int[][] blocks; int min; int max; int initB;
        Initial(int[][] blocks, int max, int min, int initB){ this.blocks = blocks; this.max = max; this.min = min; this.initB = initB; }
    }
}
