public class N1{
    public static class MyThread extends Thread {
        @Override
        public void run() {
            Thread cur = Thread.currentThread();
            System.out.println("Имя потока: " + cur.getName());
        }
    }

    public static void main(String []args){
        Thread one = new MyThread();
        one.start();
        Thread two = new MyThread();
        two.start();
    }
}