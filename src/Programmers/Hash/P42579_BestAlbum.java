/*package Programmers.Hash;

import java.lang.reflect.Array;
import java.util.*;

public class P42579_BestAlbum {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.print(solution(genres,plays));
    }
    static int[] solution(String[] genres, int[] plays) {
        int[] ans = {};
        PriorityQueue<Integer> sum = new PriorityQueue<>();
        HashMap<String, Integer> genreSum = new HashMap<>();
        HashMap<String, PriorityQueue<Top2>> hash = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(genreSum.containsKey(genres[i])){
                sum.offer(genreSum.get(genres[i])+plays[i]);
                genreSum.replace(genres[i],genreSum.get(genres[i])+plays[i]);
                hash.get(genres[i]).offer(new Top2(i,plays[i]));
            }
            else{
                PriorityQueue<Top2> pq = new PriorityQueue<>();
                pq.offer(new Top2(i,plays[i]));
                genreSum.put(genres[i],plays[i]);
                hash.put(genres[i],pq);
                sum.offer(plays[i]);
            }
        }
        int firstSum = sum.poll();
        int secondSum = sum.poll();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for(int i=0;i<genreSum.size();i++){
            if(genreSum.get())
        }
        return ans;
    }
    static class Top2 implements Comparator<Top2>{
        int index;
        int play;
        Top2(int index,int play){
            this.index=index;
            this.play=play;
        }
        @Override
        public int compare(Top2 o1, Top2 o2){
            if(o1.play>o2.play) return 1;
            else if(o1.play==o2.play){
                return (o1.index>o2.index)? 1:-1;
            }
            return -1;
        }
    }
}
*/