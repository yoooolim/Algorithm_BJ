package Programmers.Kakao2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PGM_72411_RenewalMenu {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        String[] orders = br.readLine().replaceAll("\"","").split(", ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> temp = new ArrayList<>();
        while(st.hasMoreTokens()){
            temp.add(Integer.parseInt(st.nextToken(",")));
        }
        int[] course = new int[temp.size()];
        for(int i=0;i<course.length;i++) course[i]=temp.get(i);
        s.solution(orders,course);
    }
}
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        return answer;
    }
}