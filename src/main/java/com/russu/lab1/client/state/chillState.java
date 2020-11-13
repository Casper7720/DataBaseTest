package com.russu.lab1.client.state;

import com.russu.lab1.client.Client;
import com.russu.lab1.store.Store;

public class chillState extends State {
    public chillState(Client client) {
        super(client);
    }

    @Override
    public void getDream() {
        System.out.println("Я хочу отдыхать, чилить, флексить и страдать");
    }

    //Чилим
    @Override
    public void makeDream() {
        System.out.println("ЧЧИИИИИИЛ");
    }

    //Отказываем в походе в магазин
    @Override
    public void makeDream(Store store) {
        System.out.println("Мне нинада в магазин, сами идите");
    }

}
