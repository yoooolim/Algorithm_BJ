package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_CalWeather {
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int earth = Integer.parseInt(st.nextToken(" "));
        int sun = Integer.parseInt(st.nextToken(" "));
        int month = Integer.parseInt(st.nextToken(" "));
        int year = 1;

        while(true){
            if((year-earth)%15==0&&(year-sun)%28==0&&(year-month)%19==0) break;
            year++;
        }
        System.out.print(year);
    }
}
