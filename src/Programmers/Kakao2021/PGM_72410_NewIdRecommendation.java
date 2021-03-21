package Programmers.Kakao2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    String.replaceAll("[^-_.a-z0-9]","")    ==> - _ . (a-z) (0-9) 빼고 다 없애라..!
    String.replaceAll("[.]{2,}",".")        ==> .이 2번 이상 반복되면 .로 변경해라..!
    String.replaceAll("^[.]|[.]$","");      ==> 처음이. or 마지막이. 이면 없애라..!!!
    정규식으로 치환하는 방식을 익히기. 아래는 이에 관련된 자료들 모음!
    https://codechacha.com/ko/java-regex/
 */

public class PGM_72410_NewIdRecommendation {
    public static void main(String[] args) throws Exception{
        BufferedReader new_id = new BufferedReader(new InputStreamReader(System.in));
        String sb = new_id.readLine();
        String answer = "";
        sb=sb.toLowerCase();
        for(int i=0;i<sb.length();i++){
            if(('A'<=sb.charAt(i)&&sb.charAt(i)<='Z')||('a'<=sb.charAt(i)&&sb.charAt(i)<='z')
            ||sb.charAt(i)=='-'||sb.charAt(i)=='_'||sb.charAt(i)=='.'||
                    ('0'<=sb.charAt(i)&&sb.charAt(i)<='9')){
                answer=answer+sb.charAt(i);
            }
        }
        while(answer.contains("..")){
            answer=answer.replace("..",".");
        }
        if(answer.charAt(0)=='.')answer=answer.substring(1);
        if(answer.length()>1)
            if(answer.charAt(answer.length()-1)=='.')
                answer=answer.substring(0,answer.length()-1);
        if(answer.isEmpty()) answer=answer+'a';
        if(answer.length()>15)answer=answer.substring(0,15);;
        if(answer.length()>1)
            if(answer.charAt(answer.length()-1)=='.')
                answer=answer.substring(0,answer.length()-1);
        while(answer.length()<3)answer=answer+answer.charAt(answer.length()-1);
        System.out.print(answer);
    }
}
