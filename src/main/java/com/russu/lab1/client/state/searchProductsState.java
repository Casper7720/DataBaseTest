package com.russu.lab1.client.state;

import com.russu.lab1.client.Client;
import com.russu.lab1.store.Store;

public class searchProductsState extends State {
    public searchProductsState(Client client) {
        super(client);
    }

    @Override
    public void getDream() {
        System.out.println("Купить продукты, а то мама наругает(");
    }


    @Override
    public void makeDream() {
        System.out.println("Иду в магазин");
    }

    //Перемещение в магазин
    @Override
    public void makeDream(Store store) {
        client.setStateClient(new inAStroreState(this.client));
        client.setStoreDetected(store);
    }
}
