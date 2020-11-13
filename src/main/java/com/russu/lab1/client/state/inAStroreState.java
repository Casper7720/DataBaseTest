package com.russu.lab1.client.state;

import com.russu.lab1.client.Client;
import com.russu.lab1.product.AssortmentProduct;
import com.russu.lab1.store.Store;

import java.util.ArrayList;
import java.util.Iterator;

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


        Iterator<AssortmentProduct> assortmentProductIterator = client.getPriceList().iterator();
        Iterator<AssortmentProduct> assortmentProductIteratorStore = client.getStoreDetected().getAssortmentProducts().iterator();

        while(assortmentProductIterator.hasNext()){

            AssortmentProduct assortmentProduct = assortmentProductIterator.next();

            while (assortmentProductIteratorStore.hasNext()){

                AssortmentProduct assortmentProductStore = assortmentProductIteratorStore.next();
                //Проверка соответсвтвия продукта
                if (assortmentProduct.getProduct().getName() ==
                        assortmentProductStore.getProduct().getName()){

                    //Проверка наличия необходимого количества(в магазине больше нужного количества)
                    if(assortmentProductStore.getCount() >
                            assortmentProduct.getCount()){

                        //Изменение количества остатка продукта в магазине
                        assortmentProductStore.setCount(
                                assortmentProductStore.getCount()- assortmentProduct.getCount()
                        );

                        //Удаление продукта из прайс листа
                        assortmentProductIterator.remove();
                        break;

                    }

                    //В магазине ровно столько продуктов, сколько и необходимо
                    else if (assortmentProductStore.getCount() ==
                            assortmentProduct.getCount()){

                        assortmentProductIterator.remove();
                        assortmentProductIteratorStore.remove();
                        break;

                    }

                    //В магазине недостаточно продуктов
                    else{

                        //Изменение необходимого количества продуктов покупателя
                        assortmentProduct.setCount(
                                assortmentProduct.getCount()-assortmentProductStore.getCount()
                        );

                        //Удаление продуктов из списка продуктов магазина
                        assortmentProductIteratorStore.remove();
                        break;

                    }

                }
            }
        }

    }
    // Переход при необходимости в другой магазин
    @Override
    public void makeDream(Store store) {
        System.out.println("Надо пойти в другой магазин");
        client.setStoreDetected(store);
    }
}
