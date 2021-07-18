package Programmers;

import java.io.IOException;

public class P77485_RotateMatrixBoarder {
    public static void main(String[] args) throws IOException{
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int [] answer = solution(6,6,queries);
        for(int i=0;i<answer.length;i++) System.out.print(answer[i]+" ");
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = columns*i+j+1;
            }
        }
        for(int i=0;i<queries.length;i++){
            answer[i]=rotateMin(matrix, queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1);
        }
        return answer;
    }
    public static int rotateMin(int[][] matrix, int x1, int y1, int x2, int y2){
        int a = x2-x1, b=y2-y1;
        int min = 10001;
        int remain = matrix[x1][y1];
        min = Math.min(min,remain);
        for(int i=0;i<a;i++){
            matrix[x1+i][y1]=matrix[x1+i+1][y1];
            min = Math.min(min,matrix[x1+i][y1]);
        }
        for(int i=0;i<b;i++){
            matrix[x2][y1+i]=matrix[x2][y1+i+1];
            min = Math.min(min,matrix[x2][y1+i]);
        }
        for(int i=0;i<a;i++){
            matrix[x2-i][y2]=matrix[x2-i-1][y2];
            min = Math.min(min,matrix[x2-i][y2]);
        }
        for(int i=0;i<b-1;i++){
            matrix[x1][y2-i]=matrix[x1][y2-i-1];
            min = Math.min(min,matrix[x1][y2-i]);
        }
        matrix[x1][y1+1]=remain;
        return min;
    }
}
