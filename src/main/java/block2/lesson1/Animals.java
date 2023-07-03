package block2.lesson1;

import java.util.Random;

public abstract class Animals {
    private int age;
    private String sex;
    private int weight;
    private int maxWeight;
    private int minWeight = 2;
    private boolean asleep = false;
    private int minVolume = 10;
    private int maxVolume = 20;
    private int stomachVolume = new Random().nextInt((maxVolume - minVolume + 1) + minVolume);

    public Animals(int age, String sex, int weight) {
        this.age = age;
        this.sex = sex;

        int weightCoefficient = 4;
        int maxInputAge = 15;

        if (age < maxInputAge) {
            this.maxWeight = weight + age * weightCoefficient;
        } else {
            this.maxWeight = weight + maxInputAge * weightCoefficient;
        }

        if (weight > this.maxWeight){
            this.weight = this.maxWeight;
        } else {
            this.weight = weight;
        }
    }

    public void eat(int foodServing){
        if (!this.asleep) {
            if (this.weight < this.maxWeight) {
                System.out.println("Начинает есть.\n.\n.\n.");
                this.weight++;

                if (this.sex.equals("M")) {
                    System.out.println("Закончил есть.");
                } else {
                    System.out.println("Закончила есть.");
                }

                if (foodServing > this.stomachVolume){
                    System.out.println("Часть еды была не съедина.");
                }
            } else {
                System.out.println("Не хочет кушать, нужно больше двигаться.");
            }
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    public void sleep(){
        if (this.asleep){
            System.out.println("Спит. zzzZZZzzZZz");
        } else {
            System.out.println("Засыпает.\n.\n.\n.");
            this.asleep = true;
        }
    }

    public void wakeUp(){
        if (this.asleep) {
            System.out.println(".\n.\n.\nПросыпается.");
            this.asleep = false;
        } else {
            System.out.println("Бодрствует");
        }
    }

    public void move(){
        if (!this.asleep){
            if (this.weight != minWeight) {
                System.out.println("Начинает двигаться.\n.\n.\n.");
                this.weight--;

                if (this.sex.equals("M")) {
                    System.out.println("Закончил двигаться.");
                } else {
                    System.out.println("Закончила двигаться.");
                }

            } else {
                System.out.println("Не хватает энергии, нужно больше кушать.");
            }
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    public boolean isAsleep() {
        return this.asleep;
    }

    public abstract void voice();

    @Override
    public String toString() {
        return  "age=" + age +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                ", asleep=" + asleep +
                '}';
    }

}
