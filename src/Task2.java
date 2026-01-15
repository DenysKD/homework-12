public class Task2 {

    static void main(String[] args) {
        int counter = 21;

        Thread fizzThread = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                try {
                    FizzBuzzClass.fizz(i);
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread buzzThread = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                try {
                    FizzBuzzClass.buzz(i);
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread fizzBuzzzThread = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                try {
                    FizzBuzzClass.fizzbuzz(i);
                    Thread.sleep(100);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread numberThread = new Thread(() -> {
            for (int i = 0; i < counter; i++) {
                {
                    try {
                        FizzBuzzClass.number(i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzzThread.start();
        numberThread.start();
    }

}
