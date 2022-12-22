import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class N2 {
    public static void main(String[] args) {

        ArrayList<Integer> buf = new ArrayList<>();
        int max_size = 10;
        class Create extends Thread {
            @Override
            public void run() {
                synchronized (buf) {
                    for (int i = 0; i < 1000; i ++) {
                        if (buf.size() == max_size) {
                            try {
                                buf.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            int New_number = ThreadLocalRandom.current().nextInt(-10000, 10000);
                            buf.add(New_number);
                            buf.notifyAll();
                        }

                    }
                }
            }
        }

        class Read extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i ++) {
                    synchronized (buf) {
                        if (buf.size() == 0) {
                            try {
                                buf.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println(buf);
                            buf.clear();
                            buf.notifyAll();
                        }
                    }
                }
            }
        }
        Create write = new Create();
        Read read = new Read();
        write.start();
        read.start();
    }
}