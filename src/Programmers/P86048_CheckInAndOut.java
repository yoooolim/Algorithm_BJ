import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P86048_CheckInAndOut {
    public static void main(String[] args){
        /*int[] enter = {1, 3, 2, 4, 6, 5, 8, 7, 9, 10};
        int[] leave = {9, 5, 1, 10, 7, 4, 8, 6, 2, 3};*/
        int[] enter = {1, 3, 2};
        int[] leave = {1, 2, 3};
        solution(enter,leave);
    }
    public static int[] solution(int[] enter, int[] leave){
        int[] answer = new int[enter.length];
        int inIdx = 0;
        List<Integer> listEnt = Arrays.stream(enter).boxed().collect(Collectors.toList());
        List<Integer> inRoom = new ArrayList<>();
        for(int i=0;i<leave.length;i++){
            int wantOut = leave[i];
            int idx = inRoom.indexOf(wantOut);
            if(idx==-1){
                int enterIdx = listEnt.indexOf(wantOut);
                for(int j=inIdx;j<=enterIdx;j++) inRoom.add(enter[j]);
                inIdx = enterIdx+1;
                idx = inRoom.indexOf(wantOut);
            }
            inRoom.remove(idx);
            for(int item : inRoom) answer[item-1]++;
            answer[wantOut-1] += inRoom.size();
        }
        return answer;
    }
}
