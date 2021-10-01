import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190_Snake {
    final static int[] dirX = {-1,0,1,0}, dirY = {0,1,0,-1};
    public static void main(String[]args) throws IOException {
        Queue<Cmd> cmds = new LinkedList<>();
        boolean[][] apples = input(cmds);
        solution(apples,cmds);
    }
    private static boolean[][] input(Queue<Cmd> cmds) throws IOException {
        boolean[][] apples;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        apples = new boolean[N+1][N+1];
        int appleCnt = Integer.parseInt(br.readLine());
        for(int i=0;i<appleCnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apples[x][y]=true;
        }
        int cmdCnt = Integer.parseInt(br.readLine());
        for(int i=0;i<cmdCnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int turn = (st.nextToken().equals("D"))? 1:0;
            cmds.offer(new Cmd(time,turn));
        }
        return apples;
    }
    private static void solution(boolean[][] apples,Queue<Cmd> cmds){
        ArrayList<Point> snake = new ArrayList<>();
        int N = apples.length-1;
        boolean[][] nowSnake = new boolean[N+1][N+1];
        snake.add(new Point(1,1));
        nowSnake[1][1]=true;
        int bfTime = 0;
        int nowDir = 1;
        int move = 0;
        boolean isFinish = false;
        while(!cmds.isEmpty()){
            Cmd nowCmd = cmds.poll();
            if(cmds.isEmpty()&&!isFinish){
                isFinish=true;
                cmds.add(new Cmd(10001,3)); //그대로 쭉 가라
            }
            int during = nowCmd.time-bfTime;
            bfTime= nowCmd.time;
            for(int i=0;i<during;i++){
                Point head = snake.get(0);
                int nx = head.x+dirX[nowDir];
                int ny = head.y+dirY[nowDir];
                move++;
                if(nx<1||ny<1||nx>N||ny>N||nowSnake[nx][ny]) { System.out.print(move); return; } //충돌하는 경우
                snake.add(0,new Point(nx,ny));//add new Head
                nowSnake[nx][ny]=true;
                if(!apples[nx][ny]) { //사과를 먹지 않았다면 꼬리를 없앤다
                    Point tail = snake.get(snake.size()-1);
                    nowSnake[tail.x][tail.y]=false;
                    snake.remove(snake.size()-1);
                } else apples[nx][ny]=false; //사과를 먹으면 사과가 없어진다
            }
            if(nowCmd.turn==0) nowDir=(nowDir+3)%4;
            else if(nowCmd.turn==1) nowDir=(nowDir+1)%4;
        }
        System.out.print(move);
    }
    private static class Point{
        int x; int y; Point(int x, int y){ this.x=x; this.y=y; }
    }
    private static class Cmd{
        int time; int turn;//0일경우 좌측, 1일경우 우측
        Cmd(int time, int turn) { this.time=time; this.turn=turn; }
    }
}
