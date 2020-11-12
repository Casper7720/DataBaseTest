package com.russu.lab1.client;

import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.product.Product;

import java.util.ArrayList;


public class Client {

    private String name;
    private ArrayList<AssortmentProduct> priceList;


    public Client(String name){
        this.name = name;
        priceList = new ArrayList<>();
    }

    // Добавление продуктов в список покупок
    public void setProductInPriceList(Product product, int count){
        AssortmentProduct assortmentProduct = new AssortmentProduct(product, count);
        if (priceList.size() == 0){
            priceList.add(assortmentProduct);
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
