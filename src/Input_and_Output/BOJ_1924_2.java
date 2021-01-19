package Input_and_Output;

import java.util.Scanner;

public class BOJ_1924_2 {
    public static void main(String[] args){
        String [] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int [] lastdate = {31,28,31,30,31,30,31,31,30,31,30,31};

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int date = sc.nextInt();
        int sum=0;

        for(int i=1;i<month;i++){
            sum+=lastdate[i-1];
        }
        sum+=date;
        System.out.println(day[sum%7]);
    }
}
