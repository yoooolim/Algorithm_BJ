import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2565_ElectricCodes {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution(input());
    }
    public static List<Code> input() throws IOException {
        List<Code> codes = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken(" "));
            int end = Integer.parseInt(st.nextToken());
            codes.add(new Code(start,end));
        }
        Collections.sort(codes);
        return codes;
    }
    private static void solution(List<Code> codes){
        int max = 0, n = codes.size();
        int[] dpAsc = new int[n];
        for(int i=0;i<n;i++){
            dpAsc[i]=1;
            for(int j=0;j<i;j++){
                if(codes.get(j).end<codes.get(i).end&&dpAsc[j]+1>dpAsc[i]) dpAsc[i] = dpAsc[j]+1;
            }
            max = Math.max(max,dpAsc[i]);
        }
        System.out.print(n-max);
    }
    private static class Code implements Comparable<Code> {
        int start;
        int end;
        Code(int start, int end){ this.start = start; this.end = end; }
        @Override
        public int compareTo(Code c){
            return (this.start>c.start)?1:-1;
        }
    }
}
