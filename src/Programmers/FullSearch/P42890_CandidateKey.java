package Programmers.FullSearch;

import java.util.*;

public class P42890_CandidateKey {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> candidate;
    public static void main(String[] args) throws Exception{
        String[][] relation = {{"a","1","aaa","c","ng"},
                {"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"}};
        System.out.print(solution(relation));
    }
    static int solution(String[][] relation) {
        int answer = 0;
        candidate = new ArrayList<>();
        visited = new boolean[relation[0].length];
        int[] inArray;
        for(int i=1;i<=relation[0].length;i++){
            inArray = new int[i];
            dfs(i,relation,0,inArray);
        }
        answer = candidate.size();
        return answer;
    }
    static void dfs(int length, String[][] relation, int depth, int[] inArray){
        if(length==depth){
            HashSet<String> notCon = new HashSet<>();
            for(int i=0;i<relation.length;i++){
                String sum="";
                for(int j=0;j<inArray.length;j++){
                    sum+=relation[i][inArray[j]];
                }
                notCon.add(sum);
            }
            if(notCon.size()==relation.length){
                candidate.add(new ArrayList<>());
                for(int i=0;i<inArray.length;i++){
                    candidate.get(candidate.size()-1).add(inArray[i]);
                }
                for(int i=0;i<candidate.size()-1;i++){
                    ArrayList<Integer> temp1 = candidate.get(candidate.size()-1);
                    ArrayList<Integer> temp2 = candidate.get(i);
                    boolean is = candidate.get(candidate.size()-1).containsAll(candidate.get(i));
                    if(candidate.get(candidate.size()-1).containsAll(candidate.get(i))){
                        candidate.remove(candidate.get(candidate.size()-1));
                        break;
                    }
                }
            }
            return;
        }
        for(int i=0;i<relation[0].length;i++){
            if(!visited[i]){
                visited[i]=true;
                inArray[depth]=i;
                dfs(length,relation,depth+1,inArray);
                visited[i]=false;
            }
        }
    }
}
