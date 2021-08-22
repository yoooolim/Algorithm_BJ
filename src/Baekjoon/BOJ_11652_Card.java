import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_11652_Card {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        HashMap<Long,Integer> cards = new HashMap<>();
        Long maxKey = Long.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            Long temp = Long.parseLong(br.readLine());
            if(cards.containsKey(temp)){
                int nowCount = cards.get(temp)+1;
                cards.put(temp,nowCount);
                if((nowCount>maxValue)||(nowCount==maxValue&&temp<maxKey)) { maxValue = nowCount; maxKey = temp; }
            } else{
                cards.put(temp,1);
                if(maxKey>temp&&maxValue<=1) { maxKey=temp; maxValue=1; }
            }
        }
        System.out.print(maxKey);
    }
}
