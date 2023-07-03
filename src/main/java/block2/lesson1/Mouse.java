package block2.lesson1;

public class Mouse extends Pets {
    public Mouse(int age, String sex, int weight, String name, String owner) {
        super(age, sex, weight, name, owner);
    }

    @Override
    public void voice() {
        if (!isAsleep()){
            System.out.println("Пиу!");
        } else {
            System.out.println("Спит. zzzZZZzzZZz");
        }
    }

    @Override
    public String toString() {
        return "Mouse{" + super.toString();
    }
}
