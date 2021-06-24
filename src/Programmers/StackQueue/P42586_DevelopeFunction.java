package Programmers.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class P42586_DevelopeFunction {
    static void main(String[] args){

    }
    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            q.offer((int) Math.ceil((100-progresses[i])/speeds[i]));
        }
        int before = q.poll();
        int count = 1;
        int answerCount = 0;
        while(q.isEmpty()){
        }
        return answer;
    }
}
