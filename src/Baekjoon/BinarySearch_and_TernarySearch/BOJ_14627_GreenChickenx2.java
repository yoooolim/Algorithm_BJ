package Baekjoon.BinarySearch_and_TernarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_14627_GreenChickenx2 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Long> lengths;
    public static void main(String[] args) throws IOException {
        lengths = new ArrayList<>();
        String[] strs = br.readLine().split(" ");
        int S = Integer.parseInt(strs[0]);
        int C = Integer.parseInt(strs[1]);
        long max = 0;
        for(int i=0;i<S;i++){
            long in = Long.parseLong(br.readLine());
            lengths.add(in);
            max = Long.max(max, in);
        }
        long left = 1; //left->0 => mid가 0이 될 수 있으니까 1로 설정
        long right = max;
        while(left<=right){
            long mid = (left+right)/2;
            int cnt = count(mid);
            if(cnt<C) right = mid-1;
            else left = mid+1;
        }
        long cnt = 0;
        long sum = 0;
        for(long item : lengths){
            sum+=(item%right);
            cnt+=(item/right);
        }
        sum+=(cnt-C)*right; //아예 통째로 남는 경우!!!가 있다~
        System.out.print(sum);
    }
    private static int count(long mid){
        int cnt = 0;
        for(long item : lengths){
            cnt+=(item/mid);
        }
        return cnt;
    }
}
