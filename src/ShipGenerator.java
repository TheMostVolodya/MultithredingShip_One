import java.util.Random;

/**
 * Created by TheMostVolodya.
 */
public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }


    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Thread - генератор кораблей");
            count++;
            try {
                tunnel.add(new Ship(getRandomSize(), getRandomType()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}
