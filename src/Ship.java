/**
 * Created by TheMostVolodya.
 */
public class Ship {



    private int count;
    private Size size;
    private Type type;

    public Ship(Size size, Type type) {
        this.size = size;
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
    public int getCount() {
        return count;
    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheck() {
        if (count >= size.getValue()) {
            return false;
        }
        return true;
    }
}