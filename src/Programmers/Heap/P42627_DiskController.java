package Programmers.Heap;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P42627_DiskController {
    public static void main(String[] args) throws IOException{
//        int[][] jobs = {{0,3},{1,9},{2,6}};
        int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; //74
//        int[][]  jobs = {{0,20},{3,4},{3,5},{17,2}};
//        int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; //72
//        int[][] jobs = {{0,4},{0,3},{0,2},{0,1}};
//        int[][] jobs = {{0, 10},{4, 10},{15, 2},{5, 11}};//15
        solution(jobs);
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Task> waitQ = new PriorityQueue<>();
        PriorityQueue<Task> readyQ = new PriorityQueue<>(new MyComparator());

        for(int i=0;i<jobs.length;i++){
            waitQ.offer(new Task(jobs[i][0], jobs[i][1]));
        }

        Task firstTask = waitQ.poll();
        answer = firstTask.time;
        int timeGone = firstTask.time+ firstTask.start;
        int temp = 0;

        while(!waitQ.isEmpty()){
            Task now = waitQ.peek();
            while(timeGone>=waitQ.peek().start){
                now = waitQ.poll();
                readyQ.offer(now);
                if(waitQ.isEmpty()) break;
            }
            if(readyQ.isEmpty()){timeGone=now.start; continue;}
            temp = 0;
            now = readyQ.poll();
            answer += now.time+timeGone-now.start;
            timeGone+=now.time;
        }
        while(!readyQ.isEmpty()){
            Task now = readyQ.poll();
            answer += now.time+timeGone-now.start;
            timeGone+=now.time;
        }
        System.out.print(answer/jobs.length);
        return answer;
    }
    static class Task implements Comparable<Task>{
        int start;
        int time;
        Task(int start, int time){
            this.start = start;
            this.time = time;
        }
        @Override
        public int compareTo(Task o1) {return (this.start>o1.start)? 1:-1;}

    }
    public static class MyComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2){
            return (o1.time>o2.time? 1: -1);
        }
    }
}
