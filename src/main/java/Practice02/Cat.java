package Practice02;

public class Cat extends Animal{
    public void sleep() {
        System.out.println("야오야오");
    }

    @Override
    public void speak() {
        System.out.println("야옹야옹");
    }

    public static void main(String[] args) {

        Cat c = new Cat();
        c.name = "춘식";
        c.age = 3;
        c.showProfile();
        c.sleep();
        //문제 3
        Cat c2 = new Cat();
        c.name = "버터";
        c.age = 1;
        c.showProfile();
        c.sleep();

        Dog d = new Dog();
        d.name = "댕댕";
        d.age = 5;
        d.showProfile();
        d.run();
        //문제4

        Cat c3 = new Cat();
        c3.name = "순무";
        c3.age = 3;
        c3.showProfile();
        c3.speak();

        Dog d2 = new Dog();
        d.name = "두부";
        d.age = 3;
        d.showProfile();
        d.speak();

        //문제 5
        Animal[] animals = new Animal[4];
        for (int i = 0; i < animals.length; i++) {
            if(i % 2 == 0) {
                animals[i] = new Cat();
            } else {
                animals[i] = new Dog();
            }
            animals[i].speak();
        }
    }
}

class Animal {
    public String name;
    public int age;

    public void showProfile() {
        System.out.println("이름은 " + name + "이고" + age + "살입니다.");
    }

    public void speak() {
        System.out.println(".......");
    }
}

class Dog extends Animal{
    public void run() {
        System.out.println("달려 달려");
    }

    @Override
    public void speak() {
        System.out.println("멍멍");
    }
}


