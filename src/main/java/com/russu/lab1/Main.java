package com.russu.lab1;


import com.russu.lab1.client.Client;
import com.russu.lab1.employee.DeputyDirector;
import com.russu.lab1.employee.Director;
import com.russu.lab1.employee.Seller;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;
import com.russu.lab1.provider.Provider;
import com.russu.lab1.store.Store;

public class Main implements Runnable {


    public static void main(String[] args) {

        new Main().run();
    }

    @Override
    public void run() {
        //магазин
        Store store1 = new Store();
        store1.setActiveMoney(10_000);

        //поставщик
        Provider provider1 = new Provider("Lol");

        //Клиент
        Client client1 = new Client("TimCock");


        //работники магазина1
        Director director = new Director("Mike", store1);
        DeputyDirector deputyDirector = new DeputyDirector("Joh", store1);
        Seller seller1 = new Seller("Wood", store1);
        Seller seller2 = new Seller("Jack", store1);

        //сотрудники магазина
        store1.setDirector(director);
        store1.setDeputyDirector(deputyDirector);
        store1.setSellers(seller1);
        store1.setSellers(seller2);
        store1.getAllEmployees();

        //Поставщики магазина
        store1.setProviders(provider1, provider1, provider1);
        store1.getAllProviders();


        // продукты
        Product cheese = new Product("Cheese", 1);
        Product milk = new Product("Milk", 1);

        //продукты поставщика
        provider1.setAssortment(cheese);
        provider1.setAssortment(milk);
        provider1.getAllAssortment();

        // продукты магазина
        director.storeShopping(new AssortmentProduct(cheese, 45), new AssortmentProduct(milk, 122));
        store1.getAllAssortmentProducts();
        System.out.println(String.format("Активы магазина : %s", store1.getActiveMoney()));

        //Прайс лист клиента
        client1.setProductInPriceList(cheese, 4);
        client1.setProductInPriceList(milk, 1);
        client1.getAllPriceList();

        //Состояние клиента

        client1.makeDream(store1);
        client1.getDream();
        client1.getAllPriceList();
        client1.makeDream();
        store1.getAllAssortmentProducts();
        client1.getDream();
        client1.getAllPriceList();

        provider1.getAllAssortment();
    }
}
