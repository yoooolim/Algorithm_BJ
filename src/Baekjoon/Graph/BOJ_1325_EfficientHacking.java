package Baekjoon.Graph;
import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_1325_EfficientHacking
{
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws java.lang.Exception
    {
        solution();
    }
    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int comNum = Integer.parseInt(st.nextToken());
        int reliability = Integer.parseInt(st.nextToken());
        List<Computer> coms = new ArrayList<>();

        for(int i=0;i<comNum;i++){
            coms.add(new Computer(i+1,new ArrayList<Computer>()));
        }

        for(int i=0;i<reliability;i++){
            st = new StringTokenizer(br.readLine());
            int underling = Integer.parseInt(st.nextToken());
            int boss = Integer.parseInt(st.nextToken());
            coms.get(boss-1).children.add(coms.get(underling-1));
        }

        int max = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<comNum;i++){
            int childNum = 0;
            Computer nowNode = coms.get(i);
            if(nowNode.children.size()==0){//leaf node
                if(max==0) answer.add(nowNode.idx);
            }
            Queue<Computer> q = new LinkedList<>();
            boolean[] visited = new boolean[comNum+1];
            q.offer(nowNode);
            visited[nowNode.idx]=true;
            //for(int j=0;j<coms.get(i).children.size();j++) q.offer(coms.get(i).children);
            while(!q.isEmpty()){
                Computer now = q.poll();
                for(Computer item : now.children){
                    if(visited[item.idx]==true) continue;
                    visited[item.idx]=true;
                    q.offer(item);
                    childNum++;
                }
            }
            if(childNum>max){ max = childNum; answer = new ArrayList<>(); answer.add(nowNode.idx); }
            else if(childNum==max) { answer.add(nowNode.idx); }
        }
        Collections.sort(answer);
        for(int item : answer){
            System.out.print(item+" ");
        }
    }
    private static class Computer{
        int idx;
        List<Computer> children;
        Computer(int idx, List<Computer> children){
            this.idx = idx; this.children = children;
        }
    }
}