import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Date;

import java.util.Date;
import java.util.Scanner;

public class BOJ_1924 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();

        String date = getDate(month,day);
        String [] dydlf = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        Date Date2007 = new Date();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try{
            Date2007 = dateFormat.parse(date);}
        catch(ParseException ex){ex.printStackTrace();}
        cal.setTime(Date2007);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

        System.out.println(dydlf[dayNum-1]);
    }

    public static String getDate(int month, int day){
        String date="",Smonth="",Sday="";
        Smonth=Integer.toString(month);
        Sday=Integer.toString(day);
        if((month/10)==0){
            Smonth = "0"+ month;
        }
        if((day/10)==0){
            Sday="0"+ day;
        }
        date="2007"+Smonth+Sday;

        return date;
    }
}