package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_TreeDiameter {
    static int nodeNum;
    static List<Node>[] link;
    static int result;
    static int maxStart;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        link = new ArrayList[nodeNum+1];
        visited = new boolean[nodeNum+1];
        for(int i=0;i<nodeNum+1;i++) link[i] = new ArrayList<>();
        for(int i=0;i<nodeNum-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken(" "));
            int second = Integer.parseInt(st.nextToken(" "));
            int third = Integer.parseInt(st.nextToken(" "));
            link[first].add(new Node(second,third));
            link[second].add(new Node(first,third));
        }
        BFS(1,0);
        visited = new boolean[nodeNum+1];
        BFS(maxStart,0);
        System.out.print(result);
    }
    static void BFS(int start, int count){
        visited[start]=true;
        if((result=Math.max(result, count))==count){
            maxStart = start;
        }
        for(Node n : link[start]){
            int nowNode = n.node;
            if(visited[nowNode]) continue;
            int nowDist = n.dist;
            BFS(nowNode,count+nowDist);
        }
    }
    static class Node{
        int node;
        int dist;
        Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
