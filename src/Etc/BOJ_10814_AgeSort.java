package Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    실행 시간을 더 빠르게 하기 위해서는 StringBuilder와
    나이를 index로 배열 저장 하는 방법이 있다.
 */

class Pair{
    Integer x;
    String y;
    public Pair(Integer x, String y){
        this.x=x;
        this.y=y;
    }
    public Integer getKey() { return x; }
    public String getValue(){ return y; }
}

public class BOJ_10814_AgeSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> inf = new ArrayList<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inf.add(new Pair(Integer.parseInt(st.nextToken(" ")),
                    st.nextToken(" ")));
        }
        Collections.sort(inf, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.getKey()>o2.getKey()) return 1;
                else if(o1.getKey()<o2.getKey()) return -1;
                else return 0;
            }
        });
        for(int i=0;i<n;i++) bw.write(inf.get(i).getKey()+" "+
                inf.get(i).getValue()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
