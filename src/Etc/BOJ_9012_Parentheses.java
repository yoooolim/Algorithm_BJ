package Etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    아주 작은 차이지만 위에 코드가 더 빠르다!
    할때마다 고려하기! 더 나은 코드는 없을꽈..? 이로케
 */

public class BOJ_9012_Parentheses {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<n;i++){
            String p = br.readLine();
            ans=0;
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='(') ans++;
                else ans--;
                if(ans<0) break;
            }
            if(ans==0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
/*

public class BOJ_9012_Parentheses {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0;i<n;i++){
            String p = br.readLine();
            ans=0;
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='(') ans++;
                else ans--;
                if(ans<0) {
                    sb.append("NO\n");
                    break;
                }
                else if(j==p.length()-1&&ans==0)sb.append("YES\n");
                else if(j==p.length()-1)sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
*/