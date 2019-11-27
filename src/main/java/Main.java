import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.dto.Query;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main  {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Batch());
        Thread t2 = new Thread(new WriteToBatch());



        t1.start();
        t2.start();



}}
