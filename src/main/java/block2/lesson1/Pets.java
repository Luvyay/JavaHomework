package block2.lesson1;

public abstract class Pets extends Animals {
    private String name;
    private String owner;

    public Pets(int age, String sex, int weight, String name, String owner) {
        super(age, sex, weight);
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", " + super.toString();
    }

    public abstract void voice();
}
