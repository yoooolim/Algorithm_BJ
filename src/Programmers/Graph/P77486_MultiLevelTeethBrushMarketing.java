package Programmers.Graph;

import java.io.IOException;
import java.util.*;

public class P77486_MultiLevelTeethBrushMarketing {
    public static void main(String[] args) throws IOException{
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[]  amount = {12, 4, 2, 5, 10};
        int[] answer = solution(enroll,referral,seller,amount);
        for(int i : answer){ System.out.print(i+" "); }
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        List<Employee> tree = new ArrayList<>();

        for(int i=0;i<enroll.length;i++){
            Employee temp = new Employee(enroll[i],null,0);
            tree.add(temp);
        }
        for(int i=0;i<enroll.length;i++){
            if(referral[i].equals("-")) continue;
            int idx = findIdxFromName(tree,referral[i]);
            tree.get(i).whoInvitedMe = tree.get(idx);
        }
        for(int i=0;i<seller.length;i++){
            Employee now = tree.get(findIdxFromName(tree,seller[i]));
            int am = amount[i]*100;
            while(now.whoInvitedMe!=null){
                int give = am*10/100;
                int temp = am-give;
                now.money+=temp;
                am -=temp;
                now=now.whoInvitedMe;
            }
            now.money+=(am-(am*10/100));
        }
        for(int i=0;i<enroll.length;i++){
            answer[i]=tree.get(i).money;
        }
        return answer;
    }
    static class Employee{
        public String name;
        public Employee whoInvitedMe;

        public void setMoney(int money) {
            this.money = money;
        }

        public int money;
        Employee(String name, Employee whoInvitedMe, int money){
            this.name = name;
            this.whoInvitedMe = whoInvitedMe;
            this.money = money;
        }
    }
    static int findIdxFromName(List<Employee> tree,String find){
        int i = 0;
        for(i=0;i<tree.size();i++){
            if(tree.get(i).name.equals(find)) break;
        }
        return i;
    }
}
