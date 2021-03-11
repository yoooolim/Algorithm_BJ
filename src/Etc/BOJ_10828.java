package Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(" ");
            if(cmd.equals("push")) s.push(Integer.parseInt(st.nextToken(" ")));
            else if(cmd.equals("pop")) {
                if(s.empty()==true){
                    bw.write(-1+"\n");
                    continue;
                }
                bw.write(s.pop()+"\n");
            }
            else if(cmd.equals("size")) bw.write(s.size());
            else if(cmd.equals("empty")) {
                if(s.empty()==true) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            else if(cmd.equals("top")) {
                if(s.empty()==true){
                    bw.write(-1+"\n");
                    continue;
                }
                int top = s.pop();
                bw.write(top+"\n");
                s.push(top);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
