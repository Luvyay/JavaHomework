package block2.lesson1;

public class CatsWithHair extends Pets {
    private String ColorOfHair;

    public CatsWithHair(int age, String sex, int weight, String name, String owner, String colorOfHair) {
        super(age, sex, weight, name, owner);
        ColorOfHair = colorOfHair;
    }

    @Override
    public void voice() {
        if (!isAsleep()){
            System.out.println("Мяу!");
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    public void purr(){
        if (!isAsleep()){
            System.out.println("Мрррр!");
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    @Override
    public String toString() {
        return "CatsWithHair{" +
                "ColorOfHair='" + ColorOfHair + '\'' +
                ", " + super.toString();
    }
}
