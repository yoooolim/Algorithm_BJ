package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
    끝에서 두번째 것이 (일 리가 없다! -> 연산 순서에 의해서
    if(seq.charAt(i)=='('&&seq.charAt(i+1)==')') 이 가능
 */

public class BOJ_10799_IronBar {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq = br.readLine();
        int c = 0;
        int p = 0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('&&seq.charAt(i+1)==')') {
                c+=p;
                ++i;
            }
            else if(seq.charAt(i)=='(') p++;
            else {c++;--p;}
        }
        System.out.print(c);
    }
}
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq = br.readLine();
        int c = 0;
        int p = 0;
        for(int i=0;i<seq.length()-1;i++){
            if(seq.charAt(i)=='('&&seq.charAt(i+1)==')') {
                c+=p;
                if(seq.charAt((i+2))==')'){++c;}
                ++i;
            }
            else if(seq.charAt(i)=='(') p++;
            else if(seq.charAt(i)==')'&&seq.charAt(i+1)==')') {c++;--p;}
            else --p;
        }
        System.out.print(c);
    }
}

 */