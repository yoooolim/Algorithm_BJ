package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1206_DFSandBFS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));
        int s = Integer.parseInt(st.nextToken(" "));
        boolean[][] map = new boolean[n][n];
        boolean[] v = new boolean[n];
        boolean[] ins = new boolean[n];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            map[a-1][b-1]=true;
            map[b-1][a-1]=true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        v[s-1]=true;
        while(!stack.empty()){
            int node = stack.pop();
            if(ins[node-1]) continue;
            ins[node-1]=true;
            v[node-1]=true;
            System.out.print(node+" ");
            for(int j=n-1;j>=0;j--){
                if(map[node-1][j]==true&&v[j]==false) {
                    stack.push(j + 1);
                }
            }
        }
        System.out.print("\n");
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        v[s-1]=false;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int j=0;j<n;j++){
                if(map[node-1][j]==true&&v[j]==true) {
                    q.offer(j + 1);
                    v[j]=false;
                }
            }
        }
    }

}
