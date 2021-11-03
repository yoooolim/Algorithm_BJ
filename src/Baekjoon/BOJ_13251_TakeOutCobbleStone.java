import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13251_TakeOutCobbleStone {
    public static void main(String[] args) throws IOException {
        //input and initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()), sum=0;
        String[] input = br.readLine().split(" ");
        int[] seq = new int[M];
        for(int i=0;i<M;i++) {
            seq[i] = Integer.parseInt(input[i]);
            sum+=seq[i];
        }
        int K = Integer.parseInt(br.readLine());
        //get probability
        double answer = 0.0;
        if(M==1||K==1) System.out.print(1.0);
        else {
            for(int item : seq){
                if(item>=K){
                    double subProb=1.0;
                    for(int i=0;i<K;i++){
                        subProb*=(double)(item-i)/(double)(sum-i);
                    }
                    answer+=subProb;
                }
            }
            System.out.print(answer);
        }
    }
}
