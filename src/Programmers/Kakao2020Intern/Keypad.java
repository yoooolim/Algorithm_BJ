package Programmers.Kakao2020Intern;

public class Keypad {
    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.print(solution(numbers,hand,hand.toUpperCase().charAt(0)));
    }

    public static String solution(int[] numbers, String hand, char leftORright){
        String answer = "";
        int Left = 10;
        int Right = 12;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%3==1) changeValue(answer,0,numbers[i],Left,Right,leftORright);
            else if(numbers[i]%3==0) changeValue(answer,1,numbers[i],Left,Right,leftORright);
            else{
                int fromLeft =getToNum(Left,numbers[i]);
                int fromRight =getToNum(Right,numbers[i]);

                if(fromLeft<fromRight) changeValue(answer,0,numbers[i],Left,Right,leftORright);
                else if(fromLeft>fromRight)changeValue(answer,1,numbers[i],Left,Right,leftORright);
                else changeValue(answer,2,numbers[i],Left,Right,leftORright);
            }
        }
        return answer;
    }
    public static Integer getToNum(int origin, int togo){
        int result = 0;
        if(origin==0) origin=11;
        while(origin!=togo){
            if((origin-1)/3<(togo-1)/3) origin+=3;
            else if((origin-1)/3>(togo-1)/3) origin-=3;
            else if(origin<togo) origin+=1;
            else if(origin>togo) origin-=1;
            result++;
        }
        return result;
    }

    public static void changeValue(String answer, int menu,int num, int Left, int Right, char leftORright){
        if(menu==0){
            answer+="L";
            Left=num;
        }
        else if(menu==1){
            answer+="R";
            Right=num;
        }
        else if(menu==2){
            if(leftORright=='l') changeValue(answer,0,num,Left,Right,leftORright);
            else changeValue(answer,1,num,Left,Right,leftORright);
        }
        else System.exit(200);
    }
}