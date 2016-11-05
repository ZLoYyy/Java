package TRPO.Lesson1;

/**
 * Created by ((ZLoY)) on 29.10.2016.
 */
 abstract public class Human {
    private int age;
    private String name;


    public void sayHello() {
        System.out.println(name + " " + age + " years old says 'Hello'");
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Human() {
        age = 0;
        name = "";
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public void say(String word)

    {
        System.out.println(word);
    }

  public abstract String getGender();



}
