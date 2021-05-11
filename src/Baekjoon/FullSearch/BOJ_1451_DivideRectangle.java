package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1451_DivideRectangle {
    static int[][] rectangle;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        //input and initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        rectangle = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                rectangle[i][j] = str.charAt(j)-'0';
            }
        }

        //algorithm and out
        System.out.print(getBestSet());
    }
    public static long getBestSet(){
        long result = getBestCase1();
        result = Math.max(result,getBestCase2());
        result = Math.max(result,getBestCase3());
        result = Math.max(result,getBestCase4());
        result = Math.max(result,getBestCase5());
        result = Math.max(result,getBestCase6());
        return result;
    }

    public static long getBestCase1(){
        long best = 0;
        for(int i=0;i<N-2;i++){
            long a = sum(0,0,i,M-1);
            for(int j=i+1;j<N-1;j++){
                long b = sum(i+1,0,j,M-1);
                long c = sum(j+1,0,N-1,M-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long getBestCase2(){
        long best = 0;
        for(int i=0;i<M-2;i++){
            long a = sum(0,0,N-1,i);
            for(int j=i+1;j<M-1;j++){
                long b = sum(0,i+1,N-1,j);
                long c = sum(0,j+1,N-1,M-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long getBestCase3(){
        long best = 0;
        for(int i=0;i<M-1;i++){
            long a = sum(0,0,N-1,i);
            for(int j=0;j<N-1;j++){
                long b = sum(0,i+1,j,M-1);
                long c = sum(j+1,i+1,N-1,M-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long getBestCase4(){
        long best = 0;
        for(int i=1;i<M;i++){
                long a = sum(0,i,N-1,M-1);
            for(int j=0;j<N-1;j++){
                long b = sum(0,0,j,i-1);
                long c = sum(j+1,0,N-1,i-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long getBestCase6(){
        long best = 0;
        for(int i=0;i<N-1;i++){
            long a = sum(0,0,i,M-1);
            for(int j=0;j<M-1;j++){
                long b = sum(i+1,0,N-1,j);
                long c = sum(i+1,j+1,N-1,M-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long getBestCase5(){
        long best = 0;
        for(int i=1;i<N;i++){
            long a = sum(i,0,N-1,M-1);
            for(int j=0;j<M-1;j++){
                long b = sum(0,0,i-1,j);
                long c = sum(0,j+1,i-1,M-1);
                best=Math.max(best,a*b*c);
            }
        }
        return best;
    }
    public static long sum(int a, int b, int c, int d){
        long result = 0;
        for(int i=a;i<=c;i++){
            for(int j=b;j<=d;j++) result+=rectangle[i][j];
        }
        return result;
    }
}
