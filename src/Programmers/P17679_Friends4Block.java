import java.io.IOException;
import java.util.*;

public class P17679_Friends4Block {
    public static void main(String[] args) throws IOException{
        int m=6,n=6;
        String[] board = {"IIIIOO", "IIIOOO", "IIIOOI", "IOOIII", "OOOIII", "OOIIII"};

        /*String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        int m=4,n=5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
         */
        System.out.print(solution(m,n,board));
    }
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        StringBuilder[] boardNew = new StringBuilder[n];
        for(int i=0;i<n;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<m;j++) temp.append(board[m-j-1].charAt(i));
            boardNew[i]=temp;
        }

        List<Coordinate> pq = new ArrayList<>();
        while(have4Block(pq,m,n,boardNew)){
            answer+=pq.size();
            Collections.sort(pq, new MyComparator());
            erase4Block(pq,m,n,boardNew);
            pq.clear();
        }
        return answer;
    }
    public static void erase4Block(List<Coordinate> pq, int m, int n, StringBuilder[] board){
        Iterator<Coordinate> it = pq.iterator();
        while(it.hasNext()){
            Coordinate now = it.next();
            int x = now.x; int y = now.y;
            board[x].deleteCharAt(y);
        }
    }
    public static boolean have4Block(List<Coordinate> pq, int m, int n, StringBuilder[] board){
        boolean[][] visitied = new boolean[n][m];
        for(int i=0;i<n-1;i++){
            if(board[i].length()<2) continue;
            for(int j=board[i].length()-2;j>=0;j--){
                if(board[i].length()<j+1) continue;
                if(board[i+1].length()<j+2) continue;
                if(board[i].charAt(j)==board[i].charAt(j+1)&&board[i+1].charAt(j)==board[i+1].charAt(j+1)&&board[i+1].charAt(j)==board[i].charAt(j+1)){
                    if(!visitied[i][j+1]) { pq.add(new Coordinate(i, j+1)); visitied[i][j+1]=true; }
                    if(!visitied[i][j]) { pq.add(new Coordinate(i, j)); visitied[i][j]=true; }
                    if(!visitied[i+1][j+1]) { pq.add(new Coordinate(i+1, j+1)); visitied[i+1][j+1]=true; }
                    if(!visitied[i+1][j]) { pq.add(new Coordinate(i+1, j)); visitied[i+1][j]=true; }
                }
            }
        }
        if(pq.isEmpty()) return false;
        return true;
    }
    public static class MyComparator implements Comparator<Coordinate> {
        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            return - o1.y + o2.y;
        }
    }
    static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){ this.x = x; this.y = y; }

    }
}
