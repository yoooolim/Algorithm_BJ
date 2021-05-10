package Baekjoon.FullSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    Brute force 알고리즘 -> 전체를 탐색
*/

public class BOJ_1107_Remote {
    public static void main(String[]args)throws Exception{
        //initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channelN = Integer.parseInt(br.readLine());
        int brokenN = Integer.parseInt(br.readLine());
        ArrayList<Integer> brokenKey = new ArrayList<>(brokenN);

        if(brokenN!=0) {//고장난 버튼이 없을 경우
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenN; i++) {
                brokenKey.add(Integer.parseInt(st.nextToken(" ")));
            }
        }

        //brute algorithm start
        int min = Math.abs(channelN - 100);//100에서 + or -로만 해당 channel에 접근하는 경우
        for (int i = 0; i <= 1000000; i++) {
            int length = check(i, brokenKey);
            if (length > 0) min = Math.min(min, Math.abs(channelN - i) + length);
        }
        System.out.print(min);
    }
    //check 입력받은 channel을 숫자를 눌러 갈 수 있는지
    public static int check(int channel,ArrayList<Integer> brokenKey){
        int length=0;

        if(channel==0) return (brokenKey.contains(0))? 0:1 ; //고장났다면 0 return 고장나지 않았다면 1 return

        while(channel>0){
            if(brokenKey.contains(channel%10)) return 0;
            length++;
            channel/=10;
        }
        return length;
    }
}
