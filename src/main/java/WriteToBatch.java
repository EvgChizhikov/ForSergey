import org.influxdb.dto.Point;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WriteToBatch implements Runnable {

//    Batch batch = new Batch();


    public void run() {

        for (int i = 0; i < 99; i++) {

            long a = System.currentTimeMillis();

            Point point1 = Point.measurement("memory")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("name", "server1")
                    .addField("free", 4743656L)
                    .addField("used", 1015096L)
                    .addField("buffer", 1010467L)
                    .build();
            Batch.batchPoints.point(point1);
            try {
                Thread.sleep(getRandNum(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long b = System.currentTimeMillis();

            Point point3 = Point.measurement("memory")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("timeOfTrasaction", b - a)
                    .build();

            Batch.batchPoints.point(point3);

            System.out.println(i);
            if (i == 98) {
                Batch.flag = false;
            }


        }
    }

    public static int getRandNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
