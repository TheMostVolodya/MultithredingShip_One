import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by TheMostVolodya.
 */
public class Main {
    public static  void main(String[] args) {
        System.out.println("Доступное количество ядер: " + Runtime.getRuntime().availableProcessors());

        Semaphore sem = new Semaphore(5);
        Tunnel tunnel = new Tunnel(sem);
        ShipGenerator gen = new ShipGenerator(tunnel, 15);

        PierLoader pier1 = new PierLoader(tunnel, Type.MILK);
        PierLoader pier2 = new PierLoader(tunnel, Type.BREAD);
        PierLoader pier3 = new PierLoader(tunnel, Type.MEAT);


        //option 1
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(gen);
        service.execute(pier1);
        service.execute(pier2);
        service.execute(pier3);
/*
        // option 2
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors());
        service.schedule(gen, 1, TimeUnit.SECONDS);
        service.schedule(pier1, 1, TimeUnit.SECONDS);
        service.schedule(pier2, 1, TimeUnit.SECONDS);
        service.schedule(pier3, 1, TimeUnit.SECONDS);
 */
        service.shutdown();


    }
}