import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2116_DiceStacking {
    static int diceN;
    static int[][] dices;
    public static void main(String[] args)throws IOException {
        input();
        solution();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        diceN = Integer.parseInt(br.readLine());
        dices = new int[diceN][6];
        for(int i=0;i<diceN;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++) dices[i][j] = Integer.parseInt(st.nextToken(" "));
        }
    }
    public static void solution(){
        int answer = 0;
        for(int i=0;i<6;i++){
            answer = Math.max(getMaxSum(i),answer);
        }
        System.out.print(answer);
    }
    public static int getMaxSum(int dice1Bottom){
        int dice1TopNum = dices[0][dice1Bottom];
        int dice1BottomNum = dices[0][getIdxTop(dice1Bottom)];
        int sum = diceSideMax(dice1TopNum,dice1BottomNum);
        for(int i=1;i<diceN;i++){
            int idxBottom = findIdxBottom(i,dice1TopNum);
            dice1BottomNum = dices[i][idxBottom];
            dice1TopNum = dices[i][getIdxTop(idxBottom)];
            sum+=diceSideMax(dice1TopNum,dice1BottomNum);
        }
        return sum;
    }
    public static int diceSideMax(int diceTopNum, int diceBottomNum){
        if(diceTopNum!=6&&diceBottomNum!=6) return 6;
        if(diceTopNum!=5&&diceBottomNum!=5) return 5;
        return 4;
    }
    public static int findIdxBottom(int diceNumber, int find){
        for(int i=0;i<6;i++){
            if(dices[diceNumber][i]==find) return i;
        }
        return 0;
    }
    public static int getIdxTop(int idxBottom){
        if(idxBottom == 0) return 5;
        if(idxBottom == 5) return 0;
        if(idxBottom==1||idxBottom==2) return idxBottom+2;
        return idxBottom-2;
    }
}
