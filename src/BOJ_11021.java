import java.util.ArrayList;
        import java.util.Scanner;

public class BOJ_11021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList result = new ArrayList();

        for(int i =0;i<num;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            result.add(a+b);
        }
        for(int i=0;i<result.size();i++){
            System.out.println("Case #"+(i+1)+": "+result.get(i));
        }
    }
}