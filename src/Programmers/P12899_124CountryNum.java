package Programmers;

public class P12899_124CountryNum {
    public static void main(String[] args) throws Exception{
        int n=10;
        System.out.println(solution(n));
    }
    public static String solution(int n){
        String answer = "";
        while(n>0){
            int remain = n%3;
            n/=3;
            answer=switchNum(remain)+answer;
            if(remain==0) n--;
        }
        return answer;
    }
    public static String switchNum(int num){
        switch (num){
            case 0:
                return "4";
            case 1:
                return "1";
            case 2:
                return "2";
        }
        return "-1";
    }
}
