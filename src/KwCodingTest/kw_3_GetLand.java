package KwCodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kw_3_GetLand {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mapR = Integer.parseInt(st.nextToken(" "));
        int mapC = Integer.parseInt(st.nextToken(" "));
        int playerN = Integer.parseInt(st.nextToken(" "));
        int cmdM = Integer.parseInt(st.nextToken(" "));
        int[][] mapOwner = new int[mapR][mapC];
        int[] playerLand = new int[playerN];
        for(int i=0;i<cmdM;i++){
            st=new StringTokenizer(br.readLine());
            if(st.nextToken(" ").contains("2")){
                int[] cmdContent = new int[3];
                for(int j=0;j<3;j++) cmdContent[j]=Integer.parseInt(st.nextToken(" "));
                mapOwner[cmdContent[0]][cmdContent[1]]=cmdContent[2];
            }
            else{
                int[] cmdContent = new int[4];
                for(int j=0;j<4;j++) cmdContent[j]=Integer.parseInt(st.nextToken(" "));
                mapOwner[cmdContent[2]][cmdContent[3]]=mapOwner[cmdContent[0]][cmdContent[1]];
            }
        }
        for(int i=0;i<mapR;i++){
            for(int j=0;j<mapC;j++){
                if(mapOwner[i][j]==0)continue;
                playerLand[mapOwner[i][j]-1]++;
            }
        }
        for(int i=0;i<playerN;i++){
            System.out.print(playerLand[i]+" ");
        }
    }
}
