package Baekjoon.BinarySearch_and_TernarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1654_CutLANwire {
    static int numLAN=0, needLAN=0;
    static ArrayList<Long> lenLAN = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        partIO();
        long result = approximation();
        System.out.print(result);
    }
    public static void partIO()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numLAN = Integer.parseInt(st.nextToken(" "));
        needLAN = Integer.parseInt(st.nextToken(" "));
        for(int i=0;i<numLAN;i++){
            lenLAN.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(lenLAN);
    }
    public static Long approximation(){
        long min = 1;
        long max = lenLAN.get(numLAN-1);
        while(max>=min){
            long middle = (max+min)/2;
            long sum = 0;
            for(int j=0;j<lenLAN.size();j++)
                sum+=lenLAN.get(j)/middle;
            if(sum>=needLAN) min = middle+1;
            else max = middle-1;
        }
        return max;
    }
}
