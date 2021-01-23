package Input_and_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10992 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//commit
        //test
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n-1;i++){
            for(int j=n-i-1;j>0;j--) bw.write(' ');
            bw.write('*');
            if(i==0) {
                bw.write("\n");
                continue;
            }
            for(int j=0;j<2*i-1;j++) bw.write(' ');
            bw.write('*');
            bw.write("\n");
        }
        for(int i=0;i<2*n-1;i++) bw.write('*');
        bw.flush();
    }
}
