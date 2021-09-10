import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2776_MemorizationKing {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            List<Integer> note1 = new ArrayList<>();
            List<Note> note2 = new ArrayList<>();
            input(note1,note2);
            solution(note1, note2);
        }
        System.out.print(sb);
    }
    private static void input(List<Integer> note1, List<Note> note2) throws IOException {
        int note1N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<note1N;i++) note1.add(Integer.parseInt(st.nextToken()));
        int note2N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<note2N;i++) note2.add(new Note(i,Integer.parseInt(st.nextToken())));
        Collections.sort(note1);
        Collections.sort(note2);
    }
    private static void solution(List<Integer> note1, List<Note> note2){
        int note1Point=0;
        int note2Point=0;
        boolean[] ans = new boolean[note2.size()];
        while(note2Point<note2.size()&&note1Point<note1.size()){
            int now1 = note1.get(note1Point);
            Note now2 = note2.get(note2Point);
            if(now1==now2.num) { ans[now2.idx] = true; note2Point++; }
            else if(now1<now2.num) note1Point++;
            else note2Point++;
        }
        for(boolean item : ans){
            if(item) sb.append("1\n");
            else sb.append("0\n");
        }
    }
    private static class Note implements Comparable<Note>{
        int idx; int num;
        Note(int idx, int num) { this.idx = idx; this.num = num; }
        @Override
        public int compareTo(Note note){
            return (this.num<note.num)? -1 : 1 ;
        }
    }
}
