import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_NumberOfPaper {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] numbers;
    static int[] paper = new int[3];
    public static void main(String[] args) throws IOException {
        input();
        solution(numbers.length,0,0);
        System.out.print(paper[0]+"\n"+paper[1]+"\n"+paper[2]+"\n");
    }
    private static void input() throws IOException {
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) numbers[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    private static void solution(int divNum, int x, int y){
        if(isAllSame(divNum,x,y)) return;
        int divide3 = divNum/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){ solution(divide3,x+(i*divide3),y+(j*divide3)); }
        }
    }
    private static boolean isAllSame(int divNum, int x, int y){
        int before = numbers[x][y];
        for(int i=x;i<x+divNum;i++){
            for(int j=y;j<y+divNum;j++) { if(before!=numbers[i][j]) return false; }
        }
        paper[before+1]++;
        return true;
    }
}
