import java.io.*;
import java.util.*;

public class BOJ_1707_BipartiteGraph {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        for(int i=0;i<testCnt;i++){
            isBipartiteGraph(init());
        }
        bw.flush();
    }
    private static List<Node> init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<nodeN;i++) nodes.add(new Node(i,0,new ArrayList<>()));
        for(int i=0;i<edgeN;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            nodes.get(from).adj.add(nodes.get(to));
            nodes.get(to).adj.add(nodes.get(from));
        }
        return nodes;
    }
    private static void isBipartiteGraph(List<Node> nodes) throws IOException {
        int[] nodesColor = new int[nodes.size()];
        for(int i=0;i<nodes.size();i++){
            Node first = nodes.get(i);
            if(nodesColor[i]!=0) continue;
            Queue<Node> q = new LinkedList<>();
            q.offer(first);
            nodesColor[i]=1;
            while(!q.isEmpty()){
                Node now = q.poll();
                int nowColor = nodesColor[now.idx];
                int nextColor = (nowColor==1)? 2:1;
                for(Node item : now.adj){
                    int itemColor = nodesColor[item.idx];
                    if(itemColor!=0&&(itemColor==nowColor)){
                        bw.write("NO\n"); return;
                    }
                    q.offer(item);
                    nodesColor[item.idx]=nextColor;
                    item.adj.remove(now);
                }
                now.adj.clear();
            }
        }
        bw.write("YES\n");
    }
    private static class Node{
        int idx; int color; List<Node> adj;
        Node(int idx, int color, List<Node> adj){ this.idx=idx; this.color=color; this.adj=adj; }
    }
}
