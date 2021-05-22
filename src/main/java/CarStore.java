public class CarStore {
    // Машин в наличие
    private int product=0;
    // План продаж
    public final int SALES_PLAN = 10;
    // Кол-во продаж
    private int sales = 0;
    // Время оформления автомобиля
    private final int carTimeRegistration = 500;
    // Время приёмки нового автомобиля
    private final int timePickUpCar = 4000;

    public int getSales() {
        return sales;
    }

    public int getProduct() {
        return product;
    }
    /**
     * Покупка автомобиля
     */
    public synchronized void buyCar() {
        try {
            while (product == 0) {
                wait();
            }
            Thread.sleep(carTimeRegistration);
            product--;
            sales++;
            notifyAll();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
    /**
     * Добавление нового автомобился в салон
     */
    public synchronized void setCar() {
        try {
            while (product > 0) {
                wait();
            }
            Thread.sleep(timePickUpCar);
            product++;
            System.out.println("Производитель выпустил 1 авто");
            notify();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
}
