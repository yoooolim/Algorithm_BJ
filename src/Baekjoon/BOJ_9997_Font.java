import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9997_Font {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int allIn = (int)Math.pow(2,26)-1;
    static int testSentences = 0;
    public static void main(String[] args) throws IOException {
        int[] in = input();
        int N = in.length;
        for(int i=1;i<=N;i++) {
            int[] arr = new int[i];
            comb(in, arr, 0, N, i,0);
        }
        System.out.print(testSentences);
    }
    private static int[] input() throws IOException {
        int senNum = Integer.parseInt(br.readLine());
        int[] sentences = new int[senNum];
        for(int i=0;i<senNum;i++){
            String str = br.readLine();
            int sum=0;
            boolean[] isIn = new boolean[26];
            for(int j=0;j<str.length();j++){
                int temp = str.charAt(j)-'a';
                if(!isIn[temp]){ isIn [temp]=true; sum+=Math.pow(2,temp); }
            }
            sentences[i]=sum;
        }
        return sentences;
    }
    private static void comb(int[] ori, int[] arr, int start, int n, int r, int depth){
        if(r==0){
            int or = 0;
            for(int i=0;i<depth;i++) { or = or | arr[i]; }
            if(or==allIn) { testSentences++; }
            return;
        }
        for(int i=start;i<n;i++){
            arr[depth]=ori[i];
            comb(ori,arr,i+1,n,r-1,depth+1);
            arr[depth]=0;
        }
    }
}
