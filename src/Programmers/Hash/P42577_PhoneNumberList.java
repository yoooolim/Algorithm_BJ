package Programmers.Hash;

/* 접두가 -> startWith()! 접미사 -> endWith()!! */

import java.util.Arrays;

public class P42577_PhoneNumberList {
    public static void main(String[] args){
        String[] phone_book = {"123","456","789"};
        System.out.print(solution(phone_book));
    }
    static boolean solution(String[] phone_book){
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            String now = phone_book[i];
            if(phone_book[i+1].startsWith(now)) return false;
        }
        return true;
    }
}
