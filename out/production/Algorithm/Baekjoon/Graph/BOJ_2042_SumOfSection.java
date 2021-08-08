import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2042_SumOfSection {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] segmentTree;
    static long[] sequence;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cmdNum = initSetting(); //명령어 전 input 처리
        segmentTreeInit(0,sequence.length-1,1); //segment tree 구성
        for(int i=0;i<cmdNum;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")) {
                int wantChgIdx = Integer.parseInt(st.nextToken());
                long wantChgNum = Long.parseLong(st.nextToken());
                long chgNum = wantChgNum - sequence[wantChgIdx-1];
                sequence[wantChgIdx-1] = wantChgNum;
                changeNumber(0, sequence.length - 1, 1, wantChgIdx-1,chgNum);
            }
            else sb.append(getSum(0, sequence.length -1,1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1)+"\n");
        }
        System.out.print(sb);
    }
    private static long segmentTreeInit(int start, int end, int idx){
        if(start==end) return segmentTree[idx] = sequence[start];
        int mid = (start+end)/2;
        return segmentTree[idx] = segmentTreeInit(start,mid,idx*2)+segmentTreeInit(mid+1,end,idx*2+1);
    }
    private static int initSetting() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cmdNum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        sequence = new long[n];
        segmentTree = new long[4*n];
        for(int i=0;i<n;i++) { sequence[i]=Integer.parseInt(br.readLine()); }
        return cmdNum;
    }
    private static void changeNumber(int start, int end, int idx, int chgIdx, long num){
        if(chgIdx<start||chgIdx>end) return; //범위 밖에 있는 경우
        segmentTree[idx] +=num;
        if(start==end) return;
        int mid = (start+end)/2;
        changeNumber(start,mid,idx*2,chgIdx,num);
        changeNumber(mid+1,end,idx*2+1,chgIdx,num);
    }
    private static long getSum(int start, int end, int idx, int left, int right){
        if(left>end||right<start) return 0;
        if(left<=start&&right>=end) return segmentTree[idx];
        int mid = (start+end)/2;
        return getSum(start,mid,idx*2,left,right)+getSum(mid+1,end,idx*2+1,left,right);
    }
}
