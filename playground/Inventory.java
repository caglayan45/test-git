package playground;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }
}
