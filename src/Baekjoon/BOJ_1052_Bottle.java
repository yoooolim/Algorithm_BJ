import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1052_Bottle {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] input = (br.readLine()).split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        //if(N<K) { System.out.print(K-N); } //가지고 있는 물병보다 만들어야 하는 물병이 큰 경우 -> 필요한 만큼 구매
        if(N<=K) { System.out.print(0); } //가지고 있는 물병과 만들어야 하는 물병이 동일 -> 가만히 있어
        else{ //가지고 있는 물병이 만들어야 하는 물병보다 큰 경우 ->
            int oneNum = getOne(N);
            if(oneNum<=K){ System.out.print(0); } //물을 사지 않고 이동만으로 K개로 만들 수 있다
            else{
                int copyN = N;
                while(getOne(copyN)>K){
                    copyN+=(copyN&-copyN);
                }
                System.out.print(copyN-N);
            }
        }
    }
    private static int getOne(int N){
        int count = 0;
        while(N>0){
            N&=N-1;
            count++;
        }
        return count;
    }
}
