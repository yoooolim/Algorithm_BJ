package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_10866_Deque {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            String cmd = br.readLine();
            if(cmd.charAt(0)=='p'&&cmd.charAt(1)=='u'){
                if(cmd.charAt(5)=='f') dq.offerFirst(Integer.parseInt(cmd.substring(11)));
                else dq.offerLast(Integer.parseInt(cmd.substring(10)));
            }
            else if(cmd.charAt(0)=='p') {
                if(dq.isEmpty()) sb.append(-1+"\n");
                else if(cmd.charAt(5)=='f') sb.append(dq.pollFirst()+"\n");
                else sb.append(dq.pollLast()+"\n");
            }
            else if(cmd.charAt(0)=='s') sb.append(dq.size()+"\n");
            else if(cmd.charAt(0)=='e') sb.append(dq.isEmpty()?1+"\n":0+"\n");
            else if(cmd.charAt(0)=='f') sb.append(dq.isEmpty()?-1+"\n":dq.getFirst()+"\n");
            else if(cmd.charAt(0)=='b') sb.append(dq.isEmpty()?-1+"\n":dq.getLast()+"\n");
        }
        System.out.print(sb);
    }
}
