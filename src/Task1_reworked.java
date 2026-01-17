public class Task1_reworked {

    private final int secondsRemain;
    private int count = 0;

    public Task1_reworked(int secondsRemain) {
        this.secondsRemain = secondsRemain;
    }

    public synchronized void regularSeconds() {
        while (count <= secondsRemain){
            try {
                if(count % 5 != 0 || count == 0) {
                    System.out.println("З моменту запуску програми минуло " + count + " секунд!");
                    count++;
                    Thread.sleep(1000);
                    notifyAll();
                }
                else wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void everyFiveSeconds() {
        while (count <= secondsRemain) {
            try {
                if (count % 5 == 0 && count != 0) {
                    System.out.println("Минуло " + count + " секунд!");
                    count++;
                    Thread.sleep(1000);
                    notifyAll();
                }
                else wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Task1_reworked t1r = new Task1_reworked(15);

        Thread regularThread = new Thread(() -> t1r.regularSeconds());
        Thread everyFiveSecondsThread = new Thread(() -> t1r.everyFiveSeconds());

        regularThread.start();
        everyFiveSecondsThread.start();
    }
}
