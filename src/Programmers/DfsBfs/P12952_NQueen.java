public class P12952_NQueen {
    public static void main(String[] args){
        System.out.print(solution(4));
    }
    public static int solution(int n) {
        int answer = 0;
        boolean[][] isVisited = new boolean[n][n];
        boolean[][] qPut = new boolean[n][n];
        for(int i=0;i<n;i++){
            qPut[i][0] = true;
            answer+=DFS(n,1,isVisited,qPut);
            qPut[i][0] = false;
        }
        return answer;
    }
    public static int DFS(int length, int depth, boolean[][] isVisited, boolean[][] qPut){
        if(length==depth){
            return 1;
        }
        int cnt = 0;
        for(int i=0;i<length;i++){
            if(!canPut(qPut,i,depth,length)) continue;
            qPut[i][depth]=true;
            cnt+=DFS(length,depth+1,isVisited,qPut);
            qPut[i][depth]=false;
        }
        return cnt;
    }
    public static boolean canPut(boolean[][] qPut, int x, int y, int n){
        int tempX = x;
        int tempY = y;
        while(--tempY>=0){
            if(qPut[x][tempY]) return false;
        }
        tempY = y;
        while(--tempX>=0&&--tempY>=0){
            if(qPut[tempX][tempY]) return false;
        }
        tempX = x;
        tempY = y;
        while(++tempX<n&&--tempY>=0){
            if(qPut[tempX][tempY]) return false;
        }
        return true;
    }
}
