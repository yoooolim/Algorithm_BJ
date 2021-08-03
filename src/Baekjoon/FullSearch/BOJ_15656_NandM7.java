import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656_NandM7 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n,c;
    static int[] sequence;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input()throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        c = Integer.parseInt(st.nextToken(" "));
        st = new StringTokenizer(br.readLine());
        sequence = new int[n];
        for(int i=0;i<n;i++) sequence[i] = Integer.parseInt(st.nextToken(" "));
        Arrays.sort(sequence);
    }
    private static void solution(){
        int[] array = new int[c];
        DFS(0,c,array);
        System.out.print(sb);
    }
    private static void DFS(int depth, int length, int[] array){
        if(depth==length){
            for(int i:array) sb.append(i+" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++){
            array[depth]=sequence[i];
            DFS(depth+1,length,array);
        }
    }
}
