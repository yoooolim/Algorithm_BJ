import java.util.ArrayList;

public class example {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(1);
        temp2.add(4);
        if(temp.containsAll(temp2)) System.out.print("tq");
    }
}
