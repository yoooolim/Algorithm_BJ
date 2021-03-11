package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_11652_Card {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> m = new HashMap<>();
        int max = 1;
        String maxN = null;
        for(int i=0;i<n;i++){
            String k = br.readLine();
            if(m.containsKey(k)==true) {
                m.put(k, m.get(k) + 1);
                if((m.get(k)>max)||((m.get(k)==max)&&(k.compareTo(maxN)==-1))) {
                    max = m.get(k);
                    maxN = k;
                }
            }
            else m.put(k,1);
            if(maxN==null) maxN=k;
        }
        System.out.print(maxN);
    }
}
