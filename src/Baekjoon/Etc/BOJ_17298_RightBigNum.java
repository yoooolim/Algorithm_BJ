package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_RightBigNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack<>();
        Stack<Integer> right = new Stack<>();
        Stack<Integer> ans = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr.push(Integer.parseInt(st.nextToken(" ")));

        while(!arr.isEmpty()){
            if(right.isEmpty()) {
                right.push(arr.pop()); ans.push(-1); continue;
            }
            int now = arr.pop();
            int check = right.pop();
            while(now>=check&&!right.isEmpty()){
                check = right.pop();
            }
            if(now>=check) {
                right.push(now); ans.push(-1 );
            }
            else{
                right.push(check); right.push(now); ans.push(check);
            }
        }
        while(!ans.isEmpty()){
            sb.append(ans.pop()+" ");
        }
        System.out.print(sb);
    }
}
