package Baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068_Tree {
    static int nodeSize;
    static int[] parentNode;
    static int removeNode;
    static int rootNum;
    public static void main(String[] args)throws Exception{
        //input and initialization
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        nodeSize = Integer.parseInt(br.readLine());
        parentNode = new int[nodeSize];
        rootNum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<nodeSize;i++){
            parentNode[i]=Integer.parseInt(st.nextToken(" "));
            if(parentNode[i]==-1) rootNum = i;
        }
        removeNode = Integer.parseInt(br.readLine());
        if(removeNode==rootNum) {
            System.out.print("0");
            System.exit(0);
        }

        //remove bfs
        bfs1(removeNode);

        //bfs start
        System.out.print(bfs2(rootNum));
    }
    static void bfs1(int node){
        parentNode[node]=-2;
        for(int i=0;i<nodeSize;i++){
            if(parentNode[i]==node) bfs1(i);
        }
    }
    static int bfs2(int node){
        int count = 0;
        boolean isDFSin = false;
        for(int i=0;i<nodeSize;i++){
            if(parentNode[i]!=node) continue;//i번째의 부모가 node가 아니다
            count+=bfs2(i);
            isDFSin=true;
        }
        if(isDFSin==false) count++;
        return count;
    }
}
