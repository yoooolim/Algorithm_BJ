package Baekjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_7983_IWillDoItTomorrow {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        solution(input());
    }
    public static ArrayList<Task> input() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks.add(new Task(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(tasks);
        return tasks;
    }
    public static void solution(ArrayList<Task> tasks){
        int rest = tasks.get(0).due;
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).due<rest){
                rest = tasks.get(i).due-tasks.get(i).time;
            }
            else{
                rest -= tasks.get(i).time;
            }
        }
        System.out.print(rest);
    }
    public static class Task implements Comparable<Task>{
        int time;
        int due;
        Task(int time, int due){ this.time = time; this.due = due; }
        @Override
        public int compareTo(Task t){ return (this.due>t.due)? -1:1; }
    }
}
