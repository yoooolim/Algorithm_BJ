import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_NumberCard2 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution(input());
    }
    private static HashMap<Long, Integer> input() throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] card = new long[N];
        for(int i=0;i<N;i++) card[i] = Long.parseLong(st.nextToken());
        Arrays.sort(card);

        HashMap<Long, Integer> cardSet = new HashMap<>();
        int startIdx = 0;
        int endIdx = 1;
        while(endIdx<N){
            if(card[startIdx]==card[endIdx]) {
                endIdx++;
            } else {
                cardSet.put(card[startIdx],endIdx-startIdx);
                startIdx=endIdx; endIdx++;
            }
        }
        cardSet.put(card[startIdx],endIdx-startIdx);

        return cardSet;
    }
    private static void solution(HashMap<Long, Integer> cardSet) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            long in = Long.parseLong(st.nextToken());
            if(!cardSet.containsKey(in)) sb.append(0+" ");
            else sb.append(cardSet.get(in)+" ");
        }

        System.out.print(sb);
    }
}
