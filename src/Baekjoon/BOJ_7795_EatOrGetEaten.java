import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7795_EatOrGetEaten {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++) solution();
        System.out.print(sb);
    }
    private static void solution() throws IOException {
        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> listA = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> listB = new ArrayList<>();
        //line 2
        st = new StringTokenizer(br.readLine());
        int maxA = 0;
        for(int i=0;i<A;i++){
            int in = Integer.parseInt(st.nextToken());
            listA.add(in);
            maxA = Math.max(maxA,in);
        }
        //line 3
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<B;i++){
            listB.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listB);
        HashMap<Integer,Integer> cntAll = new HashMap<>();
        int sum = 0;
        while(!listA.isEmpty()){
            int now = listA.poll();
            if(now>listB.get(listB.size()-1)) sum+=listB.size();
            else if(now<=listB.get(0)) continue;
            else if(cntAll.containsKey(now)) sum+=cntAll.get(now);
            else {
                int idx = idxSmall(now,listB);
                sum+=idx;
                cntAll.put(now,idx);
            }
        }
        sb.append(sum+"\n");
    }
    private static int idxSmall(int now, List<Integer> listB){
        int left = 0, right = listB.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(listB.get(mid)<now) left = mid+1;
            else right = mid;
        }
        return right;
    }
}
