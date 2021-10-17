import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713_RecommendCandidate {
    public static void main(String[] args) throws IOException {
        boolean[] isInFrame = new boolean[101];
        List<Student> frame = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frameCnt = Integer.parseInt(br.readLine());
        int recCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 0;

        for(int i=0;i<recCnt;i++){
            int recStud = Integer.parseInt(st.nextToken());
            Collections.sort(frame);
            if(isInFrame[recStud]){ //추천 받은 학생이 이미 frame에 있는 경우
                for(Student s : frame){
                    if(s.idx==recStud) s.recommend++;
                }
            } else { //frame에 없는 학생이 추천 받은 경우
                if(frame.size()>=frameCnt){ //frame이 이미 차 있다면 요소 지우기
                    Student eraseStud = frame.get(0);
                    isInFrame[eraseStud.idx]=false;
                    frame.remove(0);
                }
                isInFrame[recStud]=true;
                frame.add(new Student(recStud,1,time++));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Student s : frame) ans.add(s.idx);
        Collections.sort(ans);
        for(int item : ans) System.out.print(item+" ");
    }
    private static class Student implements Comparable<Student>{
        int idx; int recommend; int time;
        Student(int idx, int recommend, int time){ this.idx = idx; this.recommend = recommend; this.time=time; }
        public int compareTo(Student s){
            //들어온 것의 추천 수가 적으면 앞으로, 같거나(늦게 들어왔으니까) 크면 뒤로
            return (this.recommend<s.recommend)? -1: (this.recommend>s.recommend)? 1 : (this.time<s.time)? -1 : 1;
        }
    }
}

