/*package Blog;

abstract class Animal{ // abstract 추상 class는 다중 상속 불가!
    protected int ageAvg;
    Animal(int age){ageAvg=age;}
    public void sayAge(){System.out.print("Our life expectancy is "+ageAvg+"\n\n");}
    abstract void info(); //추상 메서드! -> 구현은 상속받은 친구들에게서
}

class Cat extends Animal{
    public Cat(int age){super(age);}
    @Override
    public void info(){
        System.out.print("cat cry like meow!\n");
        sayAge();
    }
}

class Dog extends Animal{
    public Dog(int age){super(age);}
    @Override
    public void info(){
        System.out.print("dog cry like woof-woof!\n");
        sayAge();
    }
}

class Tiger extends Animal{
    public Tiger(int age){super(age);}
    @Override
    public void info(){
        System.out.print("Tiger cry like roar!\n");
        sayAge();
    }
}

public class abstract_example_1 {
    public static void main(String[] args){
        Animal dog = new Dog(13);
        Animal cat = new Cat(15);
        Animal tiger = new Tiger(10);

        cat.info();
        dog.info();
        tiger.info();
    }
}
*/