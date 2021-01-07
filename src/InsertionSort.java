import java.util.*;

public class InsertionSort {
    public static void main(String[] args){
        ArrayList<Integer> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Option Number\n 0: List / 1: random");
        int option = sc.nextInt();
        System.out.println("Enter size of input");
        int inputNum = sc.nextInt();
        int innerloopnum1 = 0;
        int innerloopnum2 = 0;

        if(option == 0 ){
            /*오름 차순 정렬된 배열 => best
            for(int i=0;i<inputNum;i++){
                input.add(i);
            }
            //*/
            //*내림 차순 정렬된 배열 => worst
            for(int i=0;i<inputNum;i++){
                input.add(inputNum-i);
            }
            //*/
        }
        else if(option ==1 ){
            Random rd = new Random();
            for(int i=0;i<inputNum;i++){
                input.add(rd.nextInt(inputNum));
            }
        }
        else {
            System.out.println("Invalid Option Number");
            System.exit(-1);
        }

        System.out.println("input : "+input);
        //start timer
        long start= System.currentTimeMillis();
        /* 만약 input 배열의 크기가 1 이하라면 sort를
        할 필요가 없기 때문에 1 초과일 때만 들어온다.*/
        if(input.size()>1){
            //key값을 하나씩 늘려가며 확인한다.
            for(int i=1;i<input.size();i++,innerloopnum1++){ //inner loop test 1
                int j=i-1;
                //key값보다 작은 index의 값들을 비교한다.
                    //key의 값이 전의 index 배열보다 작다면
                while(j>=0&&(input.get(i)<input.get(j))) {
                    int temp = 0;
                    temp = input.get(i);
                    input.set(i, input.get(j));
                    input.set(j, temp);
                    j--;
                    innerloopnum2++;
                }
                innerloopnum2++;
                /*key의 값이 전의 index 배열 보다 작다면
                아무 일도 일어나지 않고 계속 탐색한다.*/
            }
        }
        //stop timer
        long end = System.currentTimeMillis();
        System.out.println("output : "+input);
        System.out.println("inner loop test 1 접근 횟수 : "+innerloopnum1);
        System.out.println("inner loop test 2 접근 횟수 : "+innerloopnum2);
        //System.out.println("실행 시간 : "+ (end-start) + "m 초");
    }
}
