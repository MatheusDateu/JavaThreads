import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Thread t1 = null;
        try {

            t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        System.out.println("Index1: " + i);
                    }
                }
            });

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 100000) {
                        System.out.println(i + " esse e o Index2");
                        i++;
                    }

                }
            }).start();
            t1.start();

            Runnable t3 = () -> {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Opa");
                }
            };
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(t1.isAlive()){
                t1.interrupt();
            }
        }
    }
}