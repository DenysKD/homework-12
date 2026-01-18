public class Task2 {

    private final int count;
    private int current = 1;

    public Task2(int n) {
        this.count = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (current <= count) {
            if (current % 3 == 0 && current % 5 != 0) {
                if (current == count) System.out.print("fizz");
                else System.out.print("fizz, ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (current <= count) {
            if (current % 5 == 0 && current % 3 != 0) {
                if(current == count) System.out.print("buzz");
                else System.out.print("buzz, ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (current <= count) {
            if (current % 3 == 0 && current % 5 == 0) {
                if(current == count) System.out.print("fizzbuzz");
                else System.out.print("fizzbuzz, ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (current <= count) {
            if (current % 3 != 0 && current % 5 != 0) {
                if(current == count) System.out.print(current);
                else System.out.print(current + ", ");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        Task2 fb = new Task2(15);

        Thread fizzThread = new Thread(() -> {
            try { fb.fizz(); } catch (InterruptedException ignored) {}
        });

        Thread buzzThread = new Thread(() -> {
            try { fb.buzz(); } catch (InterruptedException ignored) {}
        });

        Thread fizzbuzzThread = new Thread(() -> {
            try { fb.fizzbuzz(); } catch (InterruptedException ignored) {}
        });

        Thread numberThread = new Thread(() -> {
            try { fb.number(); } catch (InterruptedException ignored) {}
        });

        fizzThread.start();
        buzzThread.start();
        fizzbuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzbuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
