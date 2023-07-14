package block2.lesson3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Container implements Comparable<Container>, Iterable<Box>{
    private List<Box> allBox;

    public Container(){
        this.allBox = new ArrayList<>();
    }

    public void addBox(Box box) {
        allBox.add(box);
        box.setId(this.allBox.size());
    }

    public Integer getWeightAllBoxInContainer(){
        int sum = 0;

        for (Box box: allBox) {
            sum += box.getWeight();
        }

        return sum;
    }

    public int getSize() {
        return this.allBox.size();
    }

    @Override
    public int compareTo(Container o) {
        return this.getWeightAllBoxInContainer().compareTo(o.getWeightAllBoxInContainer());
    }

    @Override
    public Iterator<Box> iterator() {
        return new BoxIterator(allBox);
    }

    @Override
    public String toString() {
        return "Количество ящиков "+ this.getSize() + " " + allBox;
    }
}
