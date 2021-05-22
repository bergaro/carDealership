
class Consumer implements Runnable{

    CarStore store;

    Consumer(CarStore store){
        this.store = store;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " зашёл в автосалон");
        if(store.getProduct() < 1) {
            System.out.println("Машин нет");
        }
        store.buyCar();
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком автомобиле");
        Thread.currentThread().interrupt();
    }
}