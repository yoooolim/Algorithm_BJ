import java.util.Scanner;
import static java.lang.System.exit;

public class BOJ_10953 {
    static String str;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        str = sc.nextLine();

        for(int i=0;i<num;i++){
            str = sc.nextLine();
            String[] strsplit = str.split(",");
            if(strsplit.length!=2) {exit(5);}
            System.out.println(Integer.parseInt(strsplit[0])+Integer.parseInt(strsplit[1]));
        }
    }
}
