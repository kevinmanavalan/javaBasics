import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SynchronizationExample {
    private int sum;
    public void calculate(){
        setSum(getSum() + 1);
    }
    public int getSum(){
        return sum;
    }
    public void setSum(int sum){
        this.sum=sum;
    }

   class SyncTest{
       public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
           ExecutorService service = Executors.newFixedThreadPool(3);
           SynchronizationExample summation = new SynchronizationExample();
           IntStream.range(0, 1000)
                   .forEach(count -> service.submit(summation::calculate));
           service.awaitTermination(1000, TimeUnit.MILLISECONDS);

           assertEquals(1000, summation.getSum());
       }
   }
}
