package Programmers;

import java.util.Arrays;

public class KthNum {
    public static void main(String[] args) throws Exception{
        int[] array = {};
        int[][] commands = {{},{},{}};
        int[] answer = {};
        int answer_count = 0;
        for(int i=0;i<commands.length;i++){
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            for(int j=0;j<temp.length;j++){
                temp[j]=array[commands[i][0]-1+j];
            }
            Arrays.sort(temp);
            answer[answer_count++]=temp[commands[i][1]-1];
        }
        for(int i=0;i<answer.length;i++) {
            System.out.println(answer[i]);
        }
    }
}
