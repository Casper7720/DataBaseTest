package com.russu.lab1.client.state;

import com.russu.lab1.client.Client;
import com.russu.lab1.store.Store;

public abstract class State {

    public Client client;

    public State(Client client){
        this.client = client;
    }

    //Метод возврата желений клиента
    public abstract void getDream();
    //Метод реализации желаний клиента
    public abstract void makeDream();

    public abstract void makeDream(Store store);
}
