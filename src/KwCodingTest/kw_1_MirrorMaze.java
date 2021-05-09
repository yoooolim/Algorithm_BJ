package KwCodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kw_1_MirrorMaze {
    static int r,c;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dx= {1,0,-1,0};
    static int[] dy= {0,-1,0,1}; //↓ ← ↑ →
    public static void main(String[] args)throws Exception{
        //initializtion
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken(" "));
        c = Integer.parseInt(st.nextToken(" "));
        map = new char[r][c];
        visit = new boolean[r][c][4];
        for(int i=0;i<r;i++){
            String temp = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=temp.charAt(j);
            }
        }
        //bfs search
        PriorityQueue<Mirror> q = new PriorityQueue<>();
        q.offer(new Mirror(0,0,1,0)); //아래로 내려가는 경우
        q.offer(new Mirror(0,0,1,3)); //오른쪽으로 이동하는 경우

        while(!q.isEmpty()){
            Mirror m = q.poll();
            int x = m.x;
            int y = m.y;
            int cnt = m.cnt;
            int dir = m.dir;
            m.cnt++;

            if(visit[x][y][dir])continue;
            visit[x][y][dir]=true;

            if(x==r-1&&y==c-1){
                System.out.print(m.cnt);
                System.exit(0);
            }
            int nx=x+dx[dir];
            int ny=y+dy[dir];
            if(!isPossible(nx,ny)) continue; //범위 넘거나 벽이 있는지 검사
            if(map[nx][ny]=='P'){
                int nDir = 0;
                if(dir==0||dir==2){ // ↓, ↑ 일 경우 ←, →로 변경 가능
                    q.offer(new Mirror(nx,ny,cnt,1));
                    q.offer(new Mirror(nx,ny,cnt,3));
                }
                else{ // ←, → 일 경우 ↓, ↑ 로 변경 가능
                    q.offer(new Mirror(nx,ny,cnt,0));
                    q.offer(new Mirror(nx,ny,cnt,2));
                }
            }
            //거울 설치 안하고 가기
            q.offer(new Mirror(nx,ny,m.cnt,m.dir));
        }
        System.out.print("-1");
    }

    public static boolean isPossible(int nx,int ny) {
        if(nx<0||ny<0||nx>=r||ny>=c||
                map[nx][ny]=='*') return false;
        return true;
    }

    static class Mirror implements Comparable<Mirror>{
        int x;
        int y;
        int cnt;
        int dir;
        public Mirror(int x, int y, int cnt, int dir) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
        @Override
        public int compareTo(Mirror o) {
            return this.cnt-o.cnt;
        }

    }
}
