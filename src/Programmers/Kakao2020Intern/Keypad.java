package Programmers.Kakao2020Intern;

public class Keypad{
    private int Left;
    private int Right;
    private String answer;

    public int getLeft() {
        return Left;
    }

    public void setLeft(int left) {
        Left = left;
    }

    public int getRight() {
        return Right;
    }

    public void setRight(int right) {
        Right = right;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public Keypad(int l, int r, String a){
        this.Left = l;
        this.Right = r;
        this.answer = a;
    }

    public Integer getToNum(int origin, int togo){
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


    public void changeValue(String answer, int menu,int num, int Left, int Right, char leftORright){
        if(menu==0){
            this.answer="L";
            this.Left=num;
        }
        else if(menu==1){
            this.answer+="R";
            this.Right=num;
        }
        else if(menu==2){
            if(leftORright=='l') changeValue(answer,0,num,Left,Right,leftORright);
            else changeValue(answer,1,num,Left,Right,leftORright);
        }
        else System.exit(200);
    }
}

class Main {
    public static void main(String[] args){
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.print(solution(numbers,hand,hand.toUpperCase().charAt(0)));
    }

    public static String solution(int[] numbers, String hand, char leftORright){
        String answer = "";
        Keypad keypad = new Keypad(10,12,answer);
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]%3==1) keypad.changeValue(answer,0,numbers[i],keypad.getLeft(),keypad.getRight(),leftORright);
            else if(numbers[i]%3==0) keypad.changeValue(answer,1,numbers[i],keypad.getLeft(),keypad.getRight(),leftORright);
            else{
                int fromLeft =keypad.getToNum(keypad.getLeft(),numbers[i]);
                int fromRight =keypad.getToNum(keypad.getRight(),numbers[i]);

                if(fromLeft<fromRight) keypad.changeValue(answer,0,numbers[i],keypad.getLeft(),keypad.getRight(),leftORright);
                else if(fromLeft>fromRight)keypad.changeValue(answer,1,numbers[i],keypad.getLeft(),keypad.getRight(),leftORright);
                else keypad.changeValue(answer,2,numbers[i],keypad.getLeft(),keypad.getRight(),leftORright);
            }
        }
        return answer;
    }
}