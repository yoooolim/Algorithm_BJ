package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047_Coin0 {
    static int coinNum;
    static int makeMoney;
    static int [] haveMoneys;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        coinNum = Integer.parseInt(st.nextToken(" "));
        makeMoney = Integer.parseInt(st.nextToken(" "));
        haveMoneys = new int[coinNum];
        for(int i=0;i<coinNum;i++) haveMoneys[i]=Integer.parseInt(br.readLine());

        int index = approximate(haveMoneys,makeMoney);
        int sum = 0;
        int count = 0;
        for(int i=index;i>=0;i--){
            if(sum+haveMoneys[i]==makeMoney) {
               count++; break;
            }
            if(sum+haveMoneys[i]>makeMoney) {
                continue;
            }
            else {
                while(sum+haveMoneys[i]<=makeMoney){
                    sum += haveMoneys[i];
                    count++;
                }
                if(sum==makeMoney){
                    break;
                }
            }
        }
        System.out.print(count);

    }
    static int approximate(int[] array, int wantToMake){
        int min = 0;
        int max = array.length-1;
        int mid = 0;
        while(min<=max){
            mid = (min+max)/2;
            if(array[mid] == wantToMake) return mid;
            else if(array[mid]<=wantToMake) min = mid+1;
            else max = mid-1;
        }
        return mid;
    }
}
