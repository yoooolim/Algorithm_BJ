import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class BOJ_1036_36Number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        for(int i=0;i<N;i++){
            String in = br.readLine().trim();
            strings.add(in);
        }
        int K = Integer.parseInt(br.readLine());
        List<Num36> sToi = new ArrayList<>();
        for(int i=0;i<36;i++) sToi.add(new Num36(i,new BigInteger("0")));
        for(String item : strings){
            BigInteger bi = new BigInteger("1",36);
            for(int i=item.length()-1;i>=0;i--){
                char ch = item.charAt(i);
                int idx = 0;
                if('0'<=ch&&ch<='9') idx = ch - '0';
                else idx = ch - 'A' + 10;
                sToi.get(idx).bi = sToi.get(idx).bi.add(bi);
                bi = bi.multiply(new BigInteger("10",36));
            }
        }
        Collections.sort(sToi);
        BigInteger sum = new BigInteger("0");
        for(int i=0;i<K;i++){
            Num36 now = sToi.get(0);
            if(now.bi.compareTo(new BigInteger("0"))==0) break;
            sum = sum.add(sToi.get(0).bi.multiply(new BigInteger("35")));
            sToi.remove(0);
        }
        for(int i=0;i<sToi.size();i++){
            Num36 now = sToi.get(i);
            //if(now.bi.compareTo(new BigInteger("0"))==0) break;
            sum = sum.add(now.bi.multiply(new BigInteger(Integer.toString(now.idx))));
        }
        System.out.print(sum.toString(36).toUpperCase());
        return;
    }
    private static class Num36 implements Comparable<Num36>{
        int idx; BigInteger bi; BigInteger value;
        Num36(int idx, BigInteger bi){ this.idx=idx; this.bi=bi; }
        void getValue(){ this.value = this.bi.multiply(new BigInteger(Integer.toString(idx))); }
        @Override
        public int compareTo(Num36 n){
            BigInteger b1 = this.bi.multiply(new BigInteger(Integer.toString(35-this.idx)));
            BigInteger b2 = n.bi.multiply(new BigInteger(Integer.toString(35-n.idx)));
            int compareN = b1.compareTo(b2);
            return (compareN==1)?-1:(compareN==-1)?1:(this.idx<n.idx)?-1:1;
        }
    }
}
