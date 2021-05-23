package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744_TieNumber {
    static int arrayNum;
    static int[] array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayNum = Integer.parseInt(br.readLine());
        array = new int[arrayNum];
        int max = 0;
        for(int i=0;i<arrayNum;i++) {
            array[i] = Integer.parseInt(br.readLine());
            max +=array[i];
        }
        Arrays.sort(array);
        for(int i=arrayNum-1;i>=1;i--){
            if(array[i]>1&&array[i-1]>1){
                max+=(array[i]*array[i-1]-array[i]-array[i-1]);
                i--;
            } else break;
        }
        for(int i=0;i<arrayNum-1;i++){
            if(array[i]<=-1&&array[i+1]<=0){
                max+=(array[i]*array[i+1]-array[i]-array[i+1]);
                i++;
            } else break;
        }
        System.out.print(max);
    }
}
