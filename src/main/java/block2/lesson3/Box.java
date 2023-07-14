package block2.lesson3;

public class Box {
    private int weight;
    private int id;

    public Box(int weight) {
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
