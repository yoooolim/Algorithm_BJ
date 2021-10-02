import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1049_GuitarLine {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int lineCnt, cheapPackage, cheapOne;
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        lineCnt = Integer.parseInt(st.nextToken());
        int brandCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> packagePrice = new PriorityQueue<>();
        PriorityQueue<Integer> onePrice = new PriorityQueue<>();
        for(int i=0;i<brandCnt;i++){
            st = new StringTokenizer(br.readLine());
            packagePrice.offer(Integer.parseInt(st.nextToken()));
            onePrice.offer(Integer.parseInt(st.nextToken()));
        }
        cheapPackage = packagePrice.poll();
        cheapOne = onePrice.poll();
    }
    private static void solution(){
        int money = 0;
        if(cheapOne*6<=cheapPackage){
            money = cheapOne*lineCnt;
        } else {
            int onlyPackage = (lineCnt/6+1)*cheapPackage;
            int mix = (lineCnt/6)*cheapPackage+(lineCnt%6)*cheapOne;
            money = Math.min(onlyPackage,mix);
        }
        System.out.print(money);
    }
}
