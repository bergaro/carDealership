public class Main {
    // Время нового визита покупателя
    private final static int buyerVisitTime = 7000;
    // Номер нового потока
    private static int nameCounter = 3;

    public static void main(String[] args) {
        CarStore store=new CarStore();

        new Thread(null, new Consumer(store), "Покупатель 1").start();
        getThreadSleep();
        new Thread(null, new Consumer(store), "Покупатель 2").start();
        getThreadSleep();
        new Thread(null, new Consumer(store), "Покупатель 3").start();
        getThreadSleep();
        Thread producer = new Thread(null, new Producer(store), "Автовоз");
        producer.setDaemon(true);
        producer.start();

        while (true) {
            if (store.getSales() < store.SALES_PLAN) {
                try {
                    Thread.sleep(buyerVisitTime);
                    new Thread(null, new Consumer(store), "Покупатель " + ++nameCounter).start();
                    getThreadSleep();
                    new Thread(null, new Consumer(store), "Покупатель " + ++nameCounter).start();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            } else {
                break;
            }
        }
    }
    /**
     * Обыкновенный таймаут потока
     * Создан для наглядности соблюдения порядка
     * реентерабельным локом в режиме честности.
     */
    private static void getThreadSleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}


