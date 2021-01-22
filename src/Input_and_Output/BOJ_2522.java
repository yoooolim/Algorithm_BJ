package Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2522 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            for(int j=n-i-1;j>0;j--) bw.write(' ');
            for(int j=0;j<i+1;j++) bw.write('*');
            bw.write("\n");
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++) bw.write(' ');
            for(int j=n-i;j>0;j--) bw.write('*');
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
