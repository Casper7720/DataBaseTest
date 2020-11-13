package com.russu.lab1.client.state;

import com.russu.lab1.client.Client;
import com.russu.lab1.store.Store;

public class inAStroreState extends State{
    public inAStroreState(Client client) {
        super(client);
    }

    @Override
    public void getDream() {
        System.out.println("Найти нужные продукты");
    }

    //Закупка в магазине
    @Override
    public void makeDream() {
        //Реализовать закупку продуктов в магазине
    }
    // Переход при необходимости в другой магазин
    @Override
    public void makeDream(Store store) {
        System.out.println("Надо пойти в другой магазин");
        client.setStoreDetected(store);
    }
}
