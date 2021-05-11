package Baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_CombineArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫번째 입력 줄 initialization
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstArrayLength = Integer.parseInt(st.nextToken(" "));
        int secondArrayLength = Integer.parseInt(st.nextToken(" "));
        int[] firstArray = new int[firstArrayLength];
        int[] secondArray = new int[secondArrayLength];
        StringBuilder result = new StringBuilder();

        //두번째 입력 줄 initialization
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<firstArrayLength;i++) firstArray[i]=Integer.parseInt(st.nextToken(" "));

        //세번째 입력 줄 initialization
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<secondArrayLength;i++) secondArray[i]=Integer.parseInt(st.nextToken(" "));

        //Divide and Conquer
        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        while(firstArrayPointer!=firstArrayLength&&secondArrayPointer!=secondArrayLength){
            if(firstArray[firstArrayPointer]<secondArray[secondArrayPointer]) result.append(firstArray[firstArrayPointer++]+" ");
            else result.append(secondArray[secondArrayPointer++]+" ");
        }
        if(firstArrayPointer==firstArrayLength){
            for(int i=secondArrayPointer;i<secondArrayLength;i++){result.append(secondArray[secondArrayPointer++]+" ");}
        }
        else{
            for(int i=firstArrayPointer;i<firstArrayLength;i++){ result.append(firstArray[firstArrayPointer++]+" ");}
        }
        System.out.print(result.toString());
    }
}
