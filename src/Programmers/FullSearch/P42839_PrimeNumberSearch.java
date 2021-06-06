package Programmers.FullSearch;

import java.util.HashSet;

public class P42839_PrimeNumberSearch {
    public static void main(String[] args) throws Exception{
        String numbers = "011";
        System.out.print(solution(numbers));
    }
    static boolean[] visited;
    static int[] numbersArray;
    static HashSet<Integer> answerSet;
    static int answer;
    static int solution(String numbers) {
        answer = 0;
        visited = new boolean[numbers.length()];
        numbersArray = new int[numbers.length()];
        answerSet = new HashSet<>();
        for(int i=0;i<numbers.length();i++) {
            numbersArray[i] = numbers.charAt(i) - '0';
            if(numbersArray[i]==2||numbersArray[i]==3||numbersArray[i]==5
                    ||numbersArray[i]==7) answerSet.add(numbersArray[i]);
        }
        for(int i=2;i<=numbers.length();i++) {
            int[] temp = new int[i];
            DFS(i, 0, temp,numbers.length());
        }
        answer += answerSet.size();
        return answer;
    }
    static void DFS(int length, int depth, int[] array, int numbersLength){
        if(length==depth){
            if(array[depth-1]==0) return;
            int digit = 1;
            int num=0;
            for(int i=0;i<length;i++){
                num+=(array[i]*digit);
                digit*=10;
            }
            int range = (int)Math.sqrt(num);
            for(int i=2;i<=range;i++){
                if(num%i==0) break;
                if(i==range) answerSet.add(num);
            }
            return;
        }
        for(int i=0;i<numbersLength;i++){
            if(!visited[i]){
                visited[i]=true;
                array[depth]=numbersArray[i];
                DFS(length,depth+1,array,numbersLength);
                visited[i]=false;
            }
        }
    }
}
