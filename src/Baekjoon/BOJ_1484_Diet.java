import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1484_Diet {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution(Integer.parseInt(br.readLine()));
    }
    private static void solution(int G) {
        StringBuilder sb = new StringBuilder();
        List<Integer> divisors = new ArrayList<>();
        int div = (int)Math.sqrt(G);
        if(Math.pow(div,2)!=G) div++;
        for(int i=1;i<div;i++){
            if(G%i==0) { int divide = G/i; if((isOdd(i)==isOdd(divide))) divisors.add((divide+i)/2); }
        }
        for(int i=divisors.size()-1;i>=0;i--) sb.append(divisors.get(i)+"\n");
        if(sb.length()==0) sb.append(-1);
        System.out.print(sb);
    }
    private static boolean isOdd(int num){
        return (num%2==0)? false:true;
    }
}
/*
    private static void solution(int G) {
        int nowKG = (int)Math.sqrt(G)+1;
        int beforeKG = 1;
        List<Integer> ans = new ArrayList<>();
        while(nowKG!=beforeKG){
            int nowG = (int)Math.pow(nowKG,2) - (int)Math.pow(beforeKG,2);
            if(nowG == G) {
                ans.add(nowKG);
                nowKG++;
                beforeKG++;
            }
            else if(nowG < G) nowKG++;
            else beforeKG++;
        }
        if(ans.isEmpty()) ans.add(-1);
        for(int temp : ans) System.out.print(temp+"\n");
    }*/