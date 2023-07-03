package block2.lesson1;

public class DogsWithHair extends Pets {
    private String ColorOfHair;

    public DogsWithHair(int age, String sex, int weight, String name, String owner, String colorOfHair) {
        super(age, sex, weight, name, owner);
        ColorOfHair = colorOfHair;
    }

    @Override
    public void voice() {
        if (!isAsleep()){
            System.out.println("Гав!");
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    @Override
    public String toString() {
        return "DogsWithHair{" +
                "ColorOfHair='" + ColorOfHair + '\'' +
                ", " + super.toString();
    }
}
