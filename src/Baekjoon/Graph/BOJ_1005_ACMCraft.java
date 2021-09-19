package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class BOJ_1005_ACMCraft {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] pointInfo;
    static int[] pointed, timeSave;
    static int node, edge, destination;
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            input();
            solution();
        }
        System.out.print(sb);
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        pointInfo = new List[node+1];
        pointed = new int[node+1];
        timeSave = new int[node+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=node;i++){
            timeSave[i] = Integer.parseInt(st.nextToken());
            pointInfo[i] = new ArrayList<>();
        }
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pointed[to]++;
            pointInfo[from].add(to);
        }
        destination = Integer.parseInt(br.readLine());
    }
    private static void solution(){
        long min = Long.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=node;i++){ //나를 찌르는 친구들이 없으면 q에 넣기
            if(pointed[i]==0) {
                if (i == destination) {
                    min = Long.min(min, timeSave[i]);
                    continue;
                }
                q.offer(i);
            }
        }
        long[] bfTime = new long[node+1];

        while(!q.isEmpty()){
            int nowIdx = q.poll();
            long nowBfT = bfTime[nowIdx]+timeSave[nowIdx];
            for(int item : pointInfo[nowIdx]){
                pointed[item]--;
                bfTime[item] = Long.max(bfTime[item],nowBfT);
                if(pointed[item]==0) {
                    if(item==destination){
                        min = Long.min(min,bfTime[item]+timeSave[item]);
                        break;
                    }
                    q.offer(item);
                }
            }
        }
        sb.append(min+"\n");
    }
    private static class Node{
        int idx; long bfT;
        Node(int idx, long bfT){ this.idx = idx; this.bfT = bfT; }
    }
}
