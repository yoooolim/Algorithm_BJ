import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5567_Wedding {
    public static void main(String[] args) throws IOException {
        Person sang = input();
        solution(sang);
    }
    private static Person input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int colleague = Integer.parseInt(br.readLine());
        int listLen = Integer.parseInt(br.readLine());
        Person[] list = new Person[colleague+1];
        for(int i=1;i<=colleague;i++) list[i]= new Person(i,new HashSet<>());
        for(int i=0;i<listLen;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].friends.add(list[B]);
            list[B].friends.add(list[A]);
        }
        return list[1];
    }
    private static void solution(Person sang) throws IOException{
        Set<Integer> invite = new HashSet<>();
        for(Person first : sang.friends){
            invite.add(first.name);
            for(Person second : first.friends) invite.add(second.name);
        }
        invite.remove(1);
        System.out.print(invite.size());
    }
    private static class Person{
        int name; Set<Person> friends;
        Person(int name, Set<Person> friends){
            this.name = name; this.friends = friends;
        }
    }
}
