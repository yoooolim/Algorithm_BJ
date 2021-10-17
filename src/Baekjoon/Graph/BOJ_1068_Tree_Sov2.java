package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1068_Tree_Sov2 {
    static int cnt = 0, remove = 0;
    public static void main(String[] args) throws IOException {
        solution();
    }
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<N;i++) nodes.add(new Node(i,new ArrayList<>()));
        String[] par = br.readLine().split(" ");
        Node head = null;
        for(int i=0;i<N;i++) {
            int parIdx = Integer.parseInt(par[i]);
            if(parIdx==-1) head = nodes.get(i);
            else nodes.get(parIdx).adj.add(nodes.get(i));
        }
        remove = Integer.parseInt(br.readLine());
        getLeaf(head);
        System.out.print(cnt);
    }
    private static void getLeaf(Node now){
        if(now.idx==remove) return;
        if(now.adj.isEmpty()||(now.adj.size()==1&&now.adj.get(0).idx==remove)){
            cnt++; return;
        }
        for(Node item : now.adj) getLeaf(item);
    }
    private static class Node{
        int idx; List<Node> adj;
        Node(int idx, List<Node> adj){
            this.idx = idx; this.adj = adj;
        }
    }
}
