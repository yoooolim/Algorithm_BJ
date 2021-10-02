import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9328_Key {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    final static int[] dirX = {-1,0,1,0}, dirY = {0,1,0,-1};
    static String[] strings;
    static Queue<Point> q;
    static ArrayList<Point>[] hold;
    static boolean[][] visited;
    static boolean[] keys;
    static int R,C,docs;
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        strings = new String[R];
        q = new LinkedList<>();
        hold = new ArrayList[26];
        for(int i=0;i<26;i++) hold[i] = new ArrayList<>();
        keys = new boolean[26];
        visited = new boolean[R][C];
        docs = 0;
        //입력 받기
        for(int i=0;i<R;i++) strings[i]=br.readLine();
        char[] key = br.readLine().toCharArray();
        if(key[0]!='0') for(char item : key) keys[item-'a']=true;
        //처음 시작 점 찾아내기
        for(int i=0;i<C;i++) process(0,i);
        for(int i=1;i<R-1;i++) {
            process(i,0);
            process(i,C-1);
        }
        for(int i=0;i<C;i++) process(R-1,i);
    }
    private static void solution(){
        while(!q.isEmpty()){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            for(int i=0;i<4;i++){
                int nx = x+dirX[i];
                int ny = y+dirY[i];
                if(nx<0||ny<0||nx>=R||ny>=C||visited[nx][ny]) continue;
                process(nx,ny);
                /*
                char nCh = strings[nx].charAt(ny);
                if(nCh=='*') continue;
                else if (nCh=='.') q.offer(new Point(nx,ny));
                else if (nCh=='$'){
                    q.offer(new Point(nx,ny));
                    docs++;
                } else if('a'<=nCh&&nCh<='z'){ //키를 주웠을 때
                    if(!keys[nCh-'a']){ //새로 주운 키인 경우
                        for(Point p : hold[nCh-'a']) q.offer(new Point(p.x,p.y));
                    } else q.offer(new Point(nx,ny));
                } else { //대문자 -> 즉 문인 경우
                    if(keys[nCh-'A']) q.offer(new Point(nx,ny));
                    else hold[nCh-'A'].add(new Point(nx,ny));
                }*/
            }
        }
        sb.append(docs+"\n");
    }
    private static void process(int x, int y){
        visited[x][y]=true;
        char nCh = strings[x].charAt(y);
        if(nCh=='*') return ;
        else if (nCh=='.') q.offer(new Point(x,y));
        else if (nCh=='$'){
            q.offer(new Point(x,y));
            docs++;
        } else if('a'<=nCh&&nCh<='z'){ //키를 주웠을 때
            if(!keys[nCh-'a']){ //새로 주운 키인 경우
                for(Point p : hold[nCh-'a']) q.offer(new Point(p.x,p.y));
                keys[nCh-'a']=true;
            }
            q.offer(new Point(x,y));
        } else { //대문자 -> 즉 문인 경우
            if(keys[nCh-'A']) q.offer(new Point(x,y));
            else hold[nCh-'A'].add(new Point(x,y));
        }
    }
    private static class Point{
        int x; int y;
        Point(int x, int y){ this.x=x; this.y=y; }
    }
}
