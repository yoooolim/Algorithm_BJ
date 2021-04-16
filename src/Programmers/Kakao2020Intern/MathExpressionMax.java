package Programmers.Kakao2020Intern;

import java.util.ArrayList;

class Expression{
    private ArrayList<Integer> operator;
    private ArrayList<Integer> number;
    private boolean plus;
    private boolean minus;
    private boolean mul;

    public ArrayList<Integer> getOperator() {
        return operator;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void addOperator(int operator){
        this.operator.add(operator);
    }

    public void addNumber(int num){
        this.number.add(num);
    }
    public boolean isPlus() {
        return plus;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }

    public boolean isMinus() {
        return minus;
    }

    public void setMinus(boolean minus) {
        this.minus = minus;
    }

    public boolean isMul() {
        return mul;
    }

    public void setMul(boolean mul) {
        this.mul = mul;
    }

    public Expression(){
        this.operator=new ArrayList<>();
        this.number=new ArrayList<>();
        this.plus = false;
        this.minus = false;
        this.mul = false;
    }

}

public class MathExpressionMax {
    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        solution(expression);
    }

    public static long solution(String expression){
        long answer = 0;
        Expression ex = new Expression();
        // 숫자, operator 구분
        seperate_oper_num(expression,ex);
        answer=calculateMax(ex);
        return answer;
    }
    public static long calculateMax(Expression ex){
        int cal_num = 0;
        long max = 0;
        if(ex.isPlus()) cal_num++;
        if(ex.isMinus()) cal_num++;
        if(ex.isMul()) cal_num++;
        cal_num=(int)(Math.pow(cal_num,2)*cal_num/2);
        for(int i=0;i<cal_num;i++){
            int cal = 0;
            max=Math.max(max,0);
        }
        return max;
    }
    public static int seperate_oper_num(String expression,Expression ex){
        int result = 0;
        String[] str = expression.split("[+*-]");
        int sum=0;
        for(int i=0;i<str.length-1;i++){
            ex.addNumber(Integer.parseInt(str[i]));
            sum+=Math.log10(ex.getNumber().get(i))+1;
            ex.addOperator(toOperator(expression.charAt(sum++)));
        }
        ex.addNumber(Integer.parseInt(str[str.length-1]));
        if(ex.getOperator().indexOf(0)!=-1) ex.setPlus(true);
        if(ex.getOperator().indexOf(1)!=-1) ex.setMinus(true);
        if(ex.getOperator().indexOf(2)!=-1) ex.setMul(true);
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