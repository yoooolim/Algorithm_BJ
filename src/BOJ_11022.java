import java.util.ArrayList;
        import java.util.Scanner;

public class BOJ_11022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList result = new ArrayList();

        for(int i =0;i<num;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            result.add(a+b);
            System.out.println("Case #"+(i+1)+": "+a+" + "+b+" = "+result.get(i));
        }
    }
}
