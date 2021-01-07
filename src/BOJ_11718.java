import java.util.Scanner;

public class BOJ_11718 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.length()>100) break;
            System.out.println(str);
        }
        sc.close();
    }
}
