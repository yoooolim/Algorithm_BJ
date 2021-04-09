package Programmers.Kakao2020Intern;

public class MathExpressionMax {
    public static void main(String[] args) throws Exception{
        String expression = "100-200*300-500+20";
        solution(expression);
    }
    public static long solution(String expression){
        long answer = 0;
        String[] str = expression.split("[+*-]");
        int[] operator = new int[str.length-1];
        int[] number = new int[str.length];
        int sum=0;
        for(int i=0;i<str.length-1;i++){
            number[i]=Integer.parseInt(str[i]);
            sum+=Math.log10(number[i])+1;
            operator[i]=toOperator(expression.charAt(sum++));
        }
        number[str.length-1]=Integer.parseInt(str[str.length-1]);

        for(int i=0;i<number.length;i++){
            System.out.print(number[i]+"\n");
        }
        for(int i=0;i<operator.length;i++){
            System.out.print(operator[i]+"\n");
        }
        return answer;
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