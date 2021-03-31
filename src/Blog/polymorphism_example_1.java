package Blog;

class A{
    void call(){
        System.out.print("I'm A\n");
    }
}

class A_1 extends A{
    @Override
    void call(){
        System.out.print("I'm A_1\n");
    }
}

public class polymorphism_example_1 {
    public static void main(String[] args){
        A a = new A_1();
        a.call();
    }
}
