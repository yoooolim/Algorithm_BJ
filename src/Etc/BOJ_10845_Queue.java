package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845_Queue {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int rem = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(" ");
            if(cmd.equals("push")){
                int in = Integer.parseInt(st.nextToken(" "));
                q.offer(in);
                rem=in;
            }
            else{
                switch (cmd.charAt(0)) {
                    case ('p'):
                        if(q.isEmpty()) sb.append(-1+"\n");
                        else sb.append(q.poll()+"\n");
                        break;
                    case('e'):
                        if(q.isEmpty()) sb.append(1+"\n");
                        else sb.append(0+"\n");
                        break;
                    case('s'):
                        sb.append(q.size()+"\n");
                        break;
                    case('f'):
                        if(q.isEmpty()) sb.append(-1+"\n");
                        else sb.append(q.peek()+"\n");
                        break;
                    case('b'):
                        if(q.isEmpty()) sb.append(-1+"\n");
                        else sb.append(rem+"\n");
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}
