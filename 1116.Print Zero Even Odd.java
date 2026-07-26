import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;

    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore oddSemaphore = new Semaphore(0);
    private Semaphore evenSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x"
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);

            if (i % 2 == 1) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ZeroEvenOdd obj = new ZeroEvenOdd(5);

        Thread zero = new Thread(() -> {
            try {
                obj.zero(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread odd = new Thread(() -> {
            try {
                obj.odd(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread even = new Thread(() -> {
            try {
                obj.even(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        zero.start();
        odd.start();
        even.start();

        try {
            zero.join();
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
