package Etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair10825{
    String name;
    Integer k;
    Integer e;
    Integer m;

    public Pair10825(String name, Integer k, Integer e, Integer m){
        this.name=name;
        this.k=k;
        this.e=e;
        this.m=m;
    }

}

public class BOJ_10825_KEMSort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair10825> inf = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            inf.add(new Pair10825(st.nextToken(" "),
                    Integer.parseInt(st.nextToken(" ")),
                    Integer.parseInt(st.nextToken(" ")),
                    Integer.parseInt(st.nextToken(" "))));
        }
        Collections.sort(inf, new Comparator<Pair10825>() {
            @Override
            public int compare(Pair10825 o1, Pair10825 o2) {
                if(o1.k<o2.k) return 1;
                else if(o1.k>o2.k) return -1;
                else if(o1.k==o2.k){
                    if(o1.e>o2.e) return 1;
                    else if(o1.e<o2.e) return -1;
                    else if(o1.e==o2.e){
                        if(o1.m<o2.m) return 1;
                        else if(o1.m>o2.m) return -1;
                        else if(o1.m==o2.m){
                            if(o1.name.compareTo(o2.name)<0) return -1;
                            else return 1;
                        }
                    }
                }
                return 0;
            }
        });
        for(int i=0;i<n;i++) bw.write(inf.get(i).name+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
