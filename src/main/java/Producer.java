class Producer implements Runnable{

    CarStore store;
    Producer(CarStore store){
        this.store=store;
    }
    public void run(){
        while (true) {
            if(store.getSales() == store.SALES_PLAN) {
                break;
            }
            store.setCar();
        }
    }
}