import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_6118_HideAndSeek {
    static int N;
    final static int maxInt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Node head = input();
        solution(head);
    }
    private static Node input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<=N;i++){
            nodes.add(new Node(i,new ArrayList<>(),0));
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodes.get(A).adj.add(nodes.get(B));
            nodes.get(B).adj.add(nodes.get(A));
        }
        return nodes.get(1);
    }
    private static void solution(Node head){
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        distance[1]=0;
        for(int i=2;i<N+1;i++) distance[i]=maxInt;
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        visited[head.idx]=true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(Node item : now.adj){
                int nIdx = item.idx;
                if(visited[nIdx]) continue;
                visited[nIdx]=true;
                distance[nIdx] = Math.min(distance[nIdx], distance[now.idx]+1);
                item.dis = distance[now.idx]+1;
                q.offer(item);
            }
        }
        int hideIdx = -1;
        int maxDisCnt = 0;
        int maxDis = 0;
        for(int item : distance) if(item!=maxInt) maxDis = Math.max(maxDis,item);
        for(int i=1;i<=N;i++){
            if(distance[i]==maxDis) {
                if(maxDisCnt==0) hideIdx=i;
                maxDisCnt++;
            }
        }
        System.out.print(hideIdx+" "+maxDis+" "+maxDisCnt);
    }
    private static class Node{
        int idx; List<Node> adj; int dis;
        Node(int idx, List<Node> adj, int dis) { this.idx=idx; this.adj=adj; this.dis = dis; }
    }
}
