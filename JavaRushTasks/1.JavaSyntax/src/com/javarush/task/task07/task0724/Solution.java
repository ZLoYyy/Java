package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human man1 = new Human("Катя", false, 55);
        Human man2 = new Human("Павел", true, 53);
        Human man3 = new Human("Елена", false, 55);
        Human man4 = new Human("Сергей", true, 25);
        Human man5 = new Human("Аня", false, 21, man2, man1);
        Human man6 = new Human("Олег", true, 25, man4, man3);
        Human man7 = new Human("Игорь", true, 2, man5, man6);
        Human man8 = new Human("Ира", false, 5, man5, man6);
        Human man9 = new Human("Олег", true, 8, man5, man6);

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(man3);
        System.out.println(man4);
        System.out.println(man5);
        System.out.println(man6);
        System.out.println(man7);
        System.out.println(man8);
        System.out.println(man9);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















