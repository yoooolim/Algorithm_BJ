import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559_PuyoPuyo {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int[] dirX = {-1,0,1,0}, dirY = {0,1,0,-1};
    static char[][] board = new char[12][6];
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input() throws IOException {
        for(int i=0;i<12;i++){
            String str = br.readLine();
            for(int j=0;j<6;j++) board[i][j] = str.charAt(j);
        }
    }
    private static void solution(){
        int chainSum = 0;
        while(find4Puyo()>0){
            chainSum++;
            sortBoard();
        }
        System.out.print(chainSum);
    }
    private static void sortBoard(){
        for(int i=0;i<6;i++){
            for(int j=10;j>=0;j--){
                for(int k=11;k>j;k--){
                    if(board[j][i]!='.'&&board[k][i]=='.'){
                        board[k][i] = board[j][i];
                        board[j][i]='.';
                        break;
                    }
                }
            }
        }
    }
    private static int find4Puyo(){
        boolean[][] visited = new boolean[12][6];
        int chainCnt = 0;
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(board[i][j]!='.'&&!visited[i][j]){
                    Queue<Point> q = new LinkedList<>();
                    List<Point> save = new ArrayList<>();
                    q.add(new Point(i,j));
                    save.add(new Point(i,j));
                    visited[i][j] = true;
                    char nowColor = board[i][j];
                    while(!q.isEmpty()){
                        Point now = q.poll();
                        int x = now.x;
                        int y = now.y;
                        for(int k=0;k<4;k++){
                            int nx = x+dirX[k];
                            int ny = y+dirY[k];
                            if(nx<0||ny<0||nx>11||ny>5||visited[nx][ny]||board[nx][ny]!=nowColor) continue;
                            visited[nx][ny] = true;
                            q.add(new Point(nx,ny));
                            save.add(new Point(nx,ny));
                        }
                    }
                    if(save.size()>=4){
                        for(Point p : save) board[p.x][p.y] = '.';
                        chainCnt++;
                    }
                }
            }
        }
        return chainCnt;
    }
    private static class Point{
        int x; int y;
        Point(int x, int y){ this.x=x; this.y=y; }
    }
}
