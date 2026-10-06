package playground;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public boolean remove(String item) {
        return items.remove(item);
    }

    public boolean contains(String item) {
        return items.contains(item);
    }

    public int size() {
        return items.size();
    }
}
