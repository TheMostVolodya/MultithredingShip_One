/**
 * Created by TheMostVolodya.
 */
public class PierLoader implements Runnable {
    private Tunnel tunnel;
    private Type type;


    public PierLoader(Tunnel tunnel, Type type) {
        this.tunnel = tunnel;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Погрузчик " + type);

                //погрузка товара
                Thread.sleep(500);
                Ship ship = tunnel.get(type);
                if (ship != null)
                    while (ship.countCheck()) {
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println("Корабль " + ship.getSize() + " " + ship.getType() +  " загружен на " + ship.getCount() + " единиц");
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}