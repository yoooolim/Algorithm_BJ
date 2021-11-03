import java.io.*;

public class BOJ_15651_NAndM3 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        permutation(N,M,0,new int[M]);
        bw.flush();
    }
    public static void permutation (int N, int length, int depth, int[] seq) throws IOException {
        if(length==depth){
            for(int item : seq) bw.write(item+" ");
            bw.write("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            seq[depth] = i;
            permutation(N, length,depth+1,seq);
        }
    }
}
