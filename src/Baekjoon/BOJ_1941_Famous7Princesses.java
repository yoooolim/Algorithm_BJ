import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_Famous7Princesses {
    final static int[] dirX = {-1,0,1,0}, dirY = {0,1,0,-1};
    static boolean[] isSom = new boolean[25];
    static boolean[] visited = new boolean[25];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        input();
        dfs(new int[7],0,7,0);
        System.out.print(count);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            String str = br.readLine();
            for(int j=0;j<5;j++){
                isSom[5*i+j]=(str.charAt(j)=='Y')? false:true;
            }
        }
    }
    private static void dfs(int[] arr, int start, int r, int yeonCnt){
        if(r==0){
            if(isRightSeven(arr)) count++;
            return;
        }
        for(int i=start;i<25;i++){
            if(!isSom[i]&&yeonCnt>2) continue;
            arr[7-r] = i;
            if(isSom[i]) dfs(arr,i+1,r-1,yeonCnt);
            else dfs(arr,i+1,r-1,yeonCnt+1);
        }
    }
    private static boolean isRightSeven(int[] arr){
        boolean[][] candidate = new boolean[5][5];
        boolean[][] visited = new boolean[5][5];
        for(int item : arr) candidate[item/5][item%5]=true;
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        visited[arr[0]/5][arr[0]%5]=true;
        int adjCnt = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            int x = now/5;
            int y = now%5;
            for(int i=0;i<4;i++){
                int nx = x+dirX[i];
                int ny = y+dirY[i];
                if(nx<0||ny<0||nx>=5||ny>=5||visited[nx][ny]||!candidate[nx][ny]) continue;
                adjCnt++;
                visited[nx][ny] = true;
                q.offer(nx*5+ny);
            }
        }
        if(adjCnt==7) return true;
        return false;
    }
}
