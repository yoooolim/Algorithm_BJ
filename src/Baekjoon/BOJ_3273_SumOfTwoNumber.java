import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3273_SumOfTwoNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i]= Integer.parseInt(in[i]);
        }
        Arrays.sort(numbers);
        int want = Integer.parseInt(br.readLine());

        int left=0,right=n-1;
        int wantCnt = 0;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum>want){
                right--;
            } else if(sum<want){
                left++;
            } else {
                wantCnt++;
                left++;
                right--;
            }
        }
        System.out.print(wantCnt);
    }
}
