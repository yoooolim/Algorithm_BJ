package Baekjoon.BinarySearch_and_TernarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2143_SumOfTwoArray {
    static int sum;
    static int firstArraySize;
    static int[] firstArray;
    static int secondArraySize;
    static int[] secondArray;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sum = Integer.parseInt(br.readLine());

        firstArraySize=Integer.parseInt(br.readLine());
        firstArray = new int[firstArraySize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<firstArraySize;i++) firstArray[i]=Integer.parseInt(st.nextToken(" "));

        secondArraySize=Integer.parseInt(br.readLine());
        secondArray = new int[secondArraySize];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<secondArraySize;i++) secondArray[i]=Integer.parseInt(st.nextToken(" "));

        ArrayList<Integer> sumFirst = new ArrayList<>();
        for(int i=0;i<firstArraySize-1;i++){
            if(i+i+1>sum) continue;
            sumFirst.add(i+i+1);
            for(int j=i+2;j<firstArraySize;j++){
                if(sumFirst.get(sumFirst.size()-1)+j>sum) break;
                sumFirst.add(sumFirst.get(sumFirst.size()-1)+j);
            }
        }
        Collections.sort(sumFirst);

        ArrayList<Integer> sumSecond = new ArrayList<>();
        for(int i=0;i<secondArraySize-1;i++){
            if(i+i+1>sum) continue;
            sumSecond.add(i+i+1);
            for(int j=i+2;j<secondArraySize;j++){
                if(sumSecond.get(sumSecond.size()-1)+j>sum) break;
                sumSecond.add(sumSecond.get(sumSecond.size()-1)+j);
            }
        }

        if(secondArraySize>=firstArraySize){
            for(int i=0;i<sumFirst.size();i++){
                int wantMake = sum - sumFirst.get(i);
                int start =0, end =sumSecond.size()-1;

                int mid;
                while(start<end){
                    mid = (start+end)/2;
                    if(sumSecond.get(mid)==wantMake) break;
                    if(sumSecond.get(mid)<wantMake) end = mid;
                    else start = mid;
                }
            }
        }
        else{
            for(int i=0;i<sumSecond.size();i++){
                int wantMake = sum - sumSecond.get(i);
                int start =0, end =sumFirst.size()-1;

                int mid=0, location=-1;

                while(start<=end){
                    mid = (start+end)/2;
                    if(sumFirst.get(mid)==wantMake) {
                        location=mid;
                        break;
                    }
                    if(sumFirst.get(mid)>wantMake) end = mid-1;
                    else start = mid+1;
                }
                System.out.print(location);
            }
        }

    }
}
