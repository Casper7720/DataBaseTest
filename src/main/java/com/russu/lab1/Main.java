package com.russu.lab1;


import com.russu.lab1.client.Client;
import com.russu.lab1.employee.DeputyDirector;
import com.russu.lab1.employee.Director;
import com.russu.lab1.employee.Seller;
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

        //поставщик
        Provider provider1 = new Provider("Lol");

        //Клиент
        Client client1 = new Client("TimCock");


        //работники магазина1
        Director director = new Director("Mike");
        DeputyDirector deputyDirector = new DeputyDirector("Joh");
        Seller seller1 = new Seller("Wood");
        Seller seller2 = new Seller("Jack");

        //сотрудники магазина
        store1.setDirector(director);
        store1.setDeputyDirector(deputyDirector);
        store1.setSellers(seller1);
        store1.setSellers(seller2);
        store1.getAllEmployees();


        // продукты
        Product cheese = new Product("Cheese", 1);
        Product milk = new Product("Milk", 1);

        //продукты поставщика
        provider1.setAssortment(cheese);
        provider1.setAssortment(milk);
        provider1.getAllAssortment();

        // продукты магазина
        store1.setProduct(cheese, 3);
        store1.setProduct(milk, 15);
        store1.getAllAssortmentProducts();

        //Прайс лист клиента
        client1.setProductInPriceList(cheese, 3);
        client1.setProductInPriceList(milk, 1);
        client1.getAllPriceList();
    }
}
