package Programmers.Hash;

import java.util.ArrayList;
import java.util.Hashtable;

public class P42578_Camouflage {
    public static void main(String[] args){
        String[][] clothes = {{"crowmask", "face"}};
        System.out.print(solution(clothes));
    }
    static int solution(String[][] clothes) {
        ArrayList<String> field = new ArrayList<>();
        Hashtable<String, Integer> hash = new Hashtable<>();
        for(int i=0;i<clothes.length;i++){
            if(hash.containsKey(clothes[i][1])){
                hash.replace(clothes[i][1],hash.get(clothes[i][1])+1);
            }
            else {
                field.add(clothes[i][1]);
                hash.put(clothes[i][1], 1);
            }
        }
        int sum=1;
        for(int i=0;i<field.size();i++){
            sum*=(hash.get(field.get(i))+1);
        }
        sum--;
        return sum;
    }
}
