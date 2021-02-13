package Input_and_Output;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1000_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println(a+b);
    }
}
