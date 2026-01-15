public class Task1 {

    static void main(String[] args) {

        Thread firstThread = new Thread(() -> {
            for (int i = 0; true; i++) {
                if(i % 5 != 0) {
                    try {
                        System.out.println("Від запуску програми минуло - " + i + " секунд!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; true; i++) {
                if(i % 5 == 0 && i != 0) {
                    try {
                        System.out.println("Минуло - " + i + " секунд!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        firstThread.start();
        secondThread.start();


    }
}
