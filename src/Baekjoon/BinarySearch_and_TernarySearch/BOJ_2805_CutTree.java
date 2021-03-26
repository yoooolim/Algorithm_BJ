package Baekjoon.BinarySearch_and_TernarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2805_CutTree {
    static private int treeN=0, getN=0;
    static private ArrayList<Long> treeH = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        partIO();
        System.out.print(approximate());
    }
    public static void partIO() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        treeN = Integer.parseInt(st.nextToken(" "));
        getN = Integer.parseInt(st.nextToken(" "));
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<treeN;i++) treeH.add(Long.parseLong(st.nextToken(" ")));
        Collections.sort(treeH);
    }
    public static Long approximate(){
        long min = 0;
        long max = treeH.get(treeN-1);
        while(max>=min){
            long sum = 1;
            long mid = (min+max)/2;
            for(int i=0;i<treeN;i++) {
                if(treeH.get(i)-mid<=0) continue;
                sum += treeH.get(i) - mid;
            }
            if(sum>=getN) min=mid+1;
            else max = mid-1;
        }
        return max;
    }
}
