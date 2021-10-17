package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2491_Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            seq[i] = Integer.parseInt(str[i]);
        }
        int max = 0;
        int[] dpUpper = new int[N];
        int[] dpDown = new int[N];
        dpUpper[0]=1; dpDown[0]=1;
        for(int i=1;i<N;i++){
            if(seq[i-1]<=seq[i]) dpUpper[i]=dpUpper[i-1]+1;
            else {
                max = Math.max(dpUpper[i-1],max);
                dpUpper[i] = 1;
            }
        }
        for(int i=1;i<N;i++){
            if(seq[i-1]>=seq[i]) dpDown[i]=dpDown[i-1]+1;
            else {
                max = Math.max(dpDown[i-1],max);
                dpDown[i] = 1;
            }
        }
        max = Math.max(dpUpper[N-1],max);
        max = Math.max(dpDown[N-1],max);
        System.out.print(max);
    }
}
