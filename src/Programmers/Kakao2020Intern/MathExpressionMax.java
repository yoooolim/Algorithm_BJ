package Programmers.Kakao2020Intern;

import java.util.ArrayList;

public class MathExpressionMax {
    public static void main(String[] args) throws Exception{
        String expression = "100-200*300-500+20";
        solution(expression);
    }

    public static long solution(String expression){
        long answer = 0;
        ArrayList<Integer> operator = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        // 숫자, operator 구분
        seperate_oper_num(expression,operator,number);
        
        return answer;
    }
    public static int seperate_oper_num(String expression,ArrayList<Integer> operator,
                                         ArrayList<Integer> number){
        int result = 0;
        String[] str = expression.split("[+*-]");
        int sum=0;
        for(int i=0;i<str.length-1;i++){
            number.add(Integer.parseInt(str[i]));
            sum+=Math.log10(number.get(i))+1;
            operator.add(toOperator(expression.charAt(sum++)));
        }
        number.add(Integer.parseInt(str[str.length-1]));
        if(operator.indexOf(0)!=-1) result+=100;
        if(operator.indexOf(1)!=-1) result+=10;
        if(operator.indexOf(2)!=-1) result+=1;
        return result;
    }
    public static int toOperator(char c){
        int result = -1;
        switch (c) {
            case '+' : result = 0; break;
            case '-' : result = 1; break;
            case '*' : result = 2; break;
        }
        return result;
    }
}