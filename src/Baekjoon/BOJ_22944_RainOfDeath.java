import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_22944_RainOfDeath {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int minMove = Integer.MAX_VALUE;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        //input
        int Sx=0, Sy=0, Ex=0, Ey=0;
        List<Point> umbrellas = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                char ch = str.charAt(j);
                if(ch=='U'){
                    umbrellas.add(new Point(i,j));
                } else if(ch=='S') {
                    Sx=i; Sy=j;
                } else if(ch=='E') {
                    Ex=i; Ey=j;
                }
            }
        }
        solution(Sx,Sy,Ex,Ey,H,0,0,umbrellas,D);
        if(minMove==Integer.MAX_VALUE) minMove=-1;
        System.out.print(minMove);
    }
    private static void solution(int x, int y, int ex, int ey, int health, int umb, int count, List<Point> umbs, int D){
        //더이상 우산을 거치지 않고 바로 갈 수 있는가?
        int dis = Math.abs(ex-x)+Math.abs(ey-y);
        if(dis<=health+umb){
            minMove = Math.min(minMove,count+dis);
            return;
        }
        //우산을 순회
        for(Point p : umbs){
            int px = p.x; int py = p.y;
            dis = Math.abs(px-x)+Math.abs(py-y);
            if(health+umb<dis||isVisited[px][py]) continue;
            isVisited[px][py]=true;
            if(umb<dis){//방패로 다 가리면서 갈 수 없다면
                solution(px,py,ex,ey,health+umb-dis,D,count+dis,umbs,D);
            } else {//방패로 가리면서 모든 움직임을 할 수 있다면
                solution(px,py,ex,ey,health,D,count+dis,umbs,D);
            }
            isVisited[px][py]=false;
        }
    }
    private static class Point{
        int x; int y;
        Point(int x, int y) { this.x=x; this.y=y; }
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22944_RainOfDeath {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {-1,0,1,0};
    final static int[] dirY = {0,1,0,-1};
    static boolean[][][] isVisited;
    public static void main(String[] args) throws IOException {
        InitInfo initinfo = input();
        solution(initinfo);
    }
    private static InitInfo input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int Sx=0, Sy=0, Ex=0, Ey=0;
        boolean[][] isUmb = new boolean[N][N];
        isVisited = new boolean[N][N][4];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                if(str.charAt(j)=='.'){
                    continue;
                } else if(str.charAt(j)=='U') {
                    isUmb[i][j]=true;
                } else if(str.charAt(j)=='S') {
                    Sx = i; Sy = j;
                } else{
                    Ex=i; Ey=j;
                }
            }
        }
        Person initPerson = new Person(Ex, Ey, H);
        InitInfo init = new InitInfo(N,D,Sx,Sy,initPerson,isUmb);
        return init;
    }
    private static void solution(InitInfo initInfo){
        int N = initInfo.N;
        int D = initInfo.D-1;
        int Sx = initInfo.Sx;
        int Sy = initInfo.Sy;
        boolean[][] isUmb = initInfo.isUmb;
        Queue<Person> q = new LinkedList<>();
        q.add(initInfo.initE);
        while(!q.isEmpty()){
            Person now = q.poll();
            int x = now.x;
            int y = now.y;
            int health = now.health;
            int nowUmb = now.umb;
            int count = now.count;
            if(health==0) continue; // 체력이 남지 않아서 죽음
            for(int i=0;i<4;i++){
                int nx = x+dirX[i];
                int ny = y+dirY[i];
                if(nx==Sx&&ny==Sy) { System.out.print(count+1); return; }
                if(checkCanGo(nx,ny,N)&&!isVisited[nx][ny][i]){
                    isVisited[nx][ny][i] = true;
                    if(isUmb[nx][ny]) q.add(new Person(nx,ny,health,D,count+1)); //이동할 곳에 우산이 있는 경우
                    else if(nowUmb>0) q.add(new Person(nx,ny,health,nowUmb-1,count+1)); //현재 우산이 있는경우
                    else q.add(new Person(nx,ny,health-1,0,count+1)); //이동할 곳에 우산도 없고 현재 가지고 있는 우산도 없는 경우
                }
            }
        }
        System.out.print(-1);
    }
    private static boolean checkCanGo(int x, int y, int N){
        if(x<0||y<0||x>=N||y>=N) return false;
        return true;
    }
    static class Person{
        int x; int y; int health; int umb; int count;
        Person(int x, int y, int health) { this.x=x; this.y=y; this.health=health; umb=0; count=0; }
        Person(int x, int y, int health, int umb, int count)
            { this.x=x; this.y=y; this.health=health; this.umb=umb; this.count=count;}
    }
    static class InitInfo{
        int N; int D; int Sx; int Sy; Person initE; boolean[][] isUmb;
        InitInfo(int N, int D, int Sx, int Sy, Person initE, boolean[][] isUmb) {
            this.N=N; this.D=D; this.initE=initE; this.isUmb=isUmb; this.Sx=Sx; this.Sy=Sy;
        }
    }
}
*/
