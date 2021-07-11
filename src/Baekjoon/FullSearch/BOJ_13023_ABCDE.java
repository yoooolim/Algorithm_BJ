package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
    static int peopleN, friedN;
    static boolean[][] isFriend;
    static boolean[][] isVisited;
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleN = Integer.parseInt(st.nextToken(" "));
        friedN = Integer.parseInt(st.nextToken(" "));
        if(friedN<4){
            System.out.print("0"); return;
        }
        isFriend = new boolean[peopleN][peopleN];
        isVisited = new boolean[peopleN][peopleN];

        for(int i=0;i<friedN;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            isFriend[a][b]=true;
            isFriend[b][a]=true;
        }
        for (int i=0;i<peopleN;i++){
            DFS(i,0);
        }
        System.out.print("0"); System.exit(0);
    }
    static void DFS(int now, int depth){
        if(depth==3){
            System.out.print("1"); System.exit(0);
        }
        for(int i=0;i<peopleN;i++){
            if(!isVisited[now][i]&&isFriend[now][i]) continue;
            isVisited[now][i]=true;
            DFS(i,depth+1);
        }
    }
}
