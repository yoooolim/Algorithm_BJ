package Baekjoon.Etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11651_PointSort2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> seq = new ArrayList<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            seq.add(new Point(Integer.parseInt(st.nextToken(" ")),
                    Integer.parseInt(st.nextToken(" "))));
        }
        Collections.sort(seq, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b){
                if(a.y>b.y) return 1;
                else if(a.y<b.y) return -1;
                else if(a.y==b.y){
                    if(a.x>b.x) return 1;
                    else return -1;
                }
                return 0;
            }
        });
        for(int i=0;i<n;i++) bw.write(seq.get(i).x+" "+seq.get(i).y+"\n");
        bw.flush();
        bw.close();
    }
}
