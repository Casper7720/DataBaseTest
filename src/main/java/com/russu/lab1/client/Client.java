package com.russu.lab1.client;

import com.russu.lab1.client.state.State;
import com.russu.lab1.client.state.chillState;
import com.russu.lab1.client.state.searchProductsState;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;
import com.russu.lab1.store.Store;

import java.util.ArrayList;


public class Client {

    private String name;
    private State stateClient; // состояние клиента
    private Store storeDetected; // нахождение в магазине
    private ArrayList<AssortmentProduct> priceList;


    public Client(String name){
        this.name = name;
        priceList = new ArrayList<>();
        stateClient = new chillState(this);
    }

    public State getStateClient() {
        return stateClient;
    }

    public void setStateClient(State stateClient) {
        this.stateClient = stateClient;
    }

    public String getName() {
        return name;
    }

    public void setStoreDetected(Store storeDetected) {
        this.storeDetected = storeDetected;
    }

    public Store getStoreDetected() {
        return storeDetected;
    }


    //Вывод желаний
    public void getDream(){
        stateClient.getDream();
    }

    public void makeDream(){
        stateClient.makeDream();
    }
    public void makeDream(Store store){
        stateClient.makeDream(store);
    }




    //Возврат прайс листа клиента(списком и выводом в консоль)
    public ArrayList<AssortmentProduct> getPriceList() {
        return priceList;
    }
    public void getAllPriceList(){
        System.out.println(String.format("%s необходимо купить: ", this.name));
        for(int i=0; i < priceList.size(); i++){
            System.out.println(String.format("%s - %s единиц",
                    priceList.get(i).getProduct().getName(),
                    priceList.get(i).getCount())
            );
        }
        System.out.println();
    }


    // Добавление продуктов в список покупок
    public void setProductInPriceList(Product product, int count){
        AssortmentProduct assortmentProduct = new AssortmentProduct(product, count);
        if (priceList.size() == 0){
            priceList.add(assortmentProduct);
            setStateClient(new searchProductsState(this));
        }
        else {
            for (int i = 0; i < priceList.size(); i++) {
                if (priceList.get(i).getProduct().getName() == assortmentProduct.getProduct().getName()) {
                    priceList.get(i).countSummer(assortmentProduct.getCount());
                    break;
                } else if (i + 1 == priceList.size()) {
                    priceList.add(assortmentProduct);
                    break;
                }

            }
        }
    }
}
