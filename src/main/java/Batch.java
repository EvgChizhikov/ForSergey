import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;

public class Batch implements Runnable {

    InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086");

    static boolean flag = true;

     static BatchPoints batchPoints = BatchPoints
            .database("mydb")
            .retentionPolicy("defaultPolicy")
            .build();

//    Thread t1 = new Thread(new WriteToBatch());
    public void run() {
        while (flag) {
            influxDB.write(batchPoints);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            t1.start();
        }

        if(!(batchPoints == null)) {
            influxDB.write(batchPoints);
        }
    }

    public BatchPoints getBatchPoints() {
        return batchPoints;
    }

    public void setBatchPoints(BatchPoints batchPoints) {
        this.batchPoints = batchPoints;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
