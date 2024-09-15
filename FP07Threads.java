import java.util.stream.IntStream;

public class FP07Threads {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            IntStream.rangeClosed(0,1000).forEach(data -> System.out.println(Thread.currentThread().getId()+":"+data));
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}
