package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891_Gear {
    static String[] gear = new String[4];
    static String[] temp = new String[4];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            gear[i] = br.readLine();
            temp[i]=gear[i];
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken(" "));
            int b = Integer.parseInt(st.nextToken(" "));
            if(a!=1)leftSide(a,b);
            if(a!=4)rightSide(a,b);
            if(b==1)rightMove(a-1);
            else leftMove(a-1);
            for(int j=0;j<4;j++) gear[j]=temp[j];
        }
        int score = 1;
        int answer = 0;
        for(int i=0;i<4;i++){
            if(gear[i].charAt(0)=='1') answer+=score;
            score*=2;
        }
        System.out.print(answer);
    }
    static void leftSide(int a, int b){
        int temp = a;
        int before = b;
        while(temp-->1){
            if(gear[temp].charAt(6)==gear[temp-1].charAt(2)) break;
            else if(before==1) {
                leftMove(temp - 1); before=-1;
            }
            else {
                rightMove(temp - 1); before=1;
            }
        }
    }
    static void rightSide(int a, int b){
        int temp = a;
        int before = b;
        while(temp++<4){
            if(gear[temp-1].charAt(6)==gear[temp-2].charAt(2)) break;
            else if(before==1) {
                leftMove(temp - 1); before=-1;
            }
            else {
                rightMove(temp - 1); before=1;
            }
        }
    }
    static void leftMove(int now){
        temp[now]="";
        for(int i=0;i<7;i++) temp[now]+=gear[now].charAt(i+1);
        temp[now]+=gear[now].charAt(0);
    }
    static void rightMove(int now){
        temp[now]="";
        temp[now] += gear[now].charAt(7);
        for(int i=0;i<7;i++) temp[now]+=gear[now].charAt(i);
    }
}
