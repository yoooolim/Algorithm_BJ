import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2168_DiagonalOverTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        System.out.print(x+y-gcd(x,y));
    }
    private static int gcd(int a, int b){
        while(b!=0){ int r = a%b; a=b;b=r; }
        return a;
    }
}
