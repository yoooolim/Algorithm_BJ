package Baekjoon.Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1167_Diameter {
    static int nodeNum;
    static List<Node>[] link;
    static boolean[] visited;
    static int result;
    static int lastNode;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        link = new ArrayList[nodeNum+1];
        visited = new boolean[nodeNum+1];
        for(int i=0;i<nodeNum+1;i++) link[i] = new ArrayList<>();
        for(int i=1;i<nodeNum+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken(" "));
            int temp = 0;
            while((temp=Integer.parseInt(st.nextToken(" ")))!=-1){
                link[head].add(new Node(temp,Integer.parseInt(st.nextToken(" "))));
                //link[temp-1].add(new Node(i+1,length));
            }
        }
        getMaxLength(1,0);

        result = 0;
        visited = new boolean[nodeNum+1];
        getMaxLength(lastNode,0);

        System.out.print(result);
    }

    static void getMaxLength(int start, int sum){
        visited[start]=true;
        if((result = Math.max(result,sum))==sum) lastNode = start;

        for(int i=0;i<link[start].size();i++){
            int nowNode = link[start].get(i).node;
            int nowDist = link[start].get(i).dist;
            if(visited[nowNode]) continue;
            getMaxLength(nowNode,sum+nowDist);
        }
    }

    static class Node{
        int node,dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
