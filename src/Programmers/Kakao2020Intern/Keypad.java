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
        if(togo==0) togo=11;
        while(origin!=togo){
            if((origin-1)/3<(togo-1)/3) origin+=3;
            else if((origin-1)/3>(togo-1)/3) origin-=3;
            else if(origin<togo) origin+=1;
            else if(origin>togo) origin-=1;
            result++;
        }
        return result;
    }


    public void changeValue(Keypad keypad, int menu,int num, char leftORright){
        if(menu==0){
            keypad.setAnswer(keypad.getAnswer()+"L");
            keypad.setLeft(num);
        }
        else if(menu==1){
            keypad.setAnswer(keypad.getAnswer()+"R");
            keypad.setRight(num);
        }
        else if(menu==2){
            if(leftORright=='L') changeValue(keypad,0,num,leftORright);
            else changeValue(keypad,1,num,leftORright);
        }
        else System.exit(200);
    }
}

class Main {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.print(solution(numbers,hand,hand.toUpperCase().charAt(0)));
    }

    public static String solution(int[] numbers, String hand, char leftORright){
        String answer = "";
        Keypad keypad = new Keypad(10,12,answer);
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0) numbers[i]=11;
            if(numbers[i]%3==1) keypad.changeValue(keypad,0,numbers[i],leftORright);
            else if(numbers[i]%3==0) keypad.changeValue(keypad,1,numbers[i],leftORright);
            else{
                int fromLeft =keypad.getToNum(keypad.getLeft(),numbers[i]);
                int fromRight =keypad.getToNum(keypad.getRight(),numbers[i]);

                if(fromLeft<fromRight) keypad.changeValue(keypad,0,numbers[i],leftORright);
                else if(fromLeft>fromRight)keypad.changeValue(keypad,1,numbers[i],leftORright);
                else keypad.changeValue(keypad,2,numbers[i],leftORright);
            }
        }
        answer=keypad.getAnswer();
        return answer;
    }
}