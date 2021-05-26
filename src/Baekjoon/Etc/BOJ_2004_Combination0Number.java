package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004_Combination0Number {
    static long n;
    static long m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        long a5=0,a2=0,b5=0,b2=0;
        for(long i=n;i>n-m;i--){
            a5+=baseLog(i,5);
            a2+=baseLog(i,2);
        }
        for(long i=2;i<=m;i++){
            b5+=baseLog(i,5);
            b2+=baseLog(i,2);
        }
        long num5 = a5-b5;
        long num2 = a2-b2;
        if(num5<num2) System.out.print(num5);
        else System.out.print(num2);
    }
    static long baseLog(double x, double base) {
        double temp = Math.log10(x) / Math.log10(base);
        if((int)temp == temp) return (long)temp;
        return 0;
    }
}
