package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2531_RotatingSushi {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] sushi;
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        for(int i=0;i<N;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
    }
    private static void solution(){
        int left = 0, right = k-1, maxSushi = 0;
        while(left<N){
            Set<Integer> set = new HashSet<>();
            if(left%N>right%N){
                for(int i=0;i<=right%N;i++) set.add(sushi[i]);
                for(int i=left;i<N;i++) set.add(sushi[i]);
            } else {
                for (int i = left; i <= right; i++) set.add(sushi[i]);
            }
            set.add(c);
            maxSushi = Math.max(maxSushi, set.size());
            left++;
            right++;
        }
        System.out.print(maxSushi);
    }
}
