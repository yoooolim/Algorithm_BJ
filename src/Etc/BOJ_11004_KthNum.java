package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    시간 줄이기 코드도 있으니 끝나고 한 번 도전해보기!
 */

public class BOJ_11004_KthNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int k = Integer.parseInt(st.nextToken(" "));
        ArrayList<Integer> input = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) input.add(Integer.parseInt(st2.nextToken(" ")));
        Collections.sort(input);
        System.out.print(input.get(k-1));
    }
}
