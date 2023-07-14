package block2.lesson3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BoxIterator implements Iterator<Box> {
    private List<Box> allBox;
    private int position;

    public BoxIterator(List<Box> allBox) {
        this.allBox = allBox;
    }

    @Override
    public boolean hasNext() {
        return position < allBox.size();
    }

    @Override
    public Box next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return allBox.get(position++);
    }
}
