import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15489_PascalTriangle {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        ArrayList<Integer>[] initDp = init();
        solution(initDp);
    }
    private static ArrayList<Integer>[] init(){
        ArrayList<Integer>[] in = new ArrayList[30];
        in[0] = new ArrayList<>();
        in[0].add(1);
        for(int i=1;i<30;i++){
            in[i] = new ArrayList<>();
            in[i].add(1);
            for(int j=0;j<i-1;j++){
                in[i].add(in[i-1].get(j)+in[i-1].get(j+1));
            }
            in[i].add(1);
        }
        return in;
    }
    private static void solution(ArrayList<Integer>[] in) throws IOException {
        long sum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        if(W==1) {
            System.out.print(in[R-1].get(C-1)); return;
        }
        int firstX = R+W-1;
        for(int i=0;i<W;i++){
            sum+=in[firstX].get(C+i-1);
        }

        if(C!=1){
            for(int i=0;i<W;i++){
                sum-=in[R+i-1].get(C-2);
            }
        }

        System.out.print(sum);
    }
}
