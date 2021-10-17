package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_2407_Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        BigInteger bi = new BigInteger("1");
        for(int i=n;i>m;i--) bi = bi.multiply(new BigInteger(Integer.toString(i)));
        for(int i=n-m;i>0;i--) bi = bi.divide(new BigInteger(Integer.toString(i)));
        System.out.print(bi);
    }
}
