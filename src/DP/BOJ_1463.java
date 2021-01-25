package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] count = new long[n+1];
        count[1]=0;
        for(int i=2;i<n+1;i++){
            count[i]=count[i-1]+1; //전 숫자에서 최대 한번의 연산을 더 해야함
            if(i%3==0) count[i]=min(count[i],count[i/3]+1);
            if(i%2==0) count[i]=min(count[i],count[i/2]+1); //else if가 아닌 if를 사용해야 함! (-> 6의 배수일 경우도 고려)
        }
        System.out.println(count[n]);
        br.close();
    }

    public static long min(long a,long b){
        if(a<b) return a;
        return b;
    }
}
