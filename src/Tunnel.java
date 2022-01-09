import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by TheMostVolodya.
 */
public class Tunnel {
    private List<Ship> list = new ArrayList<>();
    private Semaphore sem;

    public Tunnel(Semaphore sem) {
        this.sem = sem;
    }

    public synchronized void add(Ship element) throws InterruptedException {
        sem.acquire();
        list.add(element);
        System.out.println("Корабль размера " + element.getSize() + ", типа " + element.getType() +
                " прибыл в тунель: " + "---------------> " + Thread.currentThread().getName());
        Thread.sleep(500);
    }

    public synchronized Ship get(Type shipType) throws InterruptedException {
        for (Ship ship : list) {
            if (ship.getType() == shipType) {
                System.out.println("Корабль выходит из тунеля: " + Thread.currentThread().getName());
                list.remove(ship);
                return ship;
            }
        }
        sem.release();
        return null;
    }
}